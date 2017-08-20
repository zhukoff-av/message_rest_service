package org.zhukoff.rest.service.repository;

import org.zhukoff.rest.service.entity.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped

public class MessageRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Message getById(long id) {
        logger.info("Get message by id" + id);
        return entityManager.find(Message.class, id);
    }

    public List<Message> byId() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Message.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
