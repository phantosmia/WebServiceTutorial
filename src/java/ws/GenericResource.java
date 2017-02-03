/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author Raquel
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/text")
    public String getJson() {
        //TODO return proper representation object
        return "Meu primerio WS RESTFULL";
    }
    @GET
    @Produces("application/json")
    @Path("Usuario/get/{login}")
    public String getUsuario(@PathParam("login")String login){
        Usuario u = new Usuario();
        u.setLogin(login);
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        Gson g = new Gson();
        return g.toJson(u);
    }
     @GET
    @Produces("application/json")
    @Path("Usuario/list")
    public String listUsuarios(){
        List<Usuario> lista = new ArrayList<Usuario>();
        UsuarioDAO dao = new UsuarioDAO();
       lista = dao.listar();
        
        Gson g = new Gson();
        return g.toJson(lista);
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
