package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-timesheetdetails.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-timesheetDetailss.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class TimesheetDetailsDaoTest {

    @Autowired
    private ITimesheetDetailsDao timesheetDetailsDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        TimesheetDetails timesheetDetails = timesheetDetailsDao.findById(2);

        assertEquals(timesheetDetails.getPaid(), true);
    }

    @Test
    public void testFindAll() {
        List<TimesheetDetails> timesheetDetailsList = timesheetDetailsDao.findAll();

        assertTrue(timesheetDetailsList.size() == 3);
    }

    @Test
    public void testCreate() {
        TimesheetDetails timesheetDetails = new TimesheetDetails();

        timesheetDetails.setIdTimesheetDetails(4L);
        timesheetDetails.setApproved(true);
        timesheetDetails.setPaid(true);

        timesheetDetailsDao.create(timesheetDetails);

        assertEquals(timesheetDetails.getIdTimesheetDetails(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() throws EntityNotFoundException {
        TimesheetDetails timesheetDetailsUpdated = new TimesheetDetails();

        timesheetDetailsUpdated.setIdTimesheetDetails(2L);
        timesheetDetailsUpdated.setApproved(false);
        timesheetDetailsUpdated.setPaid(false);

        timesheetDetailsDao.update(timesheetDetailsUpdated);

        TimesheetDetails timesheetDetails = timesheetDetailsDao.findById(2);
        assertEquals(timesheetDetails.getPaid(), false);
    }

    @Test
    public void testDelete() throws EntityNotFoundException {
        TimesheetDetails timesheetDetailsDeleted = new TimesheetDetails();
        timesheetDetailsDeleted.setIdTimesheetDetails(1L);

        timesheetDetailsDao.delete(timesheetDetailsDeleted);

        TimesheetDetails timesheetDetails = timesheetDetailsDao.findById(1);
        assertTrue(timesheetDetails == null);
    }

    @Test
    public void testDeleteById() throws EntityNotFoundException {
        timesheetDetailsDao.deleteById(1L);

        TimesheetDetails timesheetDetails = timesheetDetailsDao.findById(1);
        assertTrue(timesheetDetails == null);
    }
}
