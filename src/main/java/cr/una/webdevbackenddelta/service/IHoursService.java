package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;

import java.util.List;

/**
 * HoursService
 *
 * The Service for Hours
 */
public interface IHoursService {
    /**
     * Find hours by id
     * @param id identification of the hours
     * @return the hours found
     */
    public Hours findById (final long id) throws EntityNotFoundException;

    /**
     * Method to find all entities
     * @return the list of entities of Hours
     */
    public List<Hours> findAll();

    /**
     * Method to create a new entity
     * @param hours the entity to create in the database
     * @return the hours created with the corresponding id
     */
    public Hours create (final Hours hours);

    /**
     * Method to update the entity in the database
     * @param hours the entity with new information to update
     * @return the updated hours
     */
    public Hours update (final Hours hours);

    /**
     * Method to delete a entity in the database
     * @param hours the entity to deleted
     */
    public void delete (final Hours hours);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id) throws EntityNotFoundException;
}
