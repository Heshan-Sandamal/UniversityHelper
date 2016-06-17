package com.universityHelper.webServices;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.universityHelper.services.ApartmentServiceLocal;

@Path("/getapartments")
public class ApartmentService {

	@EJB
	ApartmentServiceLocal apartmentService;
	
	@GET
	public JsonObject getApartments() {
		return apartmentService.getApartmentList("university of moratuwa");
	}

}
