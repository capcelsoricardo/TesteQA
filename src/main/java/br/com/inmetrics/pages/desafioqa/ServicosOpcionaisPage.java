package br.com.inmetrics.pages.desafioqa;

import static com.br.inmetrics.frm.base.DefaultBaseController.getPage_;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementById;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementByText;
import static com.br.inmetrics.frm.utils.ScreenshotUtils.takeScreenshot_;
import static com.br.inmetrics.frm.utils.LoggerUtils.getMessage;

import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.br.inmetrics.frm.base.PageBase;
import com.br.inmetrics.frm.base.VirtualElement;
import com.br.inmetrics.frm.exceptions.ElementFindException;

public class ServicosOpcionaisPage extends PageBase {
	
	Logger logger = Logger.getLogger(ServicosOpcionaisPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement 	tituloPagina = getElementByText("SERVIÇOS OPCIONAIS"),
					checkBoxMaoPropria = getElementById("br.com.correios.calculaprecoprazo:id/checkMP"),
					botaoCalcular = getElementById("br.com.correios.calculaprecoprazo:id/button_calcular");

	
	public boolean verificarPagina() throws ElementFindException {
		
		logger.debug(getMessage("Verificação da existencia da tela Servicos Opcionais"));
				
		return waitUntilExists(tituloPagina, 10);				
	}
	
	public void selecionarMaoPropria() throws ElementFindException {	
				
		logger.debug(getMessage("Selecao da opcao 'Mao Propria'"));
		
		checkBoxMaoPropria.click();
	
	}	
	
	public void clicarBotaoCalcular() throws ElementFindException {
		logger.debug(getMessage("Início do clique do botao 'Calcular'"));
		
		botaoCalcular.click();
		
		logger.debug(getMessage("Fim do clique do botao 'Calcular'"));
	
	}
}