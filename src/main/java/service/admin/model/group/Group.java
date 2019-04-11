package service.admin.model.group;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="GROUPS")
public class Group extends DefaultEntity {

    private String description;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "groupId")
//    private List<GroupRoles> roles;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "privilegeId")
//    private List<GroupPrivileges> privileges;
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private List<GroupUsers> users;

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

//    public List<GroupRoles> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<GroupRoles> roles) {
//        this.roles = roles;
//    }
//
//    public List<GroupPrivileges> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(List<GroupPrivileges> privileges) {
//        this.privileges = privileges;
//    }
//
//    public List<GroupUsers> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<GroupUsers> users) {
//        this.users = users;
//    }
}
