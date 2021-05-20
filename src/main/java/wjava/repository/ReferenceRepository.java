package wjava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wjava.entity.ReferenceEntity;

public interface ReferenceRepository extends JpaRepository<ReferenceEntity, Integer>{
	
	List<ReferenceEntity> findByTechName(String techName);
	
	Optional<ReferenceEntity> findById(Integer id);
	

}
