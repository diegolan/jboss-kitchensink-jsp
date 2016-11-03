package org.jboss.as.quickstarts.kitchensinkjsp.ejb.observers;

import static javax.enterprise.event.TransactionPhase.AFTER_COMPLETION;
import static org.jboss.as.quickstarts.kitchensinkjsp.util.GetName.simpleName;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;

@Stateless
public class MemberEventListener {
	
	@Inject
	private Logger log;
	
	public void listen(@Observes(during = AFTER_COMPLETION) Member member) {
		log.info("-------MemberEventListener listen()-------");
		log.info(simpleName(this) + " | " + simpleName(member) + " | " + member.getName());
	}

}
