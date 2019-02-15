package com.ziofront.challenge.repository;

import com.ziofront.challenge.security.ClientDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientDetailsImpl, String> {

    public ClientDetailsImpl findByClientId(String clientId);
}
