package ru.trandefil.tm.util;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import ru.trandefil.tm.entity.User;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UserXmlAdapter extends XmlAdapter<String, User> {

    @Override
    public User unmarshal(String v) throws Exception {
        return null;
    }

    @Override
    public String marshal(User v) throws Exception {
        return null;
    }
}
