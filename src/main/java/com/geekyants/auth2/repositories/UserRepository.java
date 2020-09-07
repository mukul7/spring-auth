package com.geekyants.auth2.repositories;

import com.geekyants.auth2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    List<User> findUsersByAuthoritiesContaining(List<String> authorities);
}
