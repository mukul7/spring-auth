package com.geekyants.auth2.repositories;

import com.geekyants.auth2.entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Long> {
}
