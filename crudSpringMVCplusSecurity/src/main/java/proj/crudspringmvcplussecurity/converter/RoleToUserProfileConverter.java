/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.crudspringmvcplussecurity.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import proj.crudspringmvcplussecurity.model.UserProfile;
import proj.crudspringmvcplussecurity.service.UserProfileService;

/**
 *
 * @author Mina
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{
    
    
    @Autowired
    UserProfileService userProfileService;
    
    /**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public UserProfile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UserProfile profile= userProfileService.findById(id);
		//logger.info("Profile : {}",profile);
		return profile;
	}
    
    
}
