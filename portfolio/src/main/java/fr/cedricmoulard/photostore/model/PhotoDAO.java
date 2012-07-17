package fr.cedricmoulard.photostore.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import fr.cedricmoulard.photostore.model.bean.Photo;

/**
 * @author zkessentials store
 * 
 *         This class provides functionality to access the {@code Photo} model
 *         storage system
 * 
 */
public class PhotoDAO {

	@SuppressWarnings("unchecked")
	public List<Photo> findAll() {
		Session session = StoreHibernateUtil.openSession();
//        Query query = session.createQuery("from photos");
//        List<Photo> photos = query.list();
        
        Criteria criteria = session.createCriteria(Photo.class).addOrder( Order.asc("index") );
        List<Photo> photos = criteria.list();

        session.close();
        return photos;
	}

	@SuppressWarnings("unchecked")
	public List<Photo> findAllAvailable() {
		Session session = StoreHibernateUtil.openSession();
        Transaction t = session.beginTransaction();

        Criteria criteria = session.createCriteria(Photo.class).add(Restrictions.eq("available", true));
        List<Photo> products = criteria.list();
        t.commit();
        session.close();

        return products;
	}

	public Photo remove(long productId) {
		Session session = StoreHibernateUtil.openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Photo.class).add(Restrictions.eq("id", productId));
        Photo product = (Photo)criteria.uniqueResult();

        if(product != null) {
            product.setAvailable(false);
            session.update(product);
        }

        t.commit();
        session.close();

        return product;
	}
	
	public void save(Photo photo) {
		Session session = StoreHibernateUtil.openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(photo);

        t.commit();
        session.close();

	}

	public Photo putOn(long productId) {
		Session session = StoreHibernateUtil.openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Photo.class).add(Restrictions.eq("id", productId));
        Photo product = (Photo)criteria.uniqueResult();

        if(product != null) {
            product.setAvailable(true);
            session.update(product);
        }

        t.commit();
        session.close();

        return product;
	}

}
