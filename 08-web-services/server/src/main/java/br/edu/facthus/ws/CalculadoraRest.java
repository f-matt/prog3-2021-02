package br.edu.facthus.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calculadora")
public class CalculadoraRest {
	
	@GET
	@Path("/soma/{a}/{b}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response soma(@PathParam("a") int a,
			@PathParam("b") int b) {
		
		System.out.println("Calculando (REST)...");
		
		return Response
				.ok(a + b)
				.build();
		
	}

}
