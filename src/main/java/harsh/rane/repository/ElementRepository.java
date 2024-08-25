package harsh.rane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import harsh.rane.entity.ElementEntity;

@Repository
public interface ElementRepository extends JpaRepository<ElementEntity, Integer>{

}
