package org.zhukoff.rest.service.rest;

import org.zhukoff.rest.service.entity.Message;
import org.zhukoff.rest.service.registrator.MessageRegistor;
import org.zhukoff.rest.service.repository.MessageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/message")
public class MessageREST {

    @Inject
    private Logger logger;

    @Inject
    private MessageRepository repository;

    @Inject
    private MessageRegistor registor;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getListAll() {
        logger.info("Get all messages");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getById(long id) {
        return repository.getById(id);
    }
}
