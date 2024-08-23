package com.vatsal.FA.repository;

import com.vatsal.FA.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
