package org.jboss.as.quickstarts.kitchensinkjsp.web;

import static org.jboss.as.quickstarts.kitchensinkjsp.util.GetName.simpleName;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

import javax.ejb.EJB;

import org.jboss.as.quickstarts.kitchensinkjsp.ejb.GetMessage;
import org.jboss.as.quickstarts.kitchensinkjsp.ejb.SetMessage;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;

@RestController
@RequestMapping("/member")
@Scope(SCOPE_SESSION)
public class MemberSpringController {
	
	@EJB(mappedName = "java:module/GetMessageLocal")
	private GetMessage getMessageservice;
	
	@EJB(mappedName = "java:module/SetMessageLocal")
	private SetMessage setMessageservice;
	
	@RequestMapping
	public String hello() {
		return getMessageservice.message() + " | " + simpleName(this) + " | " + setMessageservice.message();
	}

}
