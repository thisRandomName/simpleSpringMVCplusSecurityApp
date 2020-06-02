/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.crudspringmvcplussecurity.controllers;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import proj.crudspringmvcplussecurity.model.User;
import proj.crudspringmvcplussecurity.model.UserProfile;
import proj.crudspringmvcplussecurity.service.UserProfileService;
import proj.crudspringmvcplussecurity.service.UserService;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AdminController {
        @Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;
        
       
        
        

        
	@RequestMapping(value = { "/admin/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		
		return "userslist";
	}
    
    
         // Admin add user  
       @RequestMapping(value = { "/admin/adduser"}, method = RequestMethod.GET)
        
		//model.addAttribute("user", getPrincipal());
                
	        public String newwUser(ModelMap model) {
		User user = new User();
                model.addAttribute("user", user);
                model.addAttribute("edit", false);
               
		return "crud";
	}
//                
//        
//	 * saving user in database
//	 
	@RequestMapping(value = { "/admin/adduser" }, method = RequestMethod.POST)
	public String savesUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "crud";
		}
                if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "crud";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		
		
		return "crudsuccess";

        }


        /**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editsUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySso(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		//model.addAttribute("loggedinuser", getPrincipal());
		return "crud";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updatesUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "crud";
		}
            userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		//model.addAttribute("loggedinuser", getPrincipal());
		return "crudsuccess";
	}
        
        
        /**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/admin/list";
	}
        
        /**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
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
    
