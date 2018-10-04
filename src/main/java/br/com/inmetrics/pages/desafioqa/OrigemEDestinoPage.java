package br.com.inmetrics.pages.desafioqa;

import static com.br.inmetrics.frm.base.DefaultBaseController.getPage_;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementById;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementByText;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementBys;
import static com.br.inmetrics.frm.utils.ScreenshotUtils.takeScreenshot_;
import static com.br.inmetrics.frm.utils.LoggerUtils.getMessage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.br.inmetrics.frm.base.PageBase;
import com.br.inmetrics.frm.base.VirtualElement;
import com.br.inmetrics.frm.exceptions.ElementFindException;

public class OrigemEDestinoPage extends PageBase {
	
	Logger logger = Logger.getLogger(OrigemEDestinoPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement 	campoCEPOrigem = getElementById("br.com.correios.calculaprecoprazo:id/txt_cep_ori"), 	
					campoCEPDestino = getElementById("br.com.correios.calculaprecoprazo:id/txt_cep_dest"),
					tituloPagina = getElementByText("ORIGEM E DESTINO"),
					botaoProximoPasso = getElementById("br.com.correios.calculaprecoprazo:id/button_prox");

	
	public boolean verificarPagina() throws ElementFindException {
		
		logger.debug(getMessage("Verificação da existencia da tela Origem e Destino"));
				
		return waitUntilExists(tituloPagina, 10);				
	}
	
	public void preencherOrigemEDestino(String cepOrigem, String cepDestino) throws ElementFindException {	
				
		logger.debug(getMessage("Início do preenchimento dos campos 'CEP de origem' e 'CEP de destino'"));
		
		campoCEPOrigem.sendKeys(cepOrigem);
		campoCEPDestino.sendKeys(cepDestino);
		
		hideKeyboard();
		logger.debug(getMessage("Fim do preenchimento dos campos 'CEP de origem' e 'CEP de destino'"));
	
	}	
	
	public void clicarBotaoProximoPasso() throws ElementFindException {
		logger.debug(getMessage("Início do clique do botao 'Proximo Passo'"));
		
		botaoProximoPasso.click();
		
		logger.debug(getMessage("Fim do clique do botao 'Proximo Passo'"));
	
	}
	
	public void teste() throws ElementFindException {
		@SuppressWarnings("rawtypes")
		VirtualElement teste = getElementBys(By.xpath("//android.widget.Toast[1]"));
		
		waitUntilExists(teste);
		
		String text = teste.getAttribute("name");
	}
}