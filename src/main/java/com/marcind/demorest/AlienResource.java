package com.marcind.demorest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource 
{
	
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAliens()
	{
		System.out.println("Get Alien called..");
		
		
		return repo.getAliens();
	}
}
