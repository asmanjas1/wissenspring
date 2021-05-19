package wjava.repository;

import java.util.List;

<<<<<<< HEAD
import javax.transaction.Transactional;



import wjava.entity.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import wjava.entity.QuizEntity;
import wjava.entity.UserEntity;
>>>>>>> f5b258df9c588ac9267befcd96a5b9979d405449

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Integer>{
	
<<<<<<< HEAD
	
    List<QuizEntity> findBytechName(String techName);
=======
	@Transactional(readOnly = true)
	List<QuizEntity> findBytechName(String techName);
>>>>>>> f5b258df9c588ac9267befcd96a5b9979d405449

}
