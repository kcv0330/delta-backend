package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-timesheets.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-timesheets.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class TimesheetDaoTest {

    @Autowired
    private ITimesheetDao timesheetDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        Timesheet timesheet = timesheetDao.findById(2);

        assertEquals(timesheet.getName(), "February 2020");
    }

    @Test
    public void testFindAll() {
        List<Timesheet> timesheetList = timesheetDao.findAll();

        assertTrue(timesheetList.size() == 3);
    }

    @Test
    public void testCreate() {
        Timesheet timesheet = new Timesheet();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        timesheet.setIdTimesheet(4L);
        timesheet.setName("April 2020");
        try{
            timesheet.setStartDate(dateFormat.parse("2020-04-01"));
            timesheet.setEndDate(dateFormat.parse("2020-05-01"));
        }catch (Exception e){

        }
        timesheetDao.create(timesheet);

        assertEquals(timesheet.getIdTimesheet(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() throws EntityNotFoundException {
        Timesheet timesheetUpdated = new Timesheet();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        timesheetUpdated.setIdTimesheet(2L);
        timesheetUpdated.setName("April 2020");

        timesheetDao.update(timesheetUpdated);

        Timesheet timesheet = timesheetDao.findById(2);
        assertEquals(timesheet.getName(), "April 2020");
    }

    @Test
    public void testDelete() throws EntityNotFoundException {
        Timesheet timesheetDeleted = new Timesheet();
        timesheetDeleted.setIdTimesheet(1L);

        timesheetDao.delete(timesheetDeleted);

        Timesheet timesheet = timesheetDao.findById(1);
        assertTrue(timesheet == null);
    }

    @Test
    public void testDeleteById() throws EntityNotFoundException {
        timesheetDao.deleteById(1L);

        Timesheet timesheet = timesheetDao.findById(1);
        assertTrue(timesheet == null);
    }
}
