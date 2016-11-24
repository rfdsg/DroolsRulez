package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class ConditionActivator {
	public KieSession kSession;
	

	
	public void execute(Account account){
		 if (null == kSession) {
			// load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	kSession = kContainer.newKieSession("ksession-rules");	  
		 }
		 
		 kSession.insert(account);
		 kSession.fireAllRules();
		 
		
		 
	}
	
	
	
	
	
		 
}
