package com.javaweb.dao.impl;

import com.javaweb.dao.IUserDao;
import com.javaweb.entity.UserEntity;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao implements IUserDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private EntityManager entityManager;




    @Override
    public List<UserEntity> getAll() {
        Session session=entityManagerFactory.createEntityManager().unwrap(Session.class);
        String hql="FROM user";
        Query<UserEntity> userEntityQuery=session.createQuery(hql);
        List<UserEntity> list=userEntityQuery.list();

        return  list;
    }

    @Override
    public List<UserEntity> search(String keyWord) {
        Session session=entityManagerFactory.createEntityManager().unwrap(Session.class);
        String hql="FROM user as db where db.userName like :keyword";
        Query<UserEntity> query=session.createQuery(hql);
        query.setParameter("keyword","%"+keyWord+"%");
        List<UserEntity> list=query.list();
        return list;
    }
}
