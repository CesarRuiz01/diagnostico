package com.example.crrv.Repository;

import com.example.crrv.Entity.diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<diagnostico, Long> {
    diagnostico findByName(String name);
}

