package com.proof.cat.domain.repository; // 👈 ajusta al paquete donde lo tengas guardado

import com.proof.cat.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
