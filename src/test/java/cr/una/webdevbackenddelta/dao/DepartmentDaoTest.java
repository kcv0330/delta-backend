package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit Test Class
 * Department DAO
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-departments.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-departments.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class DepartmentDaoTest {

    @Autowired
    private IDepartmentDao departmentDao;

    @Test
    public void testFindById() throws EntityNotFoundException {
        Department department = departmentDao.findById(2);

        assertEquals(department.getName().toString(), "Marketing");
    }

    @Test
    public void testFindAll() {
        List<Department> departmentList = departmentDao.findAll();

        assertTrue(departmentList.size() == 3);
    }

    @Test
    public void testCreate() {
        Department department = new Department();

        department.setIdDepartment(4L);
        department.setName("Financial");

        departmentDao.create(department);

        assertEquals(department.getIdDepartment(), Long.valueOf(4));
    }

    @Test
    public void testUpdate() throws EntityNotFoundException {
        Department departmentUpdated = new Department();

        departmentUpdated.setIdDepartment(2L);
        departmentUpdated.setName("Technology - Development");

        departmentDao.update(departmentUpdated);

        Department department = departmentDao.findById(2);
        assertEquals(department.getName().toString(), "Technology - Development");
    }

    @Test
    public void testDelete() throws EntityNotFoundException {
        Department departmentDeleted = new Department();
        departmentDeleted.setIdDepartment(1L);

        departmentDao.delete(departmentDeleted);

        Department department = departmentDao.findById(1);
        assertTrue(department == null);
    }

    @Test
    public void testDeleteById() throws EntityNotFoundException {
        departmentDao.deleteById(1L);

        Department department = departmentDao.findById(1);
        assertTrue(department == null);
    }
}
