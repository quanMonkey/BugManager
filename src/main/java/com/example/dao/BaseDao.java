package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by liuquan on 2017/7/7.
 */
@Repository
public class BaseDao<T> {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }

    /**
     * 获取hibernate原生session
     * @return
     */
    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void save(T t){
        hibernateTemplate.save(t);
    }

    public void delete(T t){
        hibernateTemplate.delete(t);
    }

    public void load(T t,Serializable id){
        hibernateTemplate.load(t,id);
    }

    public T get(Class<T> t,Serializable id){
       return hibernateTemplate.get(t,id);
    }

    public void update(T t){
        hibernateTemplate.update(t);
    }

    public void saveOrUpdate(T t){
        hibernateTemplate.saveOrUpdate(t);
    }

}
