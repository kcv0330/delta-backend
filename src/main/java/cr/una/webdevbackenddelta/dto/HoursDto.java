package cr.una.webdevbackenddelta.dto;
import lombok.Data;

import java.sql.Date;
import java.util.List;

/**
 * DTO for the entity Hours
 */
@Data
public class HoursDto {
    private Long idHours;
    private Date date;
    private Integer hours;
}
