package org.mentor.spring.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mentor.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    private  SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user;
            user = (User) session.load(User.class, Long.parseLong(id));
            session.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectData() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from User", User.class);
            List<User> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectDataById(String id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from User where id =:paramName");
            query.setParameter("paramName", Long.parseLong(id));
            return (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public User selectDataByLoginPassword(User user) {
//        try {
//            Session session = sessionFactory.openSession();
//            Query query = session.createQuery("from User where name =:name and password =:password");
//            query.setParameter("name", user.getName());
//            query.setParameter("password", user.getPassword());
//            return (User) query.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}



