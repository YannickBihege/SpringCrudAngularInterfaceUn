package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao;

import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
