package cr.una.webdevbackenddelta.dao;
import com.google.common.base.Preconditions;
import cr.una.webdevbackenddelta.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDao extends AbstractHibernateDao implements IRoleDao {

    /**
     * Method to find the entity by id
     *
     * @param id the id of the entity to find
     * @return the corresponding Role
     */
    @Override
    public Role findById(long id) {
        return getCurrentSession().get(Role.class, id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Role
     */
    @Override
    public List<Role> findAll() {
        return getCurrentSession().createQuery("from Role").getResultList();
    }

    /**
     * Method to create a new entity
     *
     * @param Role the entity to create in the database
     * @return the Role created with the corresponding id
     */
    @Override
    public Role create(Role Role) {
        Preconditions.checkNotNull(Role);
        getCurrentSession().saveOrUpdate(Role);
        return Role;
    }

    /**
     * Method to update the entity in the database
     *
     * @param Role the entity with new information to update
     * @return the updated Role
     */
    @Override
    public Role update(Role Role) {
        Preconditions.checkNotNull(Role);
        return (Role) getCurrentSession().merge(Role);    }

    /**
     * Method to delete a entity in the database
     *
     * @param Role the entity to deleted
     */
    @Override
    public void delete(Role Role) {
        Preconditions.checkNotNull(Role);
        getCurrentSession().delete(Role);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) {
        final Role Role = findById(id);
        Preconditions.checkState(Role != null);
        delete(Role);
    }

    /**
     * Method to find the entity by id
     *
     * @param name the name of the entity to find
     * @return the corresponding task
     */
    @Override
    public Role findByName(String name) {
        Role role = null;
        Query query = getCurrentSession().createQuery("from Role r where r.name = :name");
        query.setParameter("name", name);

        if (query.getResultList().size() > 0) {
            role = (Role) query.getResultList().get(0);
        }

        return role;
    }

}