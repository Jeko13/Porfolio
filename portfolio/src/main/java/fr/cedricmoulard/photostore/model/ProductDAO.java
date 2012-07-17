package fr.cedricmoulard.photostore.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import fr.cedricmoulard.photostore.model.bean.Photo;
import fr.cedricmoulard.photostore.model.bean.Product;

/**
 * @author zkessentials store
 * 
 *         This class provides functionality to access the {@code Product} model
 *         storage system
 * 
 */
public class ProductDAO {

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		Session session = StoreHibernateUtil.openSession();
        Criteria criteria = session.createCriteria(Product.class).addOrder( Order.asc("price") );
        List<Product> products= criteria.list();

        session.close();
        return products;
	}
	

}
