
package wjava.utils;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import org.springframework.stereotype.Service;

import wjava.beans.User;

@Service
public class Validator {

	public boolean validateUserForSignUp(User user) {
		if (nonNull(user) && !isNullOrEmpty(user.getEmail()) && !isNullOrEmpty(user.getName())
				&& !isNullOrEmpty(user.getPassword())) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(String value) {
		return isNull(value) || value.isEmpty();
	}
}
