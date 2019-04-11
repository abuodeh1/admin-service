package service.admin.model.group;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="Groups")
public class Group extends DefaultEntity {

    private String description;



    public Group() {
    }

    public Group(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
