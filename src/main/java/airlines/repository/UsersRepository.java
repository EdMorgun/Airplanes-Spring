package airlines.repository;

import airlines.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
    List<Users> findByFirstname(String firstname);
    List<Users> findByLastname(String lastname);
    List<Users> findByFirstnameAndLastname(String firstname, String lastname);
}
