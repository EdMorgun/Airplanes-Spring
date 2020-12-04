package airlines.repository;

import airlines.models.ad_service_code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ad_service_codeRepository extends JpaRepository<ad_service_code, Integer> {

}
