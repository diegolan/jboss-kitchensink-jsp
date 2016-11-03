package org.jboss.as.quickstarts.kitchensinkjsp.ejb.interceptors;

import static org.jboss.as.quickstarts.kitchensinkjsp.util.GetName.simpleName;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.inject.Inject;
import javax.interceptor.InvocationContext;

public class TestInterceptor {
	
	@Inject
	private Logger log;
	
	@PostConstruct
	@PostActivate
	public void intercept(InvocationContext context) {
		log.info("-------TestInterceptor intercept()-------");
		log.info(simpleName(this) + " | " + simpleName(context.getTarget()));
	}
	
	@PreDestroy
	@PrePassivate
	public void destroy(InvocationContext context) {
		log.info("-------TestInterceptor destroy()-------");
		log.info(simpleName(this) + " | " + simpleName(context.getTarget()));
	}

}
