package com.alexsanjr.crudclientes.repositories;

import com.alexsanjr.crudclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
