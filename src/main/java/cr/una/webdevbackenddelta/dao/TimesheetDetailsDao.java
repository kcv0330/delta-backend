package cr.una.webdevbackenddelta.dao;

import com.google.common.base.Preconditions;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.TimesheetDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimesheetDetailsDao extends AbstractHibernateDao implements ITimesheetDetailsDao {

    @Override
    public TimesheetDetails findById(final long id)throws EntityNotFoundException { return getCurrentSession().get(TimesheetDetails.class, id); }

    @Override
    @SuppressWarnings("unchecked")
    public List<TimesheetDetails> findAll() {
        return getCurrentSession().createQuery("from TimesheetDetails").getResultList();
    }

    @Override
    public TimesheetDetails create(TimesheetDetails timesheetdetails) {
        Preconditions.checkNotNull(timesheetdetails);
        getCurrentSession().saveOrUpdate(timesheetdetails);

        return timesheetdetails;
    }

    @Override
    public TimesheetDetails update(TimesheetDetails timesheetdetails) {
        Preconditions.checkNotNull(timesheetdetails);
        getCurrentSession().saveOrUpdate(timesheetdetails);

        return timesheetdetails;
    }

    @Override
    public void delete(TimesheetDetails timesheetdetails) {
        Preconditions.checkNotNull(timesheetdetails);
        getCurrentSession().delete(timesheetdetails);
    }

    @Override
    public void deleteById(long id)throws EntityNotFoundException {
        final TimesheetDetails timesheetdetails = findById(id);
        Preconditions.checkState(timesheetdetails != null);
        delete(timesheetdetails);
    }

}
