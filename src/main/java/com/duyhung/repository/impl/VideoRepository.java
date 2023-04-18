package com.duyhung.repository.impl;

import com.duyhung.entity.Video;
import com.duyhung.repository.IVideoRepository;
import com.duyhung.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class VideoRepository implements IVideoRepository {

    @Override
    public Long save(Video sVideo) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        Long videoId = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            videoId = (Long) session.save("videos",sVideo);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();

        }
        return videoId;
    }

    @Override
    public List<Video> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        List<Video> listResults = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            listResults = session.createQuery("from Video",Video.class).getResultList();
            transaction.commit();
        }catch (Exception ex){
            if(transaction != null) transaction.rollback();
            System.out.println(ex.getMessage());
        }
        return listResults;
    }

    @Override
    public Video findById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        Video results = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(Video.class,id);
            transaction.commit();
        }catch (Exception ex){
            if(transaction != null) transaction.rollback();
            System.out.println(ex.getMessage());
        }
        return results;
    }

    @Override
    public Boolean remove(Video video) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.remove(video);
            transaction.commit();
            return true;
        }catch (Exception ex){
            if(transaction != null) transaction.rollback();
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean update(Video video) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        Long videoId = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.update("videos",video);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Video> getVideoFavorite(Long userId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        List<Video> listResults = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            listResults = session.createQuery("select v from Video v " +
                    "join v.favorites f where f.userId = :userId",Video.class)
                    .setParameter("userId",userId)
                    .getResultList();
            transaction.commit();
        }catch (Exception ex){
            if(transaction != null) transaction.rollback();
            System.out.println(ex.getMessage());
        }
        return listResults;
    }

}
