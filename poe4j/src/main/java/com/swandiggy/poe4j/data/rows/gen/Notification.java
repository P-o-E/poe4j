
package com.swandiggy.poe4j.data.rows.gen;

import com.swandiggy.poe4j.data.annotations.DatFile;
import com.swandiggy.poe4j.data.annotations.Order;
import com.swandiggy.poe4j.data.rows.BaseRow;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@DatFile("Notifications")
public class Notification
    extends BaseRow
{

    @Order(0)
    private String id;
    @Order(1)
    private Boolean unknown0;
    @Order(2)
    private Boolean unknown1;
    @Order(3)
    private String message;
    @Order(4)
    private String unknown2;
    @Order(5)
    private Boolean unknown3;
    @Order(6)
    private Integer unknown4;

}
