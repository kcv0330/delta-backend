package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.IHoursDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;
import cr.una.webdevbackenddelta.service.HoursService;
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
public class HoursServiceTest {

    @InjectMocks
    private HoursService hoursService;

    @Mock
    private IHoursDao hoursDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        // given
        final Long id = 1l;
        Hours hours = new Hours();
        Hours hoursExpected;

        hours.setIdHours(id);
        hours.setHours(1);
        hours.setDate(new Date());

        given(hoursDao.findById(id)).willReturn(hours);

        // when
        hoursExpected = hoursService.findById(id);

        // then
        assertThat(hoursExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Hours hours = new Hours();

        hours.setIdHours(id);
        hours.setHours(1);
        hours.setDate(new Date());

        List<Hours> hoursList = Arrays.asList(hours);

        given(hoursDao.findAll()).willReturn(hoursList);

        // when
        List<Hours> hoursListExpected = hoursService.findAll();

        // then
        assertThat(hoursList).isEqualTo(hoursListExpected);
    }

    @Test
    public void testCreateHours() {
        // given
        final Long id = 1l;
        Hours hours = new Hours();

        hours.setIdHours(id);
        hours.setHours(1);
        hours.setDate(new Date());

        given(hoursDao.create(hours)).willReturn(hours);

        // when
        Hours hoursCreated = hoursService.create(hours);

        // then
        assertThat(hoursCreated).isNotNull();
    }

    @Test
    public void testUpdateHours() {
        // given
        final Long id = 1l;
        Hours hours = new Hours();

        hours.setIdHours(id);
        hours.setHours(1);
        hours.setDate(new Date());

        given(hoursDao.update(hours)).willReturn(hours);

        // when
        Hours hoursUpdated = hoursService.update(hours);

        // then
        assertThat(hoursUpdated).isNotNull();
    }

}
