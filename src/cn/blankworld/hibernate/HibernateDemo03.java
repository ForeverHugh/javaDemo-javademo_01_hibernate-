package cn.blankworld.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import cn.blankworld.pojo.Product;

/**
 * hql query
 * 
 * @author Administrator
 *
 */
public class HibernateDemo03 {

	private Query query;

	/**
	 * hql query notes: After 4.1
	 * org.hibernate.QueryException: Legacy-style query parameters (`?`) 
	 * are no longer supported; use JPA-style ordinal parameters (e.g., `?1`) 
	 * instead : from cn.blankworld.pojo.Product where id = ? 
	 * [from cn.blankworld.pojo.Product where id = ?]
	 */
	@Test
	public void fun() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		String hql_1 = "from Product where id = ?0"; // 占位符
		query = session.createQuery(hql_1);
		query.setParameter(0, 57);

		/*String hql_2 = "from Product where id = :idAlias"; // 别名
		query = session.createQuery(hql_2);
		query.setParameter("idAlias", 57);*/

		List<Product> products = query.list();
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
