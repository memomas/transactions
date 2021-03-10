package com.memomas.springboot.backend.apirest.models.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.memomas.springboot.backend.apirest.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByUserId(Long id);
}
