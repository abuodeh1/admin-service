package service.admin.model.group;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)

@NamedQueries({
        @NamedQuery(name = "GroupUsers.getGroupUsersByGroupCode", query = "select c.users from GroupUsers c where c.groupUsersIdentity.groupId = (select g.id from Groups g where g.code = ?1)")
})
@Entity(name="GroupUsers")
public class GroupUsers {

    @EmbeddedId
    private GroupUsersIdentity groupUsersIdentity;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    private List<Group> groups;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private List<User> users;


    private long lastModified;

    public GroupUsers(GroupUsersIdentity groupUsersIdentity) {
        this.groupUsersIdentity = groupUsersIdentity;
        setLastModified(new Date().getTime());
    }

    public GroupUsers() {
        setLastModified(new Date().getTime());
    }

    public GroupUsersIdentity getGroupUsersIdentity() {
        return groupUsersIdentity;
    }

    public void setGroupUsersIdentity(GroupUsersIdentity groupUsersIdentity) {
        this.groupUsersIdentity = groupUsersIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
