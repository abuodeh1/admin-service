package service.admin.model.privilege;

import service.admin.model.DefaultEntity;

import javax.persistence.Entity;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="PRIVILEGES")
public class Privilege extends DefaultEntity {

    private String description;

    public Privilege() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
