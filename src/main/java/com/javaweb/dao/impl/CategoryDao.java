package com.javaweb.dao.impl;

import com.javaweb.dao.ICategoryDao;
import com.javaweb.entity.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;
@Repository
public class CategoryDao implements ICategoryDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public List<CategoryEntity> search(String keyWord) {
        Session session=entityManagerFactory.createEntityManager().unwrap(Session.class);
        String hql="from item as db where db.userName like :keyword";
        Query<CategoryEntity> query=session.createQuery(hql);
        query.setParameter("keyword","%"+keyWord+"%");
        return query.list();
    }
}
