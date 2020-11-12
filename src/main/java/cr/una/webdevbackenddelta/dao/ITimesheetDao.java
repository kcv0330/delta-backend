package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;

import java.util.List;

public interface ITimesheetDao {

    public Timesheet findById (final long id)throws EntityNotFoundException;
    public List<Timesheet> findAll();
    public Timesheet create (final Timesheet department);
    public Timesheet update (final Timesheet department);
    public void delete (final Timesheet department);
    public void deleteById (final long id)throws EntityNotFoundException;
}
