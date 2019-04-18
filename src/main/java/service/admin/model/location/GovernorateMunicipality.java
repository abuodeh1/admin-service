package service.admin.model.location;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@NamedQueries({
        @NamedQuery(name = "GovernorateMunicipality.getGovernorateMunicipalityByGovernorateCode",
                query = "select c.municipalitys from GovernorateMunicipality c where c.governorateMunicipalityIdentity.governorateId = (select u.id from governorates u where u.code= ?1)")
})

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="GovernorateMunicipality")
public class GovernorateMunicipality {

    @EmbeddedId
    private GovernorateMunicipalityIdentity governorateMunicipalityIdentity;


    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Governorates.class)
    @JoinColumn(name = "governorateId", insertable = false, updatable = false)
    private List<Governorates> governorates;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Municipality.class)
    @JoinColumn(name = "municipalityId", insertable = false, updatable = false)
    private List<Municipality> municipalitys ;

    private long lastModified;


    public GovernorateMunicipality(GovernorateMunicipalityIdentity governorateMunicipalityIdentity) {
        this.governorateMunicipalityIdentity = governorateMunicipalityIdentity;
        setLastModified(new Date().getTime());
    }

    public GovernorateMunicipalityIdentity getGovernorateMunicipalityIdentity() {
        return governorateMunicipalityIdentity;
    }

    public void setGovernorateMunicipalityIdentity(GovernorateMunicipalityIdentity governorateMunicipalityIdentity) {
        this.governorateMunicipalityIdentity = governorateMunicipalityIdentity;
    }

    public List<Governorates> getGovernorates() {
        return governorates;
    }

    public void setGovernorates(List<Governorates> governorates) {
        this.governorates = governorates;
    }

    public List<Municipality> getMunicipalitys() {
        return municipalitys;
    }

    public void setMunicipalitys(List<Municipality> municipalitys) {
        this.municipalitys = municipalitys;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
}
