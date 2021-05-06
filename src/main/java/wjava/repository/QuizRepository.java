package wjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wjava.entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer>{

}
