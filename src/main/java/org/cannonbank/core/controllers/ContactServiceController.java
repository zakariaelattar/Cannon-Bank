package org.cannonbank.core.controllers;//package org.cannonbank.core.controllers;
//
//import org.cannonbank.core.Entities.Contact;
//import org.cannonbank.core.services.ContactService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/ContactApi")
//public class ContactServiceController {
//	@Autowired
//	   ContactService contactService;
//	   @RequestMapping(value = "/Action/{enable}" , method = RequestMethod.POST)
//	   public boolean enableContact(@RequestBody Contact contact,@PathVariable("enable") int enable ) {
//	       try { 
//	    		contactService.(contact,enable);
//	    		return true;		
//	       }
//	       catch(Exception e)
//	       {
//	    	    e.printStackTrace();
//	    	    return false;
//	       }
//	       finally 
//	       {   
//	    	    return false;
//	       }
//	       
//	       }
//	}
//
