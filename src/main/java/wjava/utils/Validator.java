
package wjava.utils;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import org.springframework.stereotype.Service;

import wjava.beans.User;
import wjava.entity.QuizEntity;
import wjava.entity.ReferenceEntity;

@Service
public class Validator {

	public boolean validateUserForSignUp(User user) {
		if (nonNull(user) && !isNullOrEmpty(user.getEmail()) && !isNullOrEmpty(user.getName())
				&& !isNullOrEmpty(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	public boolean validateUserForLogin(User user) {
		if (nonNull(user) && !isNullOrEmpty(user.getEmail()) && !isNullOrEmpty(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	public boolean validateReference(ReferenceEntity ref) {
		if (nonNull(ref) && !isNullOrEmpty(ref.getLink()) && !isNullOrEmpty(ref.getTechName())
				&& !isNullOrEmpty(ref.getTitle())) {
			return true;
		}
		return false;
	}
	
	public boolean validateQuiz(QuizEntity entity) {
		if (nonNull(entity) && !isNullOrEmpty(entity.getTechName()) && !isNullOrEmpty(entity.getQuestion())
				&& !isNullOrEmpty(entity.getOption1()) && !isNullOrEmpty(entity.getOption2())
				&& !isNullOrEmpty(entity.getOption3()) && !isNullOrEmpty(entity.getOption4())) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(String value) {
		return isNull(value) || value.isEmpty();
	}
}
