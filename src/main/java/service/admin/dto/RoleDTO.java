package service.admin.dto;

import java.util.List;

public class RoleDTO extends DefaultDTO {

    private String code;
    private String name, nameAr;
    private String description, descriptionAr;
    private boolean enabled;

    private List<Integer> Privileges;

    @Override
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

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Integer> getPrivileges() {
        return Privileges;
    }

    public void setPrivileges(List<Integer> privileges) {
        Privileges = privileges;
    }
}
