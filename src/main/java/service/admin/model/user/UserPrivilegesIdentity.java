package service.admin.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPrivilegesIdentity implements Serializable {

    @Column(name = "userId")
    private int userId;
    @Column(name = "privilegeId")
    private int privilegeId;

    public UserPrivilegesIdentity() {
    }

    public UserPrivilegesIdentity(int userId, int privilegeId) {
        this.userId = userId;
        this.privilegeId = privilegeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

}
