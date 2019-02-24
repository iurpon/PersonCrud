package ru.trandefil.tm.util;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import ru.trandefil.tm.entity.User;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserXmlAdapter extends XmlAdapter<User, User> {

    @Override
    public User unmarshal(User v) throws Exception {
        return null;
    }

    @Override
    public User marshal(User v) throws Exception {
   /*     if (v instanceof HibernateProxy) {
            return null;
        }*/
        if (!Hibernate.isInitialized(v)) {
            return null;
        }
        return v;
    }

}
