package cr.una.webdevbackenddelta.webservice;

import cr.una.webdevbackenddelta.common.Constants;
import cr.una.webdevbackenddelta.dto.HoursDto;
import cr.una.webdevbackenddelta.dto.UserDto;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;
import cr.una.webdevbackenddelta.model.User;
import cr.una.webdevbackenddelta.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for User
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "users")
public class UserController {
    @Autowired
    private IUserService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Save the new User
     * @param userDto the User saved
     * @return
     */
    @PostMapping(path = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto signUp(@Valid @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(service.create(user));
    }

    @GetMapping("/details")
    @ResponseBody
    public UserDto getUserDetails(@AuthenticationPrincipal String username) throws EntityNotFoundException {
        User user = service.findByUsername(username);
        return convertToDto(user);
    }

    /**
     * Convert from Entity to DTO
     * @param user entity
     * @return the DTO
     */
    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    /**
     * Convert from DTO to Entity
     * @param userDto the DTO
     * @return the entity
     */
    private User convertToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
