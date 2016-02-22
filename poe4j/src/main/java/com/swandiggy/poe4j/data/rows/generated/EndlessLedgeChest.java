
package com.swandiggy.poe4j.data.rows.generated;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.swandiggy.poe4j.data.annotations.DatFile;
import com.swandiggy.poe4j.data.annotations.Order;
import com.swandiggy.poe4j.data.rows.BaseRow;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@DatFile("EndlessLedgeChests")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EndlessLedgeChest
    extends BaseRow
{

    @Order(0)
    private String id;
    @Order(1)
    private WorldArea worldArea;
    @Order(2)
    private List<BaseItemType> baseItemTypes;
    @Order(3)
    private String socketColour;

}