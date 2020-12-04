package airlines.repository;

import airlines.models.plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface planeRepository extends JpaRepository<plane, Integer>  {
}
