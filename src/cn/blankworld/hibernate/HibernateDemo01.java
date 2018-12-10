package cn.blankworld.hibernate;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.blankworld.pojo.Product;
/**
 * hibernate 插入
 * @author Administrator
 *
 */
public class HibernateDemo01 {

	private static Product p;

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

//		随机价格
		Random random = new Random();

		session.beginTransaction();

		for (int i = 1; i <= 10; i++) {
			p = new Product();
			p.setName("iphone" + i);
			p.setPrice((random.nextDouble()*10000));
			session.save(p);
		}
		session.getTransaction().commit();

	}

	@Test
	public void testFun() {
		SessionFactory sf =new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
	}
}
