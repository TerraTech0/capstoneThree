package com.example.capstonethree.Repository;

import com.example.capstonethree.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findClientById(Integer id);
}
