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
import cr.una.webdevbackenddelta.dto.HoursDto;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;
import cr.una.webdevbackenddelta.service.IHoursService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for Hours
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "hours")
public class HoursController {

    @Autowired
    private IHoursService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Hours
     * @return List of DTO Hours
     */
    @GetMapping()
    @ResponseBody
    public List<HoursDto> findAll() {
        List<Hours> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the hours by id
     * @return A hours found
     */
    @GetMapping("{id}")
    @ResponseBody
    public HoursDto findById(@PathVariable Long id) throws EntityNotFoundException {
        Hours hours = service.findById(id);
        return convertToDto(hours);
    }

    /**
     * Save the new Hours
     * @param hoursDto the hours saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HoursDto save(@Valid @RequestBody HoursDto hoursDto) {
        Hours hours = convertToEntity(hoursDto);
        return convertToDto(service.create(hours));
    }

    /**
     * Update the existing Hours
     * @param hoursDto the hours saved
     * @return the hours updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HoursDto update(@Valid @RequestBody HoursDto hoursDto) {
        Hours hours = convertToEntity(hoursDto);
        return convertToDto(service.update(hours));
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
     * @param hours entity
     * @return the DTO
     */
    private HoursDto convertToDto(Hours hours) {
        HoursDto hoursDto = modelMapper.map(hours, HoursDto.class);
        return hoursDto;
    }

    /**
     * Convert from DTO to Entity
     * @param hoursDto the DTO
     * @return the entity
     */
    private Hours convertToEntity(HoursDto hoursDto) {
        Hours hours = modelMapper.map(hoursDto, Hours.class);
        return hours;
    }
}
