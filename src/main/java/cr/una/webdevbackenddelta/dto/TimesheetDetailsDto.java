package cr.una.webdevbackenddelta.dto;
import cr.una.webdevbackenddelta.model.Hours;
import cr.una.webdevbackenddelta.model.User;
import lombok.Data;

import java.util.List;

/**
 * DTO for the entity TimesheetDetails
 */
@Data
public class TimesheetDetailsDto {
    private Long idTimesheetDetails;
    private Boolean paid;
    private Boolean approved;
    private UserDto user;
    private List<HoursDto> hoursList;
}
