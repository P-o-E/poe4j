package com.swandiggy.poe4j.data.readers.field;

import com.swandiggy.poe4j.Poe4jException;
import com.swandiggy.poe4j.data.DatFileReader;
import com.swandiggy.poe4j.data.DatFileReaderFactory;
import com.swandiggy.poe4j.data.annotations.ReferenceOne;
import com.swandiggy.poe4j.data.readers.FieldReaders;
import com.swandiggy.poe4j.data.rows.BaseRow;
import com.swandiggy.poe4j.util.io.BinaryReader;
import com.swandiggy.poe4j.util.reflection.Poe4jReflection;
import lombok.Setter;
import org.springframework.cglib.proxy.LazyLoader;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Read a field that references another row by a shared key value.
 *
 * @author Jacob Swanson
 * @since 12/15/2015
 */
public class ReferenceOneFieldReader extends BaseFieldReader<Object> {

    @Setter
    private DatFileReaderFactory datFileReaderFactory;

    @Setter
    private FieldReaders fieldReaders;

    public ReferenceOneFieldReader() {
    }

    public ReferenceOneFieldReader(DatFileReaderFactory datFileReaderFactory, FieldReaders fieldReaders) {
        this.datFileReaderFactory = datFileReaderFactory;
        this.fieldReaders = fieldReaders;
    }

    @Override
    public boolean supports(Field field) {
        return field.isAnnotationPresent(ReferenceOne.class);
    }

    @Override
    protected Object readInternal(DatFileReader reader, BinaryReader br, Field field) {
        ReferenceOne annotation = field.getAnnotation(ReferenceOne.class);
        Field referencedKeyField = Poe4jReflection.getField(field.getType(), annotation.value());

        Object key = fieldReaders.read(reader, br, referencedKeyField);

        return Poe4jReflection.lazyLoad(field.getType(), (LazyLoader) () -> {
            DatFileReader<BaseRow> datFileReader = datFileReaderFactory.createUnsafe(field.getType());
            BaseRow referencedRow = datFileReader.read()
                    .filter(row -> Poe4jReflection.readProperty(row, annotation.value()).equals(key))
                    .findAny()
                    .orElse(null);

            if (annotation.required() && referencedRow == null) {
                throw new Poe4jException("Row was required and not found");
            }

            return referencedRow;
        });
    }

    @Override
    public int size(Field field) {
        ReferenceOne annotation = field.getAnnotation(ReferenceOne.class);
        Field referencedKeyField = Poe4jReflection.getField(field.getType(), annotation.value());

        return fieldReaders.size(referencedKeyField);
    }

}