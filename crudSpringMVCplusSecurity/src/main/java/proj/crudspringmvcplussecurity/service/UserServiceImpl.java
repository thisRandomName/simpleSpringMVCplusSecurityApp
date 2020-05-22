/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.crudspringmvcplussecurity.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.crudspringmvcplussecurity.dao.UserDao;
import proj.crudspringmvcplussecurity.model.User;

/**
 *
 * @author Mina
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySso(String sso) {
		return dao.findBySSO(sso);
	}
        
        //ki alla
        public void saveUser(User user) {
		//user.setPassword(user.getPassword());
		dao.save(user);
	}
        
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setSsoId(user.getSsoId());
//			if(!user.getPassword().equals(entity.getPassword())){
//				entity.setPassword(passwordEncoder.encode(user.getPassword()));
//			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySso(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	

}
