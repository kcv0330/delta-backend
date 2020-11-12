package cr.una.webdevbackenddelta.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * DTO for the entity UserDao
 */
@Data
public class UserDto {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String username;
    private Date createDate;
    private boolean enabled;
    private boolean tokenExpired;
    private DepartmentDto department;
}