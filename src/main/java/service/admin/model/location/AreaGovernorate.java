package service.admin.model.location;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "AreaGovernorate.getAreaGovernorateByAreaCode",
                query = "select c.governorates from AreaGovernorate c where c.areaGovernorateIdentity.areaId = (select u.id from areas u where u.code= ?1)")
})

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="AreaGovernorate")
public class AreaGovernorate {

    @EmbeddedId
    private AreaGovernorateIdentity areaGovernorateIdentity;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Areas.class)
    @JoinColumn(name = "areaId", insertable = false, updatable = false)
    private List<Areas> areas;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Governorates.class)
    @JoinColumn(name = "governorateId", insertable = false, updatable = false)
    private List<Governorates> governorates ;

    private long lastModified;

    public AreaGovernorate() {
        setLastModified(new Date().getTime());
    }

    public AreaGovernorate(AreaGovernorateIdentity areaGovernorateIdentity) {
        this.areaGovernorateIdentity = areaGovernorateIdentity;
        setLastModified(new Date().getTime());
    }

    public AreaGovernorateIdentity getAreaGovernorateIdentity() {
        return areaGovernorateIdentity;
    }

    public void setAreaGovernorateIdentity(AreaGovernorateIdentity areaGovernorateIdentity) {
        this.areaGovernorateIdentity = areaGovernorateIdentity;
    }

    public List<Areas> getAreas() {
        return areas;
    }

    public void setAreas(List<Areas> areas) {
        this.areas = areas;
    }

    public List<Governorates> getGovernorates() {
        return governorates;
    }

    public void setGovernorates(List<Governorates> governorates) {
        this.governorates = governorates;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }


}
