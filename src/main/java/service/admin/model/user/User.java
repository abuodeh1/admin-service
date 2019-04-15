package service.admin.model.user;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import service.admin.model.DefaultEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = "Users.addUserEx", query = "select c.roles from UserRoles c where c.userRoleIdentity.userId = (select u.id from Users u where u.code = ?1)")

})


@Audited
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "Users")
@AttributeOverride(name="code", column=@Column(name="username"))
public class User extends DefaultEntity /*implements UserDetails*/ {

    private String email;
    @NotNull
    private String password;
    private String mobile;

    public User() {}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
