package proj.crudspringmvcplussecurity.dao;


import java.util.List;
import proj.crudspringmvcplussecurity.model.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
        
        //additionally
        void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();
	
}

