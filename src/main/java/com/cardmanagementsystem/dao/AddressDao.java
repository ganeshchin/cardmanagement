package com.cardmanagementsystem.dao;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cardmanagementsystem.model.AddressDetails;

@Transactional
@Repository
public class AddressDao {
	@Autowired
	private SessionFactory sessionFactory;

	public AddressDetails saveAddress(AddressDetails address) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
//		Integer isSuccess = 0;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(address);

			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return address;

	}

	public AddressDetails findAddressByUserId(Integer userid) {
		Session session = sessionFactory.openSession();

		AddressDetails addressdetails = null;

		try {
			Transaction tx = session.beginTransaction();
			addressdetails = (AddressDetails) session.get(AddressDetails.class, userid);
			tx.commit();
			if (addressdetails != null) {
				return addressdetails;
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
