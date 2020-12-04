package airlines.repository;

import airlines.models.text_block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface text_blockRepository  extends JpaRepository<text_block, Integer> {
}
