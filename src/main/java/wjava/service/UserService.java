package wjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wjava.beans.User;
import wjava.entity.UserEntity;
import wjava.repository.UserRepository;
import wjava.utils.Validator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Validator validator;

	public UserEntity signUp(User user) throws Exception {
		UserEntity ue = null;
		if(validator.validateUserForSignUp(user)) {
			ue = userRepository.findByEmail(user.getEmail());
			if( ue == null ) {
				UserEntity userEntity = new UserEntity();
				userEntity.setEmail(user.getEmail());
				userEntity.setIsAdmin(false);
				userEntity.setName(user.getName());
				userEntity.setPassword(user.getPassword());
				ue = userRepository.saveAndFlush(userEntity);
				ue.setPassword(null);
			} else {
				throw new Exception("Email already exist");
			}
		} else {
			throw new Exception("Please provide valid User fields");
		}
		return ue;
	}


	public User doLogin(User user) {
		return null;
	}

	

	
}
