package service.admin.model.role;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.privilege.Privilege;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "RolePrivileges.getRolePrivilegesByRoleCode", query = "select c.privileges from RolePrivileges c where c.rolePrivilegesIdentity.roleId = (select u.id from Roles u where u.code = ?1)")
})

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="RolePrivileges")
public class RolePrivileges {

    @EmbeddedId
    private RolePrivilegeIdentity rolePrivilegesIdentity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private List<Role> roles;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Privilege.class)
    @JoinColumn(name = "privilegeId", insertable = false, updatable = false)
    private List<Privilege> privileges;

    private long lastModified;

    public RolePrivileges() {
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
