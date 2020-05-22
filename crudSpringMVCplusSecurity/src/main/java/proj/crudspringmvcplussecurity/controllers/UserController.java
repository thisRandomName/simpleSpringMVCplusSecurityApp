/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.crudspringmvcplussecurity.controllers;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import proj.crudspringmvcplussecurity.model.User;
import proj.crudspringmvcplussecurity.service.UserProfileService;
import proj.crudspringmvcplussecurity.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UserController {
        //ki alla 
        @Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;
        
        //index page
        
        @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "index";
	}
        
        


         // U S E R registration ........................
        @RequestMapping(value = { "/newuser"}, method = RequestMethod.GET)
        
		
                
	        public String newUser(ModelMap model) {
		User user = new User();
                model.addAttribute("user", user);
                model.addAttribute("edit", false);
                
		return "registration";
	}
                
        /*
	 * saving user in database
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
                if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		
		
		return "registrationsuccess";

        }
        //user-roles
	
        @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}
        
        

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String teacherPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "teacher";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
        
        

	private String getPrincipal(){
           
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}


}