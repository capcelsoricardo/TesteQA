package br.com.inmetrics.features.desafioqa;

import com.br.inmetrics.frm.bdd.Feature;
import com.br.inmetrics.frm.bdd.Scenario;

import static com.br.inmetrics.frm.bdd.Gherkin.*;
import static com.br.inmetrics.frm.utils.LoggerUtils.getMessage;

import java.util.concurrent.ExecutionException;

import org.testng.log4testng.Logger;

@Feature("Novo Calculo")
public class NovoCalculoFeature {

	Logger logger = Logger.getLogger(NovoCalculoFeature.class);
	
	@SuppressWarnings("static-access")
	@Scenario("Gerar Novo Calculo para Envelope")
	public void gerarNovoCalculoParaEnvelope() throws ExecutionException {
		
		logger.info(getMessage("Inicializando o teste de Geração de Novo Cálculo para um Envelope"));
		
		given_("Dado que eu esteja na tela de Novo Cálculo").
		when_("Quando faço a geração do Novo Cálculo para um Envelope").
		then_("Então é exibido novo calculo para um Envelope em Calculos Salvo").
		execute_();
		
		logger.info(getMessage("Finalizando o teste de Geração de Novo Cálculo para um Envelope"));
		
	}	
	
	@SuppressWarnings("static-access")
	@Scenario("Gerar Novo Calculo para Caixa/Pacote")
	public void gerarNovoCalculoParaCaixaPacote() throws ExecutionException {
		
		logger.info(getMessage("Inicializando o teste de Geração de Novo Cálculo uma Caixa/Pacote"));
		
		given_("Dado que eu esteja na tela de Novo Cálculo").
		when_("Quando faço a geração do Novo Cálculo para uma Caixa/Pacote").
		then_("Então é exibido novo calculo para uma Caixa/Pacote em Calculos Salvo").
		execute_();
		
		logger.info(getMessage("Finalizando o teste de Geração de Novo Cálculo para uma Caixa/Pacote"));
		
	}	
	
	@SuppressWarnings("static-access")
	@Scenario("Gerar Novo Calculo sem Preencher CEP Origem")
	public void gerarNovoCalculoSemPreencherCepOrigem() throws ExecutionException {
		
		logger.info(getMessage("Inicializando o teste de Geração de Novo Cálculo sem Preencher CEP Origem"));
		
		given_("Dado que eu esteja na tela de Novo Cálculo").
		when_("Quando faço a geração do Novo Cálculo sem Preencher CEP Origem").
		then_("Então não sou direcionado para a página de Formato").
		execute_();
		
		logger.info(getMessage("Finalizando o teste de Geração de Novo Cálculo sem Preencher CEP Origem"));
		
	}	
	
	@SuppressWarnings("static-access")
	@Scenario("Gerar Novo Calculo sem Preencher CEP Destino")
	public void gerarNovoCalculoSemPreencherCepDestino() throws ExecutionException {
		
		logger.info(getMessage("Inicializando o teste de Geração de Novo Cálculo sem Preencher CEP Destino"));
		
		given_("Dado que eu esteja na tela de Novo Cálculo").
		when_("Quando faço a geração do Novo Cálculo sem Preencher CEP Destino").
		then_("Então não sou direcionado para a página de Formato").
		execute_();
		
		logger.info(getMessage("Finalizando o teste de Geração de Novo Cálculo sem Preencher CEP Destino"));
		
	}
	
	@SuppressWarnings("static-access")
	@Scenario("Gerar Novo Calculo sem Preencher CEP Origem e CEP Destino")
	public void gerarNovoCalculoSemPreencherCepOrigemECepDestino () throws ExecutionException {
		
		logger.info(getMessage("Inicializando o teste de Geração de Novo Cálculo sem Preencher CEP Origem e CEP Destino"));
		
		given_("Dado que eu esteja na tela de Novo Cálculo").
		when_("Quando faço a geração do Novo Cálculo sem Preencher CEP Origem e CEP Destino").
		then_("Então não sou direcionado para a página de Formato").
		execute_();
		
		logger.info(getMessage("Finalizando o teste de Geração de Novo Cálculo sem Preencher CEP Origem e CEP Destino"));
		
	}
	
}
