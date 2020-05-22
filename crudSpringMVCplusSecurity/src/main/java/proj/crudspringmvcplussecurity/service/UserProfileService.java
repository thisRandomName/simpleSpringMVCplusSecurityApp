package proj.crudspringmvcplussecurity.service;


import java.util.List;
import proj.crudspringmvcplussecurity.model.UserProfile;


public interface UserProfileService {
        UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
    
}
