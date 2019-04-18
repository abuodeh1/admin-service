package service.admin.dto;

public class ZoneDTO extends  DefaultDTO {

    private String description;
    private String descriptionAr;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    @Override
    public String getCode() {
        return code;
    }
}
