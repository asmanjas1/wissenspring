package wjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import wjava.entity.TrainingMaterialEntity;

public interface TrainingMaterialRepo extends JpaRepository<TrainingMaterialEntity, Integer>{

}
