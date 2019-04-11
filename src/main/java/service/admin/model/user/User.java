package service.admin.model.user;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;

@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "Users")
@AttributeOverride(name="code", column=@Column(name="username"))
public class User extends DefaultEntity /*implements UserDetails*/ {

    private String email;
    @NotNull
    private String password;
    private String mobile;

//    @JoinTable(name = "userroles")
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private List<UserRoles> roles;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId")
//    private List<UserPrivileges> privileges;

    public User() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    public List<UserRoles> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<UserRoles> roles) {
//        this.roles = roles;
//    }

//    public List<UserPrivileges> getPrivileges() {
//        return privileges;
//    }
//
//    public void setPrivileges(List<UserPrivileges> privileges) {
//        this.privileges = privileges;
//    }

}
