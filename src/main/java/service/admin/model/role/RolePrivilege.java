package service.admin.model.role;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.privilege.Privilege;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="ROLEPRIVILEGE")
public class RolePrivilege {

    @EmbeddedId
    private RolePrivilegeIdentity rolePrivilegesIdentity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private List<Role> roles;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Privilege.class)
    @JoinColumn(name = "privilegeId", insertable = false, updatable = false)
    private List<Privilege> privileges;

    private long lastModified;

    public RolePrivilege() {
        setLastModified(new Date().getTime());
    }

    public RolePrivilegeIdentity getRolePrivilegesIdentity() {
        return rolePrivilegesIdentity;
    }

    public void setRolePrivilegesIdentity(RolePrivilegeIdentity rolePrivilegesIdentity) {
        this.rolePrivilegesIdentity = rolePrivilegesIdentity;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }
}
