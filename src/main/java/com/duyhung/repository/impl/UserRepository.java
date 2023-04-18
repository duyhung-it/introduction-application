package com.duyhung.repository.impl;

import com.duyhung.entity.User;
import com.duyhung.repository.IUserRepository;
import com.duyhung.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class UserRepository implements IUserRepository {
    @Override
    public User findByEmailAndPass(String email, String pass) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        User result = null;
        Transaction transaction = null;
        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User where email = :email and password = :password", User.class);
            query.setParameter("email",email)
                    .setParameter("password",pass);
            result = query.getSingleResult();
            transaction.commit();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
//            if(transaction != null) transaction.rollback();
        }
        return result;
    }
}
