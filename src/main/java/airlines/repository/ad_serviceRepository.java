package airlines.repository;

import airlines.models.ad_service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ad_serviceRepository extends JpaRepository<ad_service, Integer> {

}
