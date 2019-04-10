package service.admin.model.group;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name="GROUPUSERS")
public class GroupUsers {

    @EmbeddedId
    private GroupUsersIdentity groupUsersIdentity;

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
}
