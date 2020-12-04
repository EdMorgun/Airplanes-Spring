package airlines.repository;

import airlines.models.airport;
import airlines.models.route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface routeRepository extends JpaRepository<route, Integer> {

}
