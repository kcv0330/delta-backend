/*
 *
 *  *
 *  *
 *  * Universidad Nacional de Costa Rica  2020
 *  *
 *  * mike@guzmanalan.com
 *  *
 *  *
 *
 *
 */

package cr.una.webdevbackenddelta.webservice;

import cr.una.webdevbackenddelta.common.Constants;
import cr.una.webdevbackenddelta.dto.DepartmentDto;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Department;
import cr.una.webdevbackenddelta.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for Department
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Department
     * @return List of DTO Department
     */
    @GetMapping()
    @ResponseBody
    public List<DepartmentDto> findAll() {
        List<Department> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the department by id
     * @return A department found
     */
    @GetMapping("{id}")
    @ResponseBody
    public DepartmentDto findById(@PathVariable Long id) throws EntityNotFoundException {
        Department department = service.findById(id);
        return convertToDto(department);
    }
    /**
     * Save the new Department
     * @param departmentDto the department saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DepartmentDto save(@Valid @RequestBody DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        return convertToDto(service.create(department));
    }

    /**
     * Update the existing Department
     * @param departmentDto the department saved
     * @return the department updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DepartmentDto update(@Valid @RequestBody DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        return convertToDto(service.update(department));
    }

    /**
     * Delete user by id
     * @param id the id of the entity
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) throws EntityNotFoundException {
        service.deleteById(id);
    }
    
    /**
     * Convert from Entity to DTO
     * @param department entity
     * @return the DTO
     */
    private DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }

    /**
     * Convert from DTO to Entity
     * @param departmentDto the DTO
     * @return the entity
     */
    private Department convertToEntity(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        return department;
    }
}
