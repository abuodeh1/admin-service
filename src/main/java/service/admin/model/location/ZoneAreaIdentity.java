package service.admin.model.location;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ZoneAreaIdentity implements Serializable {

    @Column(name = "zoneId")
    private int zoneId;
    @Column(name = "areaId")
    private int areaId;

    public int getZoneId() {
        return zoneId;
    }

    public ZoneAreaIdentity() {
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}
