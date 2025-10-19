package com.automarket;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getAll() {
        return User.listAll();
    }

    @POST
    @Transactional
    public void create(User user) {
        user.persist();
    }

    // === НОВЕ: ОНОВЛЕННЯ ВОДІЯ ===
    @PUT
    @Path("/{id}")
    @Transactional
    public User update(@PathParam("id") Long id, User newData) {
        User entity = User.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Водія не знайдено", 404);
        }

        entity.name = newData.name;
        entity.email = newData.email;
        entity.licenseNumber = newData.licenseNumber;

        return entity;
    }

    // === НОВЕ: ВИДАЛЕННЯ ВОДІЯ ===
    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        boolean deleted = User.deleteById(id);
        if (!deleted) {
            throw new WebApplicationException("Водія не знайдено", 404);
        }
    }
}