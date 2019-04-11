package service.admin.model.group;

import service.admin.model.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="GROUPUSERS")
public class GroupUsers {

    @EmbeddedId
    private GroupUsersIdentity groupUsersIdentity;

    @Transient
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    private List<User> users;

    @Transient
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    private List<Group> groupList;

    private long lastModified;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

}
