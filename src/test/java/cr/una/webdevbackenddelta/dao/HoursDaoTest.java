package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;
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
        "/import-hours.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-hourss.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class HoursDaoTest {

    @Autowired
    private IHoursDao hoursDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        Hours hours = hoursDao.findById(2);

        assertEquals(hours.getHours().intValue(), 2);
    }

    @Test
    public void testFindAll() {
        List<Hours> hoursList = hoursDao.findAll();

        assertTrue(hoursList.size() == 3);
    }

    @Test
    public void testCreate() {
        Hours hours = new Hours();

        hours.setIdHours(4L);
        hours.setHours(5);
        hours.setDate(new Date());

        hoursDao.create(hours);

        assertEquals(hours.getIdHours(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() throws EntityNotFoundException {
        Hours hoursUpdated = new Hours();

        hoursUpdated.setIdHours(2L);
        hoursUpdated.setHours(11);
        hoursUpdated.setDate(new Date());

        hoursDao.update(hoursUpdated);

        Hours hours = hoursDao.findById(2);
        assertEquals(hours.getHours().intValue(), 11);
    }

    @Test
    public void testDelete() throws EntityNotFoundException {
        Hours hoursDeleted = new Hours();
        hoursDeleted.setIdHours(1L);

        hoursDao.delete(hoursDeleted);

        Hours hours = hoursDao.findById(1);
        assertTrue(hours == null);
    }

    @Test
    public void testDeleteById() throws EntityNotFoundException {
        hoursDao.deleteById(1L);

        Hours hours = hoursDao.findById(1);
        assertTrue(hours == null);
    }
}
