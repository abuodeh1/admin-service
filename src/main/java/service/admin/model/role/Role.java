package service.admin.model.role;


import service.admin.model.DefaultEntity;
import service.admin.model.user.UserRole;

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
    private List<RolePrivilege> privileges;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private List<UserRole> roles;

    public Role() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RolePrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<RolePrivilege> privileges) {
        this.privileges = privileges;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
