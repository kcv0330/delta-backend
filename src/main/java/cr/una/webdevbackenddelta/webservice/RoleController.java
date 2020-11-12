package cr.una.webdevbackenddelta.webservice;


import cr.una.webdevbackenddelta.common.Constants;
import cr.una.webdevbackenddelta.dto.RoleDto;
import cr.una.webdevbackenddelta.model.Role;
import cr.una.webdevbackenddelta.service.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "roles")
public class RoleController {

    @Autowired
    private IRoleService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Role
     * @return List of DTO Role
     */
    @GetMapping()
    @ResponseBody
    public List<RoleDto> findAll() {
        List<Role> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the role by id
     * @return A role found
     */
    @GetMapping("{id}")
    @ResponseBody
    public RoleDto findById(@PathVariable Long id) {
        Role role = service.findById(id);
        return convertToDto(role);
    }

    /**
     * Save the new Role
     * @param roleDto the role saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoleDto save(@Valid @RequestBody RoleDto roleDto) {
        Role role = convertToEntity(roleDto);
        return convertToDto(service.create(role));
    }

    /**
     * Update the existing Role
     * @param roleDto the role saved
     * @return the role updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoleDto update(@Valid @RequestBody RoleDto roleDto) {
        Role role = convertToEntity(roleDto);
        return convertToDto(service.update(role));
    }

    /**
     * Delete user by id
     * @param id the id of the entity
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    /**
     * Convert from Entity to DTO
     * @param role entity
     * @return the DTO
     */
    private RoleDto convertToDto(Role role) {
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        return roleDto;
    }

    /**
     * Convert from DTO to Entity
     * @param roleDto the DTO
     * @return the entity
     */
    private Role convertToEntity(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        return role;
    }
}
