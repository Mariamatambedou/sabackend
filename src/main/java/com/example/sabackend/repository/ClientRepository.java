package com.example.sabackend.repository;

import com.example.sabackend.modele.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);

}
