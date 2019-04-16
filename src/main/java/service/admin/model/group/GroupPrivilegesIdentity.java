package service.admin.model.group;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GroupPrivilegesIdentity implements Serializable {

    @Column(name = "groupId")
    private int groupId;
    @Column(name = "privilegeId")
    private int privilegeId;

    public GroupPrivilegesIdentity() {
    }

    public GroupPrivilegesIdentity(int groupId, int privilegeId) {
        this.groupId = groupId;
        this.privilegeId = privilegeId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

}
