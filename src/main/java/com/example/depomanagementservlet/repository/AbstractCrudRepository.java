package com.example.depomanagementservlet.repository;

import com.example.depomanagementservlet.config.DbConfig;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractCrudRepository<ENTITY, ID> {

    private final Class<ENTITY> type;

    public AbstractCrudRepository(Class<ENTITY> type) {
        this.type = type;
    }

    protected Session getSession() {
        return DbConfig.getSession();
    }


    public ENTITY create(ENTITY entity) {
        try (Session session = getSession()) {
            Transaction transaction = getSession().beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
        return entity;
    }


    public List<ENTITY> findAll() {
        try (Session session = getSession()) {
            session.beginTransaction();
            return session.createQuery("select e from " + type.getSimpleName() + " e", type).getResultList();
        }
    }


    public Optional<ENTITY> findById(ID id) {
        try (Session session = getSession()) {
            session.beginTransaction();
            return Optional.ofNullable(session.get(type, id));
        }
    }


    public ENTITY update(ENTITY entity) {
        ENTITY merged;
        try (Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            merged = session.merge(entity);
            transaction.commit();
        }
        return merged;
    }


    public ENTITY delete(ENTITY entity) {
        try (Session session = getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
        return entity;
    }

}
