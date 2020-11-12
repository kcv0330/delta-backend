package cr.una.webdevbackenddelta.service;

import cr.una.webdevbackenddelta.dao.IHoursDao;
import cr.una.webdevbackenddelta.exception.EntityNotFoundException;
import cr.una.webdevbackenddelta.model.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * HoursService
 *
 * The Service for Hours
 */
@Service
@Transactional
public class HoursService implements IHoursService {

    @Autowired
    private IHoursDao dao;

    /**
     * Find hours by id
     *
     * @param id identification of the hours
     * @return the hours found
     */
    @Override
    public Hours findById(long id) throws EntityNotFoundException {
        return dao.findById(id);
    }

    /**
     * Method to find all entities
     *
     * @return the list of entities of Hours
     */
    @Override
    public List<Hours> findAll() {
        return dao.findAll();
    }

    /**
     * Method to create a new entity
     *
     * @param hours the entity to create in the database
     * @return the hours created with the corresponding id
     */
    @Override
    public Hours create(Hours hours) {
        return dao.create(hours);
    }

    /**
     * Method to update the entity in the database
     *
     * @param hours the entity with new information to update
     * @return the updated hours
     */
    @Override
    public Hours update(Hours hours) {
        return dao.update(hours);
    }

    /**
     * Method to delete a entity in the database
     *
     * @param hours the entity to deleted
     */
    @Override
    public void delete(Hours hours) {
        dao.delete(hours);
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
