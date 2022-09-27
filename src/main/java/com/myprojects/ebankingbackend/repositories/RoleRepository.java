package com.myprojects.ebankingbackend.repositories;

import java.util.Optional;

import com.myprojects.ebankingbackend.entities.ERole;
import com.myprojects.ebankingbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}