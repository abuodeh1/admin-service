package service.admin.model.group;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GroupRoleIdentity implements Serializable {

    @Column(name = "groupId")
    private int groupId;
    @Column(name = "roleId")
    private int roleId;

    public GroupRoleIdentity(int groupId, int roleId) {

        this.groupId = groupId;
        this.roleId = roleId;
    }

    public GroupRoleIdentity() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
