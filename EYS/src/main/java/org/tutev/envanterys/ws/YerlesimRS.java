package org.tutev.envanterys.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Yerlesim")
public class YerlesimRS {

	//http://localhost:8080/EYS/rest/Yerlesim
	
	@GET
	@Produces("application/json; charset=UTF-8")
	public List<Il> getAll() {
		List list = new ArrayList<Il>();
		list.add(new Il("6", "ANKARA"));
		list.add(new Il("34", "İSTANBUL"));
		list.add(new Il("35", "İZMİR"));
		return list;
	}

}
