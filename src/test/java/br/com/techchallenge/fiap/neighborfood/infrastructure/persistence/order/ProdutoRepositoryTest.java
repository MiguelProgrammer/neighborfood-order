/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.order;

import br.com.techchallenge.fiap.neighborfood.core.domain.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.infrastructure.persistence.order.entities.ProdutoEntity;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

class ProdutoRepositoryTest {

    private AutoCloseable autoCloseable;

    @Mock
    private ProdutoRepository produtoRepository;
    private ProdutoEntity produtoEntity;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        produtoEntity = new ProdutoEntity();
        produtoEntity.setImg("http://google.com/image");
        produtoEntity.setNome("Batata Frita");
        produtoEntity.setDescricao("Batata Frita média");
        produtoEntity.setCategoria(Categoria.ACOMPANHAMENTO);
        produtoEntity.setPreco(new BigDecimal(7.00));
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Remove um produto do estoque!")
    void deleteByNome() {
        /* ACTO */
        produtoRepository.deleteByNome(produtoEntity.getNome());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
}