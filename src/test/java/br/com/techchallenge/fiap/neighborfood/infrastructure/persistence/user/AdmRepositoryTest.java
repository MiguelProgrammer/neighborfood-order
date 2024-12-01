/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.user;

import br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.user.entities.AdminEntity;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class AdmRepositoryTest {

    private AutoCloseable autoCloseable;

    @Mock
    private AdmRepository admRepository;
    private AdminEntity adminEntity;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        adminEntity = new AdminEntity();
        adminEntity.setNome("Miguel Pereira da Silva");
        adminEntity.setCpf("300.300.300.30");
        adminEntity.setEmail("miguel.silva@mackenzista.com.br");
        adminEntity.setNotificacao("Bem vindo");
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Cadastra um administrador")
    void save() {
        /* ARRANGE */
        when(admRepository.save(any(AdminEntity.class))).thenReturn(adminEntity);

        /* ACT */
        var byCpf = admRepository.save(adminEntity);

        /* ASSERT */
        assertThat(byCpf).isInstanceOf(AdminEntity.class);
        assertThat(byCpf.getEmail()).isEqualTo(adminEntity.getEmail());
        assertThat(byCpf.getNotificacao()).isNotBlank();
        assertThat(byCpf.getCpf()).isEqualTo(adminEntity.getCpf());
        assertThat(byCpf.getNome()).isEqualTo(adminEntity.getNome());
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Busca o administrador via um CPF!")
    void findByCpf() {
        /* ARRANGE */
        when(admRepository.findByCpf(anyString())).thenReturn(adminEntity);

        /* ACT */
        var byCpf = admRepository.findByCpf(adminEntity.getCpf());

        /* ASSERT */
        assertThat(byCpf).isInstanceOf(AdminEntity.class);
        assertThat(byCpf.getEmail()).isEqualTo(adminEntity.getEmail());
        assertThat(byCpf.getNotificacao()).isNotBlank();
        assertThat(byCpf.getCpf()).isEqualTo(adminEntity.getCpf());
        assertThat(byCpf.getNome()).isEqualTo(adminEntity.getNome());
    }


    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}