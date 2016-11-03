package org.jboss.as.quickstarts.kitchensinkjsp.ejb;

import static org.jboss.as.quickstarts.kitchensinkjsp.util.GetName.simpleName;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.jboss.as.quickstarts.kitchensinkjsp.ejb.interceptors.TestInterceptor;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;

//import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(name = "SetMessageLocal", mappedName = "SetMessageLocal")
@Interceptors(TestInterceptor.class)
public class SetMessageLocal implements SetMessage {
	
	@Inject
	private Event<Member> events;

	@Override
	public String message() {
		events.fire(new Member(simpleName(this)));
		return simpleName(this);
	}

}
