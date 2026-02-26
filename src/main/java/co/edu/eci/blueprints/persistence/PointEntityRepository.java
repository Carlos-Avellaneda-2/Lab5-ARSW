package co.edu.eci.blueprints.persistence;

import co.edu.eci.blueprints.model.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointEntityRepository extends JpaRepository<PointEntity, Integer> {
}