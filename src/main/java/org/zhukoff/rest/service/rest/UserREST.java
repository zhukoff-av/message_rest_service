package org.zhukoff.rest.service.rest;


import org.zhukoff.rest.service.entity.User;
import org.zhukoff.rest.service.registrator.UserRegistor;
import org.zhukoff.rest.service.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@Path("/user")
@RequestScoped
public class UserREST {

    @Inject
    private Logger logger;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserRegistor userRegistor;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id) {
        return userRepository.getById(id);
    }

}
