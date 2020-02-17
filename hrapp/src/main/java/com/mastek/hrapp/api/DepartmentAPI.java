package com.mastek.hrapp.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Department;


@Path("/hrapp/")
public interface DepartmentAPI {
	 // http://localhost:7777/hrapp/employees/list
    @GET    // we do support http method GET
    @Path("/departments/list") // URL path to access this method
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) // formats which the method supports
    public Iterable<Department> listAllDepartments();

    @GET//http method
    @Path("/departments/find/{deptno}")///url with parameter format
    @Produces({MediaType.APPLICATION_JSON})
    public Department findBydeptno(@PathParam("deptno") int deptno);
    
    @POST //http method post used to send data in requests
    @Path("/departments/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Department registerNewDepartment(@BeanParam Department newDepartment);
    
    
    
    
}