package com.duyhung.repository.impl;

import com.duyhung.entity.Favorite;
import com.duyhung.entity.User;
import com.duyhung.repository.IFavoriteRepository;
import com.duyhung.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FavoriteRepository implements IFavoriteRepository {
    @Override
    public Boolean likeAVideo(Favorite favorite) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(favorite);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Favorite> getAllByUser(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        List<Favorite> result = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            result  = session.createQuery("from Favorite f where f.userId = :userId", Favorite.class)
                    .setParameter("userId",user.getId())
                    .getResultList();
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return result;
    }

    @Override
    public Boolean unlikeAVideo(Favorite favorite) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("delete Favorite where userId = :userId and videoId = :videoId")
                            .setParameter("userId",favorite.getUserId())
                            .setParameter("videoId",favorite.getVideoId())
                            .executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
            return false;
        }

    }

    @Override
    public Favorite getOne(Long userId, Long videoId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        List<Favorite> result = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
             result  = session.createQuery("from Favorite f where f.userId = :userId and f.videoId = :videoId", Favorite.class)
                    .setParameter("userId",userId)
                    .setParameter("videoId",videoId)
                    .getResultList();
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return (!result.isEmpty() ? result.get(0) : null);
    }
}
