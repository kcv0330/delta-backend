package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.model.Role;
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
 * Role DAO
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@Sql({
        "/import-roles.sql"
})
// TODO: This code is to persist the information in the database
// @Sql(scripts = {"/import-roles.sql"},
//        config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED))
public class RoleDaoTest {

    @Autowired
    private IRoleDao roleDao;

    @Test
    public void testFindById() {
        Role role = roleDao.findById(1);

        assertEquals(role.getName().toString(), "admin");
    }

    @Test
    public void testFindAll() {
        List<Role> roleList = roleDao.findAll();

        assertTrue(roleList.size() == 1);
    }

    @Test
    public void testCreate() {
        Role role = new Role();

        role.setIdRole(2l);
        role.setName("Reporting");

        roleDao.create(role);

        assertEquals(role.getIdRole(), Long.valueOf(2));
    }

    @Test
    public void testUpdate() {
        Role roleUpdated = new Role();

        roleUpdated.setIdRole(1L);
        roleUpdated.setName("ADMIN");

        roleDao.update(roleUpdated);

        Role role = roleDao.findById(1L);
        assertEquals(role.getName(), "ADMIN");
    }

    @Test
    public void testDelete() {
        Role roleDeleted = new Role();
        roleDeleted.setIdRole(2L);

        roleDao.delete(roleDeleted);

        Role role = roleDao.findById(2);
        assertTrue(role == null);
    }

    @Test
    public void testDeleteById() {
        roleDao.deleteById(1L);

        Role role = roleDao.findById(2);
        assertTrue(role == null);
    }
}

