package br.com.inmetrics.tests.desafioqa;

import static com.br.inmetrics.frm.bdd.Gherkin.executeScenario_;
import static com.br.inmetrics.frm.utils.LoggerUtils.getMessage;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.br.inmetrics.frm.base.TestBase;
import com.br.inmetrics.frm.controllers.AndroidController;
import com.br.inmetrics.frm.testng.DataTableConfig;
import com.br.inmetrics.frm.testng.TestConfig;

@TestConfig(controllerType = AndroidController.class)
public class TestsGherkin extends TestBase {
	
	Logger logger = Logger.getLogger(TestsGherkin.class);

	@DataTableConfig(ct = 1)
	@Test(priority = 1, testName = "CT001 - Gerar Novo Calculo para Envelope", suiteName = "Desafio")
	public void CT001_GerarNovoCalculoParaEnvelope() {

		try {
			executeScenario_("Novo Calculo","Gerar Novo Calculo para Envelope");
		} catch (Exception e) {
			logger.error(getMessage("Error on execution"), e);
			Assert.fail("Test error.", e);
		}
			
	}
	
	@DataTableConfig(ct = 2)
	@Test(priority = 2, testName = "CT002 - Gerar Novo Calculo para Caixa/Pacote", suiteName = "Desafio")
	public void CT002_GerarNovoCalculoParaCaixaPacote() {

		try {
			executeScenario_("Novo Calculo","Gerar Novo Calculo para Caixa/Pacote");
		} catch (Exception e) {
			logger.error(getMessage("Error on execution"), e);
			Assert.fail("Test error.", e);
		}
			
	}
	
	@DataTableConfig(ct = 3)
	@Test(priority = 3, testName = "CT003 - Gerar Novo Calculo sem Preencher CEP Origem", suiteName = "Desafio")
	public void CT003_GerarNovoCalculoSemPreencherCepOrigem() {

		try {
			executeScenario_("Novo Calculo","Gerar Novo Calculo sem Preencher CEP Origem");
		} catch (Exception e) {
			logger.error(getMessage("Error on execution"), e);
			Assert.fail("Test error.", e);
		}	
	}
	
	@DataTableConfig(ct = 4)
	@Test(priority = 4, testName = "CT004 - Gerar Novo Calculo sem Preencher CEP Destino", suiteName = "Desafio")
	public void CT004_GerarNovoCalculoSemPreencherCepDestino() {

		try {
			executeScenario_("Novo Calculo","Gerar Novo Calculo sem Preencher CEP Destino");
		} catch (Exception e) {
			logger.error(getMessage("Error on execution"), e);
			Assert.fail("Test error.", e);
		}	
	}
	
	@DataTableConfig(ct = 5)
	@Test(priority = 5, testName = "CT005 - Gerar Novo Calculo sem Preencher CEP Origem e CEP Destino", suiteName = "Desafio")
	public void CT005_GerarNovoCalculoSemPreencherCepOrigemECepDestino() {

		try {
			executeScenario_("Novo Calculo","Gerar Novo Calculo sem Preencher CEP Origem e CEP Destino");
		} catch (Exception e) {
			logger.error(getMessage("Error on execution"), e);
			Assert.fail("Test error.", e);
		}	
	}

	
	@BeforeMethod
	public void beforeMethod(final Method method, final ITestContext context) {
		super.setup(method, context);
	}
	
	@AfterMethod
	public void teardown(final Method method, final ITestContext context) {
		super.teardown(method, context);
	}
	
}
