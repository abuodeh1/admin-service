package service.admin.model.location;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Audited
@EntityListeners(value = AuditingEntityListener.class)
@Entity(name="Governorates")
public class Governorate extends DefaultEntity {

    private String description;
    private String descriptionAr;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }
}
