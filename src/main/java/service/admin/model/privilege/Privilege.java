package service.admin.model.privilege;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="PRIVILEGES")
public class Privilege extends DefaultEntity {

    private String description;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "privilegeId")
//    private List<UserPrivileges> users;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "roleId")
//    private List<RolePrivilege> roles;

    public Privilege() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<UserPrivileges> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<UserPrivileges> users) {
//        this.users = users;
//    }

//    public List<RolePrivilege> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<RolePrivilege> roles) {
//        this.roles = roles;
//    }
}
