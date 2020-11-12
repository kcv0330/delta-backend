package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.ITimesheetDao;
import cr.una.webdevbackenddelta.dao.TimesheetDetailsDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TimesheetService
 *
 * The Service for Timesheet
 */
@Service
@Transactional
public class TimesheetService implements ITimesheetService {

    @Autowired
    private ITimesheetDao dao;

    /**
     * Find timesheet by id
     *
     * @param id identification of the timesheet
     * @return the timesheet found
     */
    @Override
    public Timesheet findById(long id) throws EntityNotFoundException {
        return dao.findById(id);
    }

    @Override
    public Timesheet findDetailsByUser(long idTimesheet, String user) throws EntityNotFoundException {
        Timesheet ts = dao.findById(idTimesheet);
        for(TimesheetDetails x: ts.getTimesheetDetailsList()){
            if(user.equals(x.getUser().getUsername())){
                List<TimesheetDetails> tsd = new ArrayList<>();
                tsd.add(x);
                ts.setTimesheetDetailsList(tsd);
                return ts;
            }
        }
        ts.setTimesheetDetailsList(new ArrayList<>());
        return ts;
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Timesheet
     */
    @Override
    public List<Timesheet> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param timesheet the entity to create in the database
     * @return the timesheet created with the corresponding id
     */
    @Override
    public Timesheet create(Timesheet timesheet) {
        timesheet.getTimesheetDetailsList().forEach(x->{
            x.setTimesheet(timesheet);
            x.getHoursList().forEach(y->{
                y.setTimesheetDetails(x);
            });
        });
        return dao.create(timesheet);
    }

    /**
     * Method to update the entity in the database
     *
     * @param timesheet the entity with new information to update
     * @return the updated timesheet
     */
    @Override
    public Timesheet update(Timesheet timesheet) {
        timesheet.getTimesheetDetailsList().forEach(x->{
            x.setTimesheet(timesheet);
            x.getHoursList().forEach(y->{
                y.setTimesheetDetails(x);
            });
        });
        return dao.update(timesheet);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param timesheet the entity to deleted
     */
    @Override
    public void delete(Timesheet timesheet) {
        dao.delete(timesheet);
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
