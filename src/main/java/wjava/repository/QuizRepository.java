package wjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import wjava.entity.QuizEntity;
import wjava.entity.UserEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer>{
	
	@Transactional(readOnly = true)
	List<QuizEntity> findBytechName(String techName);

}
