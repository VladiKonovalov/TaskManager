package org.example.Repository;

import org.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

// public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends MongoRepository<User,String>{
 @Query("SELECT u FROM User u WHERE u.email = ?1")
 User findByEmail(String email);

// @Query("SELECT u FROM User u WHERE u.email = ?1")
// User findByUsername(String email);

}