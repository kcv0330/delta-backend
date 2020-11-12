package cr.una.webdevbackenddelta.dto;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * DTO for the entity Timesheet
 */
@Data
public class TimesheetDto {
    private Long idTimesheet;
    private String name;
    private Date startDate;
    private Date endDate;
    private List<TimesheetDetailsDto> timesheetDetailsList;
}
