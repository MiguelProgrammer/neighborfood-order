/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.user;

import br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.user.entities.ClienteEntity;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ClienteRepositoryTest {

    private AutoCloseable autoCloseable;

    @Mock
    private ClienteRepository clienteRepository;
    private ClienteEntity clienteEntity;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        clienteEntity = new ClienteEntity();
        clienteEntity.setNome("Miguel Pereira da Silva");
        clienteEntity.setCpf("300.300.300.30");
        clienteEntity.setEmail("miguel.silva@mackenzista.com.br");
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Cria um cliente!")
    void save() {
        when(clienteRepository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        /* ACT */
        var clienteByCpf = clienteRepository.save(clienteEntity);

        /* ASSERT */
        assertThat(clienteByCpf).isInstanceOf(ClienteEntity.class);
        assertThat(clienteByCpf.getEmail()).isEqualTo(clienteByCpf.getEmail());
        assertThat(clienteByCpf.getPedidos()).isEmpty();
        assertThat(clienteByCpf.getCpf()).isEqualTo(clienteByCpf.getCpf());
        assertThat(clienteByCpf.getNome()).isEqualTo(clienteByCpf.getNome());
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Busca um cliente via um CPF!")
    void findByCpf() {
        when(clienteRepository.findByCpf(clienteEntity.getCpf())).thenReturn(clienteEntity);

        /* ACT */
        var clienteByCpf = clienteRepository.findByCpf(clienteEntity.getCpf());

        /* ASSERT */
        assertThat(clienteByCpf).isInstanceOf(ClienteEntity.class);
        assertThat(clienteByCpf.getEmail()).isEqualTo(clienteByCpf.getEmail());
        assertThat(clienteByCpf.getPedidos()).isEmpty();
        assertThat(clienteByCpf.getCpf()).isEqualTo(clienteByCpf.getCpf());
        assertThat(clienteByCpf.getNome()).isEqualTo(clienteByCpf.getNome());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}