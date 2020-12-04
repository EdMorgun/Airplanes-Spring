package airlines.repository;

import airlines.models.airport;
import airlines.models.post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postRepository extends JpaRepository<post, Integer> {

}
