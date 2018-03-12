package com.mwo.group2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mwo.group2.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
