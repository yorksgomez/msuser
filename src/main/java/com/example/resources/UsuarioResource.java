package com.example.resources;

import com.example.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UsuarioResource {

    @Inject
    UsuarioRepository repository;

    @POST
    @Transactional
    public void createUsuario(Usuario usuario) {
        repository.persist(usuario);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void updateUsuario(@PathParam("id") Long id, Usuario usuario) {
        Usuario existingUsuario = repository.findById(id);
        if (existingUsuario != null) {
            // Actualizar los campos del usuario existente
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setCorreoElectronico(usuario.getCorreoElectronico());
            existingUsuario.setContrasena(usuario.getContrasena());
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteUsuario(@PathParam("id") Long id) {
        repository.deleteById(id);
    }

    @GET
    @Path("/{id}")
    public Usuario getUsuario(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    public List<Usuario> getAllUsuarios() {
        return repository.listAll();
    }
}