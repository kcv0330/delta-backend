package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;

import java.util.List;

/**
 * TimesheetDetailsService
 *
 * The Service for TimesheetDetails
 */
public interface ITimesheetDetailsService {
    /**
     * Find timesheetDetails by id
     * @param id identification of the timesheetDetails
     * @return the timesheetDetails found
     */
    public TimesheetDetails findById (final long id) throws EntityNotFoundException;

    /**
     * Method to find all entities
     * @return the list of entities of TimesheetDetails
     */
    public List<TimesheetDetails> findAll();

    /**
     * Method to create a new entity
     * @param timesheetDetails the entity to create in the database
     * @return the timesheetDetails created with the corresponding id
     */
    public TimesheetDetails create (final TimesheetDetails timesheetDetails);

    /**
     * Method to update the entity in the database
     * @param timesheetDetails the entity with new information to update
     * @return the updated timesheetDetails
     */
    public TimesheetDetails update (final TimesheetDetails timesheetDetails);

    /**
     * Method to delete a entity in the database
     * @param timesheetDetails the entity to deleted
     */
    public void delete (final TimesheetDetails timesheetDetails);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id) throws EntityNotFoundException;
}
