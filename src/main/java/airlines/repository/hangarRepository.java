package airlines.repository;

import airlines.models.hangar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface hangarRepository extends JpaRepository<hangar, Integer> {
}
