package service.admin.model.group;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GroupMembersIdentity  implements Serializable {

    @Column(name = "groupId")
    private int groupId;
    @Column(name = "userId")
    private int userId;


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
