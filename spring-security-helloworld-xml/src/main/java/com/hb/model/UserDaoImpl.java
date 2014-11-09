package com.hb.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Component("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    public SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
