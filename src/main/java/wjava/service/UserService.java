package wjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wjava.beans.User;
import wjava.entity.ReferenceEntity;
import wjava.entity.UserEntity;
import wjava.repository.ReferenceRepository;
import wjava.repository.UserRepository;
import wjava.utils.Validator;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReferenceRepository refRepository;
	
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


	public User doLogin(User user) throws Exception {
		if(validator.validateUserForLogin(user)) {
			UserEntity ue = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if(ue == null )
				throw new Exception("Please enter valid email/password");
			
			user.setName(ue.getName());
			user.setRegistrationDate(ue.getRegistrationDate());
			user.setUserId(ue.getUserId());
			user.setIsAdmin(ue.getIsAdmin());
			user.setPassword(null);
		} else {
			throw new Exception("Please provide valid user fields");
		}
		return user;
	}

	public String saveReference(ReferenceEntity entity) throws Exception {
		if(!validator.validateReference(entity))
			throw new Exception("Please provide valid Reference data");
		
		refRepository.saveAndFlush(entity);
		
		return "Successfully saved Reference";
	}
	
	public List<ReferenceEntity> getAllRefs() {
		return refRepository.findAll();
	}

	
}
