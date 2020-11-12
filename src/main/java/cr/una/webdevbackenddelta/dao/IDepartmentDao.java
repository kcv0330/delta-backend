package cr.una.webdevbackenddelta.dao;


import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Department;

import java.util.List;

/**
 * DAO Department
 */
public interface IDepartmentDao {
    public Department findById (final long id) throws EntityNotFoundException;
    public List<Department> findAll();
    public Department create (final Department department);
    public Department update (final Department department);
    public void delete (final Department department);
    public void deleteById (final long id) throws EntityNotFoundException;
}
