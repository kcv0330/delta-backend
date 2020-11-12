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
import cr.una.webdevbackenddelta.dto.TimesheetDetailsDto;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import cr.una.webdevbackenddelta.service.ITimesheetDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for TimesheetDetails
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "timesheetDetails")
public class TimesheetDetailsController {

    @Autowired
    private ITimesheetDetailsService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all TimesheetDetails
     * @return List of DTO TimesheetDetails
     */
    @GetMapping()
    @ResponseBody
    public List<TimesheetDetailsDto> findAll() {
        List<TimesheetDetails> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the timesheetDetails by id
     * @return A timesheetDetails found
     */
    @GetMapping("{id}")
    @ResponseBody
    public TimesheetDetailsDto findById(@PathVariable Long id) throws EntityNotFoundException {
        TimesheetDetails timesheetDetails = service.findById(id);
        return convertToDto(timesheetDetails);
    }

    /**
     * Save the new TimesheetDetails
     * @param timesheetDetailsDto the timesheetDetails saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TimesheetDetailsDto save(@Valid @RequestBody TimesheetDetailsDto timesheetDetailsDto) {
        TimesheetDetails timesheetDetails = convertToEntity(timesheetDetailsDto);
        return convertToDto(service.create(timesheetDetails));
    }

    /**
     * Update the existing TimesheetDetails
     * @param timesheetDetailsDto the timesheetDetails saved
     * @return the timesheetDetails updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TimesheetDetailsDto update(@Valid @RequestBody TimesheetDetailsDto timesheetDetailsDto) {
        TimesheetDetails timesheetDetails = convertToEntity(timesheetDetailsDto);
        return convertToDto(service.update(timesheetDetails));
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
     * @param timesheetDetails entity
     * @return the DTO
     */
    private TimesheetDetailsDto convertToDto(TimesheetDetails timesheetDetails) {
        TimesheetDetailsDto timesheetDetailsDto = modelMapper.map(timesheetDetails, TimesheetDetailsDto.class);
        return timesheetDetailsDto;
    }

    /**
     * Convert from DTO to Entity
     * @param timesheetDetailsDto the DTO
     * @return the entity
     */
    private TimesheetDetails convertToEntity(TimesheetDetailsDto timesheetDetailsDto) {
        TimesheetDetails timesheetDetails = modelMapper.map(timesheetDetailsDto, TimesheetDetails.class);
        return timesheetDetails;
    }
}
