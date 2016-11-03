package org.jboss.as.quickstarts.kitchensinkjsp.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class MessageWS {
	
	@EJB
	private GetMessage getMessageservice;
	
	@EJB
	private SetMessage setMessageservice;
	
	public String getMessage() {
		return getMessageservice.message();
	}
	
	public String setMessage() {
		return setMessageservice.message();
	}

}
