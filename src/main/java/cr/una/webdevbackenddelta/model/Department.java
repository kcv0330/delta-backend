package cr.una.webdevbackenddelta.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department")
    @Getter
    @Setter
    private Long idDepartment;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    // Relationship definition
    @OneToMany(mappedBy = "department")
    @Getter @Setter
    private List<User> usersList;

}
