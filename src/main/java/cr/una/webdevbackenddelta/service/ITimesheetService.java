package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;
import cr.una.webdevbackenddelta.model.TimesheetDetails;

import java.util.List;

/**
 * TimesheetService
 *
 * The Service for Timesheet
 */
public interface ITimesheetService {
    /**
     * Find timesheet by id
     * @param id identification of the timesheet
     * @return the timesheet found
     */
    public Timesheet findById (final long id) throws EntityNotFoundException;
    public Timesheet findDetailsByUser (final long id, final String user) throws EntityNotFoundException;

    /**
     * Method to find all entities
     * @return the list of entities of Timesheet
     */
    public List<Timesheet> findAll();

    /**
     * Method to create a new entity
     * @param timesheet the entity to create in the database
     * @return the timesheet created with the corresponding id
     */
    public Timesheet create (final Timesheet timesheet);

    /**
     * Method to update the entity in the database
     * @param timesheet the entity with new information to update
     * @return the updated timesheet
     */
    public Timesheet update (final Timesheet timesheet);

    /**
     * Method to delete a entity in the database
     * @param timesheet the entity to deleted
     */
    public void delete (final Timesheet timesheet);

    /**
     * Method to delete a entity in the database by id
     * @param id the id of the entity to delete
     */
    public void deleteById (final long id) throws EntityNotFoundException;


}
