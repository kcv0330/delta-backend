package cr.una.webdevbackenddelta.dao;

import cr.una.webdevbackenddelta.model.Role;

import java.util.List;

/**
 * DAO Priority
 */
public interface IRoleDao {
    public Role findById (final long id);
    public List<Role> findAll();
    public Role create (final Role role);
    public Role update (final Role role);
    public void delete (final Role role);
    public void deleteById (final long id);
    public Role findByName(String name);
}