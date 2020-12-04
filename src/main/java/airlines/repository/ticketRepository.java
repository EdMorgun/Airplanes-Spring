package airlines.repository;

import airlines.models.Users;
import airlines.models.client;
import airlines.models.text_block;
import airlines.models.ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ticketRepository extends JpaRepository<ticket, Integer> {
    List<ticket> findAllByClient(client client);
}
