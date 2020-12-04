package airlines.repository;

import airlines.models.airport;
import airlines.models.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<comment, Integer> {
}
