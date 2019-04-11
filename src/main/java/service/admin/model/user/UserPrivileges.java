package service.admin.model.user;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.privilege.Privilege;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="USERPRIVILEGE")
public class UserPrivileges {

    @EmbeddedId
    private UserPrivilegesIdentity userPrivilegesIdentity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private List<User> users;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Privilege.class)
    @JoinColumn(name = "privilegeId", insertable = false, updatable = false)
    private List<Privilege> privileges;

    private long lastModified;

    public UserPrivileges() {
        setLastModified(new Date().getTime());
    }


    public UserPrivilegesIdentity getUserPrivilegesIdentity() {
        return userPrivilegesIdentity;
    }

    public void setUserPrivilegesIdentity(UserPrivilegesIdentity userPrivilegesIdentity) {
        this.userPrivilegesIdentity = userPrivilegesIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
