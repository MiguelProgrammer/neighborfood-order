/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.framework.tools;


import io.restassured.response.Response;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class CucumberTest {

    ///neighborfood/menu -> get
    ///neighborfood/pedido -> post
    ///neighborfood/pedido/update -> put

    private static final Logger log = LoggerFactory.getLogger(CucumberTest.class);
    private Response response;
    private final String REST_API_ACOMPANHEMENTO = "http://localhost:82/neighborfood/acompanhamento/";


}
