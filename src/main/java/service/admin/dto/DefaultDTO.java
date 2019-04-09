package service.admin.dto;

public abstract class DefaultDTO {

    public String code;

    public abstract String getCode();

    public void setCode(String code){
        this.code = code;
    }
}
