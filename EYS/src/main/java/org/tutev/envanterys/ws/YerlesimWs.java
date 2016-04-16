package org.tutev.envanterys.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutev.envanterys.entity.Yerlesim;
import org.tutev.envanterys.service.YerlesimService;

@Service
@WebService(name="yerlesimWebService",serviceName="yerlesimWebService")
public class YerlesimWs {
	
	//http://localhost:8090/WS/yerlesimWebService?wsdl
	
	@Autowired
	private YerlesimService yerlesimService;
	
	@WebMethod(operationName="getCities")
	public List<Il> getIlListesi(@WebParam String username) {
		List<Il> result =new ArrayList<>();
		List<Yerlesim> liste = yerlesimService.getAll();
		for (Yerlesim yerlesim : liste) {
			result.add(new Il(yerlesim.getKod(), yerlesim.getTanim()));
		}
		return result;
	}
	
	@WebMethod(operationName="getDistricts")
	public String getIlceListesi() {

		return "Merhaba";
	}

}
