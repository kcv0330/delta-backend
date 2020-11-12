package cr.una.webdevbackenddelta.dao;

import com.google.common.base.Preconditions;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HoursDao extends AbstractHibernateDao implements IHoursDao {

    @Override
    public Hours findById(final long id) throws EntityNotFoundException { return getCurrentSession().get(Hours.class, id); }

    @Override
    @SuppressWarnings("unchecked")
    public List<Hours> findAll() {
        return getCurrentSession().createQuery("from Hours").getResultList();
    }

    @Override
    public Hours create(Hours department) {
        Preconditions.checkNotNull(department);
        getCurrentSession().saveOrUpdate(department);

        return department;
    }

    @Override
    public Hours update(Hours department) {
        Preconditions.checkNotNull(department);
        return (Hours) getCurrentSession().merge(department);
    }

    @Override
    public void delete(Hours department) {
        Preconditions.checkNotNull(department);
        getCurrentSession().delete(department);
    }

    @Override
    public void deleteById(long id)throws EntityNotFoundException {
        final Hours department = findById(id);
        Preconditions.checkState(department != null);
        delete(department);
    }

}
