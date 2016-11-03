package org.jboss.as.quickstarts.kitchensinkjsp.ejb;

import static org.jboss.as.quickstarts.kitchensinkjsp.util.GetName.simpleName;

import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import org.jboss.as.quickstarts.kitchensinkjsp.ejb.interceptors.TestInterceptor;

//import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateful(name = "GetMessageLocal", mappedName = "GetMessageLocal")
@Interceptors(TestInterceptor.class)
public class GetMessageLocal implements GetMessage {
	
	@Override
	public String message() {
		return simpleName(this);
	}

}
