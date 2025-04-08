package org.estudo.Application;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.estudo.Domain.Dto.PersonDto;
import org.estudo.Domain.Entity.Person;
import org.estudo.Service.PersonServiceImpl;

@Path("api/v1/people")
public class PersonController {

    @Inject
    PersonServiceImpl personService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<PersonDto> getPerson(@PathParam("id") Long id) {
       return personService.findPersonById(id);
   }

    @POST
    @Path("/insertPeople")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> insertPerson(Person person) {
        return personService.createPerson(person) // Retorna um Uni<Response>
                .onItem().transform(response -> Response.status(Response.Status.CREATED)
                        .entity(response) // Obtém o conteúdo do Uni
                        .build());
   }
}
