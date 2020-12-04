package airlines.repository;

import airlines.models.spec_machinery_codelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface spec_machinery_codelistRepository extends JpaRepository<spec_machinery_codelist, Integer> {
}
