package au.com.edimoto.horus.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping(value = {"/main" },method = RequestMethod.POST)
	public String mainPost(Model model) {
		logger.info("Entrando al controlador despues de autenticarse por el metodo post...");
		/*model.addAttribute("title", "Main Page");
		model.addAttribute("message", "This is the first page");*/
		return "private/main";
	}
	
	@RequestMapping(value = {"/main" },method = RequestMethod.GET)
	public String mainGet(Model model) {
		logger.info("Entrando al controlador despues de autenticarse por el metodo get...");
		/*model.addAttribute("title", "Main Page");
		model.addAttribute("message", "This is the first page");*/
		return "private/main";
	}
	
	@RequestMapping(value = {"/dashBoard" },method = RequestMethod.GET)
	public String dashBoard(Model model) {
		logger.info("Ejecutando dashBoard Method");
		return "private/transactionalReports/dashBoard";
	}
	
	@RequestMapping(value = {"/" },method = RequestMethod.GET)
	public String main(Model model){
		return "public/ourProducts";
	}
	
	@RequestMapping(value = {"/login"},method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/*@RequestMapping(value="/salir", method = RequestMethod.POST)
    public String logoutPagePost(HttpServletRequest request, HttpServletResponse response) {
		
		Locale locale = LocaleContextHolder.getLocale();
		logger.info("locale.getLanguage(): " + locale.getLanguage());
		
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			logger.info("string: " + string);
		}
		
		System.out.println("Entrando al metodo logoutPagePost: ");
		String newLocale = request.getParameter("locale");
		
		System.out.println("newLocale: " + newLocale);
		logger.info("newLocale: " + newLocale);
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout&lang="+LocaleContextHolder.getLocale().getLanguage();
    }*/
	
	/*@RequestMapping(value="/salir", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("Names: " + request.getParameterNames().toString());
		System.out.println("Entrando al metodo logoutPage: ");
		String newLocale = request.getParameter("locale");
		
		System.out.println("newLocale: " + newLocale);
		logger.info("newLocale: " + newLocale);
		
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }*/
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        logger.info(SecurityContextHolder.getContext().getAuthentication().getCredentials() != null ? SecurityContextHolder.getContext().getAuthentication().getCredentials().getClass():"Nada que mostrar ...");
        logger.info(SecurityContextHolder.getContext().getAuthentication().getDetails() != null ?  SecurityContextHolder.getContext().getAuthentication().getDetails().getClass():"Nada que mostrar ...");
        logger.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass());
        
        LdapUserDetailsImpl ldapUserDetailsImpl = (LdapUserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info(ldapUserDetailsImpl.getDn());
        
        
        logger.info(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        logger.info(SecurityContextHolder.getContext().getAuthentication().getName());
        logger.info(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
        
        if (principal instanceof UserDetails) {
        	UserDetails userDetails = ((UserDetails)principal);
            userName = userDetails.getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
