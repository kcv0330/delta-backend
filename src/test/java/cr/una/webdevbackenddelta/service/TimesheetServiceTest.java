package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.ITimesheetDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;
import cr.una.webdevbackenddelta.service.TimesheetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TimesheetServiceTest {

    @InjectMocks
    private TimesheetService timesheetService;

    @Mock
    private ITimesheetDao timesheetDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        // given
        final Long id = 1l;
        Timesheet timesheet = new Timesheet();
        Timesheet timesheetExpected;

        timesheet.setIdTimesheet(id);
        timesheet.setName("January 2020");
        timesheet.setStartDate(new Date());
        timesheet.setEndDate(new Date());

        given(timesheetDao.findById(id)).willReturn(timesheet);

        // when
        timesheetExpected = timesheetService.findById(id);

        // then
        assertThat(timesheetExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Timesheet timesheet = new Timesheet();

        timesheet.setIdTimesheet(id);
        timesheet.setName("January 2020");
        timesheet.setStartDate(new Date());
        timesheet.setEndDate(new Date());

        List<Timesheet> timesheetList = Arrays.asList(timesheet);

        given(timesheetDao.findAll()).willReturn(timesheetList);

        // when
        List<Timesheet> timesheetListExpected = timesheetService.findAll();

        // then
        assertThat(timesheetList).isEqualTo(timesheetListExpected);
    }

    @Test
    public void testCreateTimesheet() {
        // given
        final Long id = 1l;
        Timesheet timesheet = new Timesheet();

        timesheet.setIdTimesheet(id);
        timesheet.setName("January 2020");
        timesheet.setStartDate(new Date());
        timesheet.setEndDate(new Date());

        given(timesheetDao.create(timesheet)).willReturn(timesheet);

        // when
        Timesheet timesheetCreated = timesheetService.create(timesheet);

        // then
        assertThat(timesheetCreated).isNotNull();
    }

    @Test
    public void testUpdateTimesheet() {
        // given
        final Long id = 1l;
        Timesheet timesheet = new Timesheet();

        timesheet.setIdTimesheet(id);
        timesheet.setName("January 2020");
        timesheet.setStartDate(new Date());
        timesheet.setEndDate(new Date());

        given(timesheetDao.update(timesheet)).willReturn(timesheet);

        // when
        Timesheet timesheetUpdated = timesheetService.update(timesheet);

        // then
        assertThat(timesheetUpdated).isNotNull();
    }

}
