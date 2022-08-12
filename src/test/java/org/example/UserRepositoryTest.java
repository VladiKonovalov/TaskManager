package org.example.Repository;

import org.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@DataJpaTest
 public interface UserRepositoryTest extends JpaRepository<User, Long> {

}