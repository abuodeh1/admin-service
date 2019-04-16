package service.admin.model.user;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.role.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)

@NamedQueries({
        @NamedQuery(name = "UserRoles.getUserRolesByUserCode", query = "select c.roles from UserRoles c where c.userRoleIdentity.userId = (select u.id from Users u where u.code = ?1)")
})

@Entity(name="UserRoles")
public class UserRoles {

    @EmbeddedId
    private UserRoleIdentity userRoleIdentity;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private List<User> users;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private List<Role> roles;

    private long lastModified;


    public UserRoles() {
        setLastModified(new Date().getTime());
    }

    public UserRoles(UserRoleIdentity userRoleIdentity) {
        this.userRoleIdentity = userRoleIdentity;
        setLastModified(new Date().getTime());
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public UserRoleIdentity getUserRoleIdentity() {
        return userRoleIdentity;
    }

    public void setUserRoleIdentity(UserRoleIdentity userRoleIdentity) {
        this.userRoleIdentity = userRoleIdentity;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
