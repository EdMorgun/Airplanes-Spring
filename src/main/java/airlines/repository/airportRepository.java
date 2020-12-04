package airlines.repository;

import airlines.models.ad_service;
import airlines.models.airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface airportRepository extends JpaRepository<airport, Integer> {

}
