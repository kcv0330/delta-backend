package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.ITimesheetDetailsDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TimesheetDetailsService
 *
 * The Service for TimesheetDetails
 */
@Service
@Transactional
public class TimesheetDetailsService implements ITimesheetDetailsService {

    @Autowired
    private ITimesheetDetailsDao dao;

    /**
     * Find timesheetDetails by id
     *
     * @param id identification of the timesheetDetails
     * @return the timesheetDetails found
     */
    @Override
    public TimesheetDetails findById(long id) throws EntityNotFoundException {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of TimesheetDetails
     */
    @Override
    public List<TimesheetDetails> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param timesheetDetails the entity to create in the database
     * @return the timesheetDetails created with the corresponding id
     */
    @Override
    public TimesheetDetails create(TimesheetDetails timesheetDetails) {
        return dao.create(timesheetDetails);
    }

    /**
     * Method to update the entity in the database
     *
     * @param timesheetDetails the entity with new information to update
     * @return the updated timesheetDetails
     */
    @Override
    public TimesheetDetails update(TimesheetDetails timesheetDetails) {
        return dao.update(timesheetDetails);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param timesheetDetails the entity to deleted
     */
    @Override
    public void delete(TimesheetDetails timesheetDetails) {
        dao.delete(timesheetDetails);
    }

    /**
     * Method to delete a entity in the database by id
     *
     * @param id the id of the entity to delete
     */
    @Override
    public void deleteById(long id) throws EntityNotFoundException {
        dao.deleteById(id);
    }
}
