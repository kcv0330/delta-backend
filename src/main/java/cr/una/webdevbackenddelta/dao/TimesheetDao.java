package cr.una.webdevbackenddelta.dao;

import com.google.common.base.Preconditions;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Timesheet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimesheetDao extends AbstractHibernateDao implements ITimesheetDao {

    @Override
    public Timesheet findById(final long id) throws EntityNotFoundException { return getCurrentSession().get(Timesheet.class, id); }

    @Override
    @SuppressWarnings("unchecked")
    public List<Timesheet> findAll() {
        return getCurrentSession().createQuery("from Timesheet").getResultList();
    }

    @Override
    public Timesheet create(Timesheet timesheet) {
        Preconditions.checkNotNull(timesheet);
        getCurrentSession().saveOrUpdate(timesheet);

        return timesheet;
    }

    @Override
    public Timesheet update(Timesheet timesheet) {
        Preconditions.checkNotNull(timesheet);
        getCurrentSession().saveOrUpdate(timesheet);

        return timesheet;
    }

    @Override
    public void delete(Timesheet timesheet) {
        Preconditions.checkNotNull(timesheet);
        getCurrentSession().delete(timesheet);
    }

    @Override
    public void deleteById(long id) throws EntityNotFoundException{
        final Timesheet timesheet = findById(id);
        Preconditions.checkState(timesheet != null);
        delete(timesheet);
    }

}