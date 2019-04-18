package service.admin.model.location;

import javax.persistence.Column;
import java.io.Serializable;

public class AreaGovernorateIdentity  implements Serializable {


    @Column(name = "areaId")
    private int areaId;
    @Column(name = "governorateId")
    private int governorateId;

    public AreaGovernorateIdentity() {
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(int governorateId) {
        this.governorateId = governorateId;
    }
}


