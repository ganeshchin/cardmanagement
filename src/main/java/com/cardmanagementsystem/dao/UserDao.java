package com.cardmanagementsystem.dao;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cardmanagementsystem.model.Userdetalis;

@Transactional
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;



	public Userdetalis saveUser(Userdetalis userdetails) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer isSuccess = 0;

		try {
			tx = session.beginTransaction();
			isSuccess = (Integer) session.save(userdetails);
			tx.commit();
			if (isSuccess >= 1) {
				return userdetails;
			} else {
				return null;
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}
}
