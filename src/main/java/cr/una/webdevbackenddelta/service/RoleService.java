package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.IRoleDao;
import cr.una.webdevbackenddelta.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private IRoleDao dao;

    /**
     * Method to find the entity by id
     *
     * @param id the id of the entity to find
     * @return the corresponding RoleDao
     */
    @Override
    public Role findById(long id) {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of RoleDao
     */
    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param role the entity to create in the database
     * @return the role created with the corresponding id
     */
    @Override
    public Role create(Role role) {
        return dao.create(role);
    }

    /**
     * Method to update the entity in the database
     *
     * @param role the entity with new information to update
     * @return the updated role
     */
    @Override
    public Role update(Role role) {
        return dao.update(role);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param role the entity to deleted
     */
    @Override
    public void delete(Role role) {
        dao.delete(role);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }
}
