package org.zhukoff.rest.service.registrator;

import org.zhukoff.rest.service.entity.MessageMapping;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless

public class UserRegistor {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(MessageMapping item) {
        logger.info("Create a message" + item);
        entityManager.merge(item);
    }

    public void update(MessageMapping item) {
        logger.info("Update a message" + item);
        entityManager.merge(item);

    }

    public void delete(MessageMapping item) {
        logger.info("Remove a message" + item);
        entityManager.merge(item);
    }

}

