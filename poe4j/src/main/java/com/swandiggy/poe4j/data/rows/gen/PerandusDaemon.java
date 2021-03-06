
package com.swandiggy.poe4j.data.rows.gen;

import java.util.List;
import com.swandiggy.poe4j.data.annotations.DatFile;
import com.swandiggy.poe4j.data.annotations.Order;
import com.swandiggy.poe4j.data.rows.BaseRow;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@DatFile("PerandusDaemons")
public class PerandusDaemon
    extends BaseRow
{

    @Order(0)
    private MonsterVarieties monsterVarietiesKey;
    @Order(1)
    private Integer unknown1;
    @Order(2)
    private Integer unknown2;
    @Order(3)
    private Integer unknown3;
    @Order(4)
    private Integer unknown4;
    @Order(5)
    private List<Long> unknown5;
    @Order(6)
    private Boolean flag0;
    @Order(7)
    private List<Long> unknown7;

}
