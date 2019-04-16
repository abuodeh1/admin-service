package service.admin.model.group;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.role.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)

@NamedQueries({
        @NamedQuery(name = "GroupRoles.getGroupRolesByGroupCode", query = "select c.roles from GroupRoles c where c.groupRoleIdentity.groupId = (select g.id from Groups g where g.code = ?1)")
})


@Entity(name="GroupRoles")
public class GroupRoles {

    @EmbeddedId
    private GroupRoleIdentity groupRoleIdentity;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    private List<Group> groups;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private List<Role> roles;

    private long lastModified;

    public GroupRoles(GroupRoleIdentity groupRoleIdentity) {
        this.groupRoleIdentity = groupRoleIdentity;
        setLastModified(new Date().getTime());
    }

    public GroupRoles() {
        setLastModified(new Date().getTime());
    }

    public GroupRoleIdentity getGroupRoleIdentity() {
        return groupRoleIdentity;
    }

    public void setGroupRoleIdentity(GroupRoleIdentity groupRoleIdentity) {
        this.groupRoleIdentity = groupRoleIdentity;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}
