package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;

import java.util.List;

public interface IHoursDao {

    public Hours findById (final long id)throws EntityNotFoundException;
    public List<Hours> findAll();
    public Hours create (final Hours department);
    public Hours update (final Hours department);
    public void delete (final Hours department);
    public void deleteById (final long id)throws EntityNotFoundException;
}
