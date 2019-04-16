package service.admin.dto;

public abstract class DefaultDTO {

    public int id;

    public String code;

    public abstract String getCode();

    public void setCode(String code){
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
