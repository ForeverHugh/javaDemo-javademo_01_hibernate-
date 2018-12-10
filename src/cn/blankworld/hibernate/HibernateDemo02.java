package cn.blankworld.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.blankworld.pojo.Product;

/**
 * hibernate 基本操作
 * 
 * @author Administrator
 *
 */
public class HibernateDemo02 {

	/**
	 * 根据id获取对象
	 */
	@Test
	public void fun() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Product product = session.get(Product.class, 39);
		System.out.println(product);
	}

}
