package com.mastek.hrapp.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Project;


@Path("/hrapp/")
public interface ProjectAPI {

	  // http://localhost:7777/hrapp/Projects/list
    @GET    // we do support http method GET
    @Path("/Projects/list") // URL path to access this method
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the method supports
    public Iterable<Project> listAllProjects();

    @GET//http method
    @Path("/Projects/find/{projectId}")///url with parameter format
    @Produces({MediaType.APPLICATION_JSON})
    public Project findByprojectId(@PathParam("projectId") int projectId);
    
    @POST //http mehtod post used to send data in requests
    @Path("/Projects/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Project registerNewProject(@BeanParam Project newProject);
    
    
    
    
}
