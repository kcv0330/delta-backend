package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.IUserDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.User;
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
public class UserServiceTest {


    @InjectMocks
    private UserService userService;

    @Mock
    private IUserDao userDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        // given
        final Long id = 1l;
        User user = new User();
        User userExpected;

        user.setIdUser(id);
        user.setFirstName("Prueba");
        user.setLastName("Prueba last");
        user.setPassword("pass1234");
        user.setEmail("kcv0331@gmail.com");

        given(userDao.findById(id)).willReturn(user);

        // when
        userExpected = userService.findById(id);

        // then
        assertThat(userExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        User user = new User();

        user.setIdUser(id);
        user.setFirstName("Prueba");
        user.setLastName("Prueba last");
        user.setPassword("pass1234");
        user.setEmail("kcv0331@gmail.com");

        List<User> userList = Arrays.asList(user);

        given(userDao.findAll()).willReturn(userList);

        // when
        List<User> departmentListExpected = userService.findAll();

        // then
        assertThat(userList).isEqualTo(departmentListExpected);
    }

    @Test
    public void testCreateUser() {
        // given
        final Long id = 1l;
        User user = new User();

        user.setIdUser(id);
        user.setFirstName("Prueba");
        user.setLastName("Prueba last");
        user.setPassword("pass1234");
        user.setEmail("kcv0331@gmail.com");

        given(userDao.create(user)).willReturn(user);

        // when
        User userCreated = userService.create(user);

        // then
        assertThat(userCreated).isNotNull();
    }

    @Test
    public void testUpdateUser() {
        // given
        final Long id = 1l;
        User user = new User();

        user.setIdUser(id);
        user.setFirstName("Prueba");
        user.setLastName("Prueba last");
        user.setPassword("pass1234");
        user.setEmail("kcv0331@gmail.com");

        given(userDao.update(user)).willReturn(user);

        // when
        User userUpdated = userService.update(user);

        // then
        assertThat(userUpdated).isNotNull();
    }
}
