package airlines.repository;

import airlines.models.Users;
import airlines.models.airport;
import airlines.models.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends JpaRepository<client, Integer> {
    client findByUsr(Users usr);
}
