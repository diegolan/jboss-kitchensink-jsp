package org.jboss.as.quickstarts.kitchensinkjsp.util;

public class GetName {
	
	public static String simpleName(Object obj) {
		return obj.toString().substring(obj.toString().lastIndexOf(".") + 1);
	}

}
