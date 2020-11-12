package cr.una.webdevbackenddelta.initialData;

import cr.una.webdevbackenddelta.model.*;
import cr.una.webdevbackenddelta.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class to import initial data to database
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({
        "/import-initialdata.sql"
})
public class InitialDataTest {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ITimesheetService timesheetService;

    @Autowired
    private ITimesheetDetailsService timesheetDetailsService;

    @Autowired
    private IHoursService hoursService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Test
    public void loadDepartments() {
        List<Department> departmentList = departmentService.findAll();

        assertEquals(3,departmentList.size());
    }

    @Test
    public void loadTimesheets() {
        List<Timesheet> timesheetList = timesheetService.findAll();

        assertEquals(3,timesheetList.size());
    }

    @Test
    public void loadTimesheetDetails() {
        List<TimesheetDetails> timesheetDetailsList = timesheetDetailsService.findAll();

        assertEquals(3,timesheetDetailsList.size());
    }

    @Test
    public void loadHours() {
        List<Hours> hoursList = hoursService.findAll();

        assertEquals(3,hoursList.size());
    }

    @Test
    public void loadUsers() {
        List<User> hoursList = userService.findAll();

        assertEquals(3,hoursList.size());
    }

    @Test
    public void loadRoles() {
        List<Role> roleList = roleService.findAll();

        assertEquals(3,roleList.size());
    }
}
