package wjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import wjava.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	UserEntity findByEmail(String email);
	
	
	@Transactional(readOnly = true)
	UserEntity findByEmailAndPassword(String email, String password);

	@Query("from UserEntity where email =:email and password =:password")
	UserEntity fetchUser(@Param("email") String email, @Param("password") String password);
	
}
