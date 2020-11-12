package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.ITimesheetDetailsDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import cr.una.webdevbackenddelta.service.TimesheetDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TimesheetDetailsServiceTest {

    @InjectMocks
    private TimesheetDetailsService timesheetDetailsService;

    @Mock
    private ITimesheetDetailsDao timesheetDetailsDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        // given
        final Long id = 1l;
        TimesheetDetails timesheetDetails = new TimesheetDetails();
        TimesheetDetails timesheetDetailsExpected;

        timesheetDetails.setIdTimesheetDetails(id);
        timesheetDetails.setPaid(false);
        timesheetDetails.setApproved(false);

        given(timesheetDetailsDao.findById(id)).willReturn(timesheetDetails);

        // when
        timesheetDetailsExpected = timesheetDetailsService.findById(id);

        // then
        assertThat(timesheetDetailsExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        TimesheetDetails timesheetDetails = new TimesheetDetails();

        timesheetDetails.setIdTimesheetDetails(id);
        timesheetDetails.setPaid(false);
        timesheetDetails.setApproved(false);

        List<TimesheetDetails> timesheetDetailsList = Arrays.asList(timesheetDetails);

        given(timesheetDetailsDao.findAll()).willReturn(timesheetDetailsList);

        // when
        List<TimesheetDetails> timesheetDetailsListExpected = timesheetDetailsService.findAll();

        // then
        assertThat(timesheetDetailsList).isEqualTo(timesheetDetailsListExpected);
    }

    @Test
    public void testCreateTimesheetDetails() {
        // given
        final Long id = 1l;
        TimesheetDetails timesheetDetails = new TimesheetDetails();

        timesheetDetails.setIdTimesheetDetails(id);
        timesheetDetails.setPaid(false);
        timesheetDetails.setApproved(false);

        given(timesheetDetailsDao.create(timesheetDetails)).willReturn(timesheetDetails);

        // when
        TimesheetDetails timesheetDetailsCreated = timesheetDetailsService.create(timesheetDetails);

        // then
        assertThat(timesheetDetailsCreated).isNotNull();
    }

    @Test
    public void testUpdateTimesheetDetails() {
        // given
        final Long id = 1l;
        TimesheetDetails timesheetDetails = new TimesheetDetails();

        timesheetDetails.setIdTimesheetDetails(id);
        timesheetDetails.setPaid(false);
        timesheetDetails.setApproved(false);

        given(timesheetDetailsDao.update(timesheetDetails)).willReturn(timesheetDetails);

        // when
        TimesheetDetails timesheetDetailsUpdated = timesheetDetailsService.update(timesheetDetails);

        // then
        assertThat(timesheetDetailsUpdated).isNotNull();
    }

}
