package service.admin.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@MappedSuperclass
public abstract class DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int id;
    public String code;
    public String name;
    public boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //@Audited
    //@EntityListeners(AuditingEntityListener.class)
    @Entity(name="ROLES")
    public static class Role extends DefaultEntity {

        private String description;

        @OneToMany(fetch = FetchType.LAZY)
        @JoinColumn(name = "roleId")
        private List<RolePrivilege> Privileges;

        public Role() {
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<RolePrivilege> getPrivileges() {
            return Privileges;
        }

        public void setPrivileges(List<RolePrivilege> privileges) {
            Privileges = privileges;
        }
    }

    //@Audited
    //@EntityListeners(AuditingEntityListener.class)
    @Entity(name="ROLEPRIVILEGE")
    public static class RolePrivilege {

        @EmbeddedId
        private RolePrivilegeIdentity rolePrivilegesIdentity;

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

    public static class RolePrivilegeIdentity implements Serializable {


        @Column(name = "roleId")
        private int roleId;
        @Column(name = "privilegesId")
        private int privilegesId;

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public int getPrivilegesId() {
            return privilegesId;
        }

        public void setPrivilegesId(int privilegesId) {
            this.privilegesId = privilegesId;
        }
    }
}
