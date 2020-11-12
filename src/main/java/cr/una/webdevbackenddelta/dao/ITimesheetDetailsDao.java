package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;

import java.util.List;

public interface ITimesheetDetailsDao {

    public TimesheetDetails findById (final long id)throws EntityNotFoundException;
    public List<TimesheetDetails> findAll();
    public TimesheetDetails create (final TimesheetDetails department);
    public TimesheetDetails update (final TimesheetDetails department);
    public void delete (final TimesheetDetails department);
    public void deleteById (final long id)throws EntityNotFoundException;
}
