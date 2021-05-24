package io.com.dropwizard.resource;


import io.com.dropwizard.DAOService;
import io.com.dropwizard.dao.DBEntityDAO;
import io.com.dropwizard.model.DBEntity;
import io.com.dropwizard.request.EntityCreateRequest;
import io.com.dropwizard.response.EntityResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("entity")
@Produces(MediaType.APPLICATION_JSON)
@NoArgsConstructor
public class EntityResource {

    private  DAOService service ;


    public EntityResource(DAOService service){
        this.service = service ;
    }
    @POST
    public Response createEntity(final EntityCreateRequest request){

        DBEntity entity = new DBEntity(request.getName(),request.getDescription(),request.getType()) ;
        service.createPart(entity);

        return Response.ok(request).build();


    }
}
