package airlines.repository;

import airlines.models.airport;
import airlines.models.position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface positionRepository extends JpaRepository<position, Integer> {
}
