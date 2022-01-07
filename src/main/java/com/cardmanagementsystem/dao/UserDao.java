package com.cardmanagementsystem.dao;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cardmanagementsystem.model.UserDetails;

@Transactional
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDetails saveUser(UserDetails userdetails) {
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

	public UserDetails findUserById(Integer userId) {
		Session session = sessionFactory.openSession();

		UserDetails dbuser = null;

		try {
			Transaction tx = session.beginTransaction();

			dbuser = (UserDetails) session.get(UserDetails.class, userId);
			tx.commit();
			if (dbuser != null) {
				return dbuser;
			} else {
				return null;
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	public UserDetails findUserByIdForAddressDetails(int id) {
		Session session = sessionFactory.openSession();

		UserDetails dbuser = null;

		try {
			Transaction tx = session.beginTransaction();

			dbuser = (UserDetails) session.get(UserDetails.class, id);
			tx.commit();
			if (dbuser != null) {
				return dbuser;
			} else {
				return null;
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
