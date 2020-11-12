package cr.una.webdevbackenddelta.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "timesheetDetails")
public class TimesheetDetails {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timesheetDetails")
    @Getter
    @Setter
    private Long idTimesheetDetails;
    @Column(name = "approved")
    @Getter
    @Setter
    private Boolean approved;
    @Column(name = "paid")
    @Getter
    @Setter
    private Boolean paid;

    // Relationship definition
    @ManyToOne
    @JoinColumn(name = "id_timesheet", nullable = true)
    @Getter
    @Setter
    private Timesheet timesheet;

    @OneToMany(mappedBy = "timesheetDetails", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Hours> hoursList;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @Getter
    @Setter
    private User user;

}
