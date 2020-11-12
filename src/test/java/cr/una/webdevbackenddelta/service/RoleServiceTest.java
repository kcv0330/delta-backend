package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.IRoleDao;
import cr.una.webdevbackenddelta.dao.IRoleDao;
import cr.una.webdevbackenddelta.model.Role;
import cr.una.webdevbackenddelta.model.Role;
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
public class RoleServiceTest {

    @InjectMocks
    private RoleService roleService;

    @Mock
    private IRoleDao roleDao;

    @Test
    public void testFindById() {
        // given
        final Long id = 1l;
        Role role = new Role();
        Role roleExpected;

        role.setIdRole(id);
        role.setName("Reporting");

        given(roleDao.findById(id)).willReturn(role);

        // when
        roleExpected = roleService.findById(id);

        // then
        assertThat(roleExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Role role = new Role();

        role.setIdRole(id);
        role.setName("Reporting");

        List<Role> roleList = Arrays.asList(role);

        given(roleDao.findAll()).willReturn(roleList);

        // when
        List<Role> roleListExpected = roleService.findAll();

        // then
        assertThat(roleList).isEqualTo(roleListExpected);
    }

    @Test
    public void testCreateRole() {
        // given
        final Long id = 1l;
        Role role = new Role();

        role.setIdRole(id);
        role.setName("Reporting");

        given(roleDao.create(role)).willReturn(role);

        // when
        Role roleCreated = roleService.create(role);

        // then
        assertThat(roleCreated).isNotNull();
    }

    @Test
    public void testUpdateRole() {
        // given
        final Long id = 1l;
        Role role = new Role();

        role.setIdRole(id);
        role.setName("Reporting");

        given(roleDao.update(role)).willReturn(role);

        // when
        Role roleUpdated = roleService.update(role);

        // then
        assertThat(roleUpdated).isNotNull();
    }

}
