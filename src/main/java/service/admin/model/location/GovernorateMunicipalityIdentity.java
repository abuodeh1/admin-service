package service.admin.model.location;

import javax.persistence.Column;
import java.io.Serializable;

public class GovernorateMunicipalityIdentity implements Serializable {


    @Column(name = "governorateId")
    private int governorateId;
    @Column(name = "municipalityId")
    private int municipalityId;

    public GovernorateMunicipalityIdentity() {
    }

    public int getGovernorateId() {
        return governorateId;
    }

    public void setGovernorateId(int governorateId) {
        this.governorateId = governorateId;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }
}


