package service.admin.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRoleIdentity implements Serializable {

    @Column (name = "userId")
    private int userId;
    @Column(name = "roleId")
    private int roleId;


    public UserRoleIdentity() {
    }

    public UserRoleIdentity(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
