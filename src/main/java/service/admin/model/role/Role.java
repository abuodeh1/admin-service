package service.admin.model.role;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="Roles")
public class Role extends DefaultEntity {

    private String description;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "roleId")
//    private List<RolePrivileges> privileges;

//    @JoinTable(name = "userroles")
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "roleId")
//    private List<UserRoles> roles;

    public Role() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<RolePrivileges> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(List<RolePrivileges> privileges) {
//        this.privileges = privileges;
//    }

//    public List<UserRoles> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<UserRoles> roles) {
//        this.roles = roles;
//    }
}
