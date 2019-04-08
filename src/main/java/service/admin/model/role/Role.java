package service.admin.model.role;


import service.admin.model.DefaultEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="ROLES")
public class Role extends DefaultEntity {

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private List<RolePrivilege> Privileges;

    public Role() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RolePrivilege> getPrivileges() {
        return Privileges;
    }

    public void setPrivileges(List<RolePrivilege> privileges) {
        Privileges = privileges;
    }
}
