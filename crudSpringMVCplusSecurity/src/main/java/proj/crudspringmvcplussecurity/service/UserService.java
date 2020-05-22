package proj.crudspringmvcplussecurity.service;


import java.util.List;
import proj.crudspringmvcplussecurity.model.User;


public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
        
        void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserBySSO(String sso);

	List<User> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);
	
}