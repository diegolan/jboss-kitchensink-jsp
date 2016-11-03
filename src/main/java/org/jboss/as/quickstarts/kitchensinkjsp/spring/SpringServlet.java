package org.jboss.as.quickstarts.kitchensinkjsp.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringServlet implements WebApplicationInitializer {
	
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		container.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(SpringMVCConfig.class);

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/spring/*");
		
	}

}
