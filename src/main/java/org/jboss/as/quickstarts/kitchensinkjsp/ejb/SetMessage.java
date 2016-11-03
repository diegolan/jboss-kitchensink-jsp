package org.jboss.as.quickstarts.kitchensinkjsp.ejb;

import javax.ejb.Local;

@Local
public interface SetMessage {
	
	String message();

}
