package cr.una.webdevbackenddelta.dao;

        import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
        import cr.una.webdevbackenddelta.model.User;
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

/**
 * Unit Test Class
 * User DAO UserDaoTest
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-users.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-users.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class UserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        User user = userDao.findById(1);

        assertEquals(user.getFirstName().toString(), "kevin");
    }

    @Test
    public void testFindAll() {
        List<User> userList = userDao.findAll();

        assertTrue(userList.size() == 1);
    }

    @Test
    public void testCreate() {
        User user = new User();

        user.setIdUser(2l);
        user.setFirstName("Prueba");
        user.setLastName("Prueba last");
        user.setPassword("pass1234");
        user.setEmail("kcv0331@gmail.com");
        user.setEnabled(true);
        user.setTokenExpired(false);
        //user.setCreateDate("2020-08-30 18:23:52.000000");


        userDao.create(user);

        assertEquals(user.getIdUser(), Long.valueOf(2));
    }

    @Test
    public void testUpdate() throws EntityNotFoundException {
        User userUpdated = new User();

        userUpdated.setIdUser(1L);
        userUpdated.setFirstName("kevin");

        userDao.update(userUpdated);

        User user = userDao.findById(1);
        assertEquals(user.getFirstName().toString(), "kevin");
    }

    @Test
    public void testDelete() throws EntityNotFoundException {
        User userDeleted = new User();
        userDeleted.setIdUser(2L);

        userDao.delete(userDeleted);

        User user = userDao.findById(2);
        assertTrue(user == null);
    }

    @Test
    public void testDeleteById() throws EntityNotFoundException {
        userDao.deleteById(1L);

        User user = userDao.findById(2);
        assertTrue(user == null);
    }
}
