/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.user;

import br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.user.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query(name = "select * from cliente where id_cliente =:idCliente", nativeQuery = true)
    Optional<ClienteEntity> findByIdCliente(@Param("idCliente") Long idCliente);

    ClienteEntity findByCpf(String cpf);
}
