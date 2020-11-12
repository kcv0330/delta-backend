package cr.una.webdevbackenddelta.dao;

/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract base DAO
 */
public class AbstractHibernateDao {

    /**
     * The sessionFactory of Hibernate
     */
    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * The current session of Hibernate connected with the Data Base
     * @return
     */
    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
