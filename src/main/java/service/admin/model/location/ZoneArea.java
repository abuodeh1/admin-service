package service.admin.model.location;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "ZoneArea.getZoneAreaByZoneCode",
        query = "select c.areas from ZoneArea c where c.zoneAreaIdentity.zoneId = (select u.id from zones u where u.code= ?1)")
})

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="ZoneArea")
public class ZoneArea {


    @EmbeddedId
    private ZoneAreaIdentity zoneAreaIdentity;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Zones.class)
    @JoinColumn(name = "zoneId", insertable = false, updatable = false)
    private List<Zones> zones ;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Areas.class)
    @JoinColumn(name = "areaId", insertable = false, updatable = false)
    private List<Areas> areas;

    private long lastModified;

    public ZoneArea() {
        {
            setLastModified(new Date().getTime());
    }
}

    public ZoneArea(ZoneAreaIdentity zoneAreaIdentity) {
        this.zoneAreaIdentity = zoneAreaIdentity;
        setLastModified(new Date().getTime());
    }


    public ZoneAreaIdentity getZoneAreaIdentity() {
        return zoneAreaIdentity;
    }

    public void setZoneAreaIdentity(ZoneAreaIdentity zoneAreaIdentity) {
        this.zoneAreaIdentity = zoneAreaIdentity;
    }

    public List<Zones> getZones() {
        return zones;
    }

    public void setZones(List<Zones> zones) {
        this.zones = zones;
    }

    public List<Areas> getAreas() {
        return areas;
    }

    public void setAreas(List<Areas> areas) {
        this.areas = areas;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }


}