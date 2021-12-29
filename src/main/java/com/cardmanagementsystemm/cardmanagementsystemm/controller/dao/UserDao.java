package com.cardmanagementsystemm.cardmanagementsystemm.controller.dao;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cardmanagementsystemm.cardmanagementsystemm.model.Userdetalis;

//@Repository
//@Transactional
@Component
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public String savePerson(Userdetalis user) {
    	Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer userid=0;
        
        try {
           tx = session.beginTransaction();
            userid = (Integer)session.save(user);
           tx.commit();
//           if(isSuccess >= 1){
//               return "Success";
//           }else{
//               return "Error while Saving Person";
//           }
//           Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
//           employee.setSalary( salary );
//  		 session.update(employee); 
          
        } catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
        if(userid >= 1){
            return "Success";
        }else{
            return "Error while Saving Person";
        }
        
    }
    }
