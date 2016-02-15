
package com.swandiggy.poe4j.data.rows.generated;

import java.util.List;
import com.swandiggy.poe4j.data.annotations.DatFile;
import com.swandiggy.poe4j.data.annotations.Order;
import com.swandiggy.poe4j.data.rows.BaseRow;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@DatFile
public class MonsterTypes
    extends BaseRow
{

    @Order(0)
    private String Id;
    @Order(1)
    private int Unknown1;
    @Order(2)
    private Boolean IsSummoned;
    @Order(3)
    private int Unknown2;
    @Order(4)
    private int Unknown3;
    @Order(5)
    private int Unknown4;
    @Order(6)
    private int Unknown5;
    @Order(7)
    private List<Tags> TagsKeys;
    @Order(8)
    private MonsterResistances MonsterResistancesKey;

}