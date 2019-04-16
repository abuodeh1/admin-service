package service.admin.dto;

import java.util.List;

public class AddUserPrivilegeDTO {

    UserDTO userDTO;

    List<PrivilegeDTO> privilegeDTOs;


    public AddUserPrivilegeDTO(UserDTO userDTO, List<PrivilegeDTO> privilegeDTOs) {
        this.userDTO = userDTO;
        this.privilegeDTOs = privilegeDTOs;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<PrivilegeDTO> getPrivilegeDTOs() {
        return privilegeDTOs;
    }

    public void setPrivilegeDTOs(List<PrivilegeDTO> privilegeDTOs) {
        this.privilegeDTOs = privilegeDTOs;
    }
}
