package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.IDepartmentDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Department;
import cr.una.webdevbackenddelta.service.DepartmentService;
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
public class DepartmentServiceTest {

    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private IDepartmentDao departmentDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        // given
        final Long id = 1l;
        Department department = new Department();
        Department departmentExpected;

        department.setIdDepartment(id);
        department.setName("Technology");

        given(departmentDao.findById(id)).willReturn(department);

        // when
        departmentExpected = departmentService.findById(id);

        // then
        assertThat(departmentExpected).isNotNull();
    }

    @Test
    public void testFindAll() {
        // given
        final Long id = 1l;
        Department department = new Department();

        department.setIdDepartment(id);
        department.setName("Technology");

        List<Department> departmentList = Arrays.asList(department);

        given(departmentDao.findAll()).willReturn(departmentList);

        // when
        List<Department> departmentListExpected = departmentService.findAll();

        // then
        assertThat(departmentList).isEqualTo(departmentListExpected);
    }

    @Test
    public void testCreateDepartment() {
        // given
        final Long id = 1l;
        Department department = new Department();

        department.setIdDepartment(id);
        department.setName("Technology");

        given(departmentDao.create(department)).willReturn(department);

        // when
        Department departmentCreated = departmentService.create(department);

        // then
        assertThat(departmentCreated).isNotNull();
    }

    @Test
    public void testUpdateDepartment() {
        // given
        final Long id = 1l;
        Department department = new Department();

        department.setIdDepartment(id);
        department.setName("Technology");

        given(departmentDao.update(department)).willReturn(department);

        // when
        Department departmentUpdated = departmentService.update(department);

        // then
        assertThat(departmentUpdated).isNotNull();
    }

}
