package cr.una.webdevbackenddelta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "timesheet")
public class Timesheet {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timesheet")
    @Getter
    @Setter
    private Long idTimesheet;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
    @Column(name = "start_date")
    @Getter
    @Setter
    private Date startDate;
    @Column(name = "end_date")
    @Getter
    @Setter
    private Date endDate;

    // Relationship definition

    @OneToMany(mappedBy = "timesheet", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TimesheetDetails> timesheetDetailsList;

    public List<TimesheetDetails> getTimesheetDetailsList() {
        return timesheetDetailsList;
    }

    public void setTimesheetDetailsList(List<TimesheetDetails> timesheetDetailsList) {
        this.timesheetDetailsList = timesheetDetailsList;
    }
}
