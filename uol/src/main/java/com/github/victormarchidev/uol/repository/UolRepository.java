package com.github.victormarchidev.uol.repository;

import com.github.victormarchidev.uol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UolRepository extends JpaRepository<User, Long> {
}
