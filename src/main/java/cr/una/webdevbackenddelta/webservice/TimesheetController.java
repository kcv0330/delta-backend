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
import cr.una.webdevbackenddelta.dto.TimesheetDto;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import cr.una.webdevbackenddelta.service.ITimesheetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for Timesheet
 */
@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "timesheets")
public class TimesheetController {

    @Autowired
    private ITimesheetService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Timesheet
     * @return List of DTO Timesheet
     */
    @GetMapping()
    @ResponseBody
    public List<TimesheetDto> findAll() {
        List<Timesheet> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the timesheet by id
     * @return A timesheet found
     */
    @GetMapping("{id}")
    @ResponseBody
    public TimesheetDto findById(@PathVariable Long id) throws EntityNotFoundException {
        Timesheet timesheet = service.findById(id);
        return convertToDto(timesheet);
    }

    /**
     * Find the timesheetdetails of given timesheet by user connected
     * @return A timesheet found
     */
    @GetMapping("{id}/details")
    @ResponseBody
    public TimesheetDto findDetailsByUser(@AuthenticationPrincipal String username, @PathVariable Long id) throws EntityNotFoundException {
        Timesheet timesheet = service.findDetailsByUser(id, username);
        return convertToDto(timesheet);
    }

    /**
     * Save the new Timesheet
     * @param timesheetDto the timesheet saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TimesheetDto save(@Valid @RequestBody TimesheetDto timesheetDto) {
        Timesheet timesheet = convertToEntity(timesheetDto);
        return convertToDto(service.create(timesheet));
    }

    /**
     * Update the existing Timesheet
     * @param timesheetDto the timesheet saved
     * @return the timesheet updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TimesheetDto update(@Valid @RequestBody TimesheetDto timesheetDto) {
        Timesheet timesheet = convertToEntity(timesheetDto);
        return convertToDto(service.update(timesheet));
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
     * @param timesheet entity
     * @return the DTO
     */
    private TimesheetDto convertToDto(Timesheet timesheet) {
        TimesheetDto timesheetDto = modelMapper.map(timesheet, TimesheetDto.class);
        return timesheetDto;
    }

    private TimesheetDetailsDto convertToDto(TimesheetDetails timesheetDetails) {
        TimesheetDetailsDto timesheetDetailsDto = modelMapper.map(timesheetDetails, TimesheetDetailsDto.class);
        return timesheetDetailsDto;
    }

    /**
     * Convert from DTO to Entity
     * @param timesheetDto the DTO
     * @return the entity
     */
    private Timesheet convertToEntity(TimesheetDto timesheetDto) {
        Timesheet timesheet = modelMapper.map(timesheetDto, Timesheet.class);
        return timesheet;
    }
}
