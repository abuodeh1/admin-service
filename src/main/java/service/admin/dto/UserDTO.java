package service.admin.dto;

public class UserDTO extends DefaultDTO {

    private String username;
    private String email;
    private String name, nameAr;
    private String password;
    private String mobile;
    private boolean enabled;

    public UserDTO() {
    }

    public UserDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return code;
    }

    public void setUsername(String username) {
        this.username = code;
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

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String getCode() {
        return code;
    }

}
