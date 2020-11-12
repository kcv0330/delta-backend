package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.model.Role;

import java.util.List;

public interface IRoleService {


    /**
     * Method to find the entity by id
     * @param id the id of the entity to find
     * @return the corresponding UserDao
     */
    public Role findById (final long id);

    /**
     * Method to find all entities
     * @return the list of entities of UserDao
     */
    public List<Role> findAll();

    /**
     * Method to create a new entity
     * @param role the entity to create in the database
     * @return the user created with the corresponding id
     */
    public Role create (final Role role);

    /**
     * Method to update the entity in the database
     * @param role the entity with new information to update
     * @return the updated user
     */
    public Role update (final Role role);

    /**
     * Method to delete a entity in the database
     * @param role the entity to deleted
     */
    public void delete (final Role role);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id);
}
