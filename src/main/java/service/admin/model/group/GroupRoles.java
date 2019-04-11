package service.admin.model.group;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.role.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="GroupRoles")
public class GroupRoles {

    @EmbeddedId
    private GroupRoleIdentity groupRoleIdentity;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    private List<Group> groups;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private List<Role> roles;

    private long lastModified;

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