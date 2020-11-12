package cr.una.webdevbackenddelta.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "hours")
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hours")
    @Getter
    @Setter
    private Long idHours;
    @Column(name = "date")
    @Getter
    @Setter
    private Date date;
    @Column(name = "hours")
    @Getter
    @Setter
    private Integer hours;

    @ManyToOne
    @JoinColumn(name = "id_timesheetDetails", nullable = true)
    @Getter
    @Setter
    private TimesheetDetails timesheetDetails;

}
