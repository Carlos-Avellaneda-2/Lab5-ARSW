package co.edu.eci.blueprints.persistence;

import co.edu.eci.blueprints.model.BlueprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlueprintEntityRepository extends JpaRepository<BlueprintEntity, Integer> {
    Optional<BlueprintEntity> findByAuthorAndName(String author, String name);
    List<BlueprintEntity> findByAuthor(String author);
}