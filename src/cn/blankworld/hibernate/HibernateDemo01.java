package cn.blankworld.hibernate;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.blankworld.pojo.Product;

/**
 * hibernate 增删改操作
 * 
 * @author Administrator
 *
 */
public class HibernateDemo01 {

	private Product p;

	/**
	 * add
	 */
	@Test
	public void funAdd() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

//		随机价格
		Random random = new Random();

		session.beginTransaction();

		for (int i = 1; i <= 10; i++) {
			p = new Product((random.nextDouble() * 10000), "iphone" + i);
			session.save(p);
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/**
	 * delete
	 */
	@Test
	public void funDelete() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Product product = session.get(Product.class, 37);
		session.delete(product);

		session.getTransaction().commit();
		session.close();
		sf.close();
	}

	/**
	 * Alter
	 */
	@Test
	public void funAlter() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Product product = session.get(Product.class, 57);
		if (product != null) {
			session.beginTransaction();
			product.setPrice(500D);
			session.update(product);
			session.getTransaction().commit();
		}
		session.close();
		sf.close();
	}
}
