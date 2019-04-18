package service.admin.model.group;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.privilege.Privilege;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
  @NamedQuery(name = "GroupPrivileges.getGroupPrivilegesByGroupCode",
   query = "select c.privileges from GroupPrivileges c where c.groupPrivilegesIdentity.groupId = (select u.id from Groups u where u.code= ?1)")
})

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name="GroupPrivileges")
public class GroupPrivileges {

    @EmbeddedId
    private GroupPrivilegesIdentity groupPrivilegesIdentity;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    private List<Group> groups;
    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Privilege.class)
    @JoinColumn(name = "privilegeId", insertable = false, updatable = false)
    private List<Privilege> privileges;

    private long lastModified;

    public GroupPrivileges() {
        setLastModified(new Date().getTime());
    }

    public GroupPrivileges(GroupPrivilegesIdentity groupPrivilegesIdentity) {
        this.groupPrivilegesIdentity = groupPrivilegesIdentity;
        setLastModified(new Date().getTime());
    }

    public GroupPrivilegesIdentity getGroupPrivilegesIdentity() {
        return groupPrivilegesIdentity;
    }

    public void setGroupPrivilegesIdentity(GroupPrivilegesIdentity groupPrivilegesIdentity) {
        this.groupPrivilegesIdentity = groupPrivilegesIdentity;
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

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }


}
