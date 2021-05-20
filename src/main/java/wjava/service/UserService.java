package wjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wjava.beans.User;
import wjava.entity.QuizEntity;
import wjava.entity.ReferenceEntity;
import wjava.entity.UserEntity;
import wjava.repository.QuizRepository;
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
	private QuizRepository quizRepository;

	@Autowired
	private Validator validator;

	public UserEntity signUp(User user) throws Exception {
		UserEntity ue = null;
		if (validator.validateUserForSignUp(user)) {
			ue = userRepository.findByEmail(user.getEmail());
			if (ue == null) {
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
		if (validator.validateUserForLogin(user)) {
			UserEntity ue = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			if (ue == null)
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
		if (!validator.validateReference(entity))
			throw new Exception("Please provide valid Reference data");

		refRepository.saveAndFlush(entity);

		return "Successfully saved Reference";
	}

	public List<ReferenceEntity> getAllRefs() {
		return refRepository.findAll();
	}

	public String saveQuiz(QuizEntity entity) throws Exception {
		if (!validator.validateQuiz(entity))
			throw new Exception("Please provide valid Quiz data");

		quizRepository.saveAndFlush(entity);

		return "Successfully saved Quiz";
	}

	public List<QuizEntity> getAllQuizs() {
		return quizRepository.findAll();
	}

	public List<ReferenceEntity> getReference(String techName) throws Exception {
		List<ReferenceEntity> tech = refRepository.findByTechName(techName);
		if (!tech.isEmpty()) {
			return tech;
		}
		throw new Exception("No record");

	}

	public void deleteReferenceById(Integer id) throws Exception {
		Optional<ReferenceEntity> reffID = refRepository.findById(id);
		if (reffID.isPresent()) {
			refRepository.delete(id);
		} else {
			throw new Exception("Id not exist");
		}
	}

	public List<QuizEntity> getQuiz(String techName) {
		return quizRepository.findBytechName(techName);
	}

	public String deleteQuiz(int id) throws Exception {
		quizRepository.delete(id);
		return "Successfully deleted Quiz";
	}
	
	public UserEntity getUser(Integer userId) {
		return userRepository.findByUserId(userId);
	}
	
	
	public String updateUser( UserEntity user) {
		UserEntity userEntity = userRepository.findByUserId(user.getUserId());
		
		if( userEntity == null )
			return "No User With Passed userId";
		
		if(user.getName() != null) {
			userEntity.setName(user.getName());
		}
		
		if(user.getPhone() != null) {
			userEntity.setPhone(user.getPhone());
		}
		
		if(user.getAddress() != null) {
			userEntity.setAddress(user.getAddress());
		}
		
		if(user.getSkills() != null && user.getSkills().size() > 0) {
			userEntity.setSkills(user.getSkills());
		}
		
		userRepository.saveAndFlush(userEntity);
		
		return "Successfully updated User with Given Data";
	}

}
