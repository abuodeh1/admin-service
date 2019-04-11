package service.admin.dto;

import service.admin.model.user.User;

import java.util.List;

public class GroupUserDTO {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
