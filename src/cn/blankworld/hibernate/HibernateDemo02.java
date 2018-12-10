package cn.blankworld.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.blankworld.pojo.Product;
/**
 * hibernate 获取
 * @author Administrator
 *
 */
public class HibernateDemo02 {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Product product = session.get(Product.class, 39);
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
	}
}
