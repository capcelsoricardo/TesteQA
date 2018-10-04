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

public class ResultadoDoCalculoPage extends PageBase {
	
	Logger logger = Logger.getLogger(ResultadoDoCalculoPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement 	tituloPagina = getElementByText("RESULTADOS DO CÁLCULO"),
					botaoSalvar = getElementById("br.com.correios.calculaprecoprazo:id/action_salvar");

	
	public boolean verificarPagina() throws ElementFindException {
		
		logger.debug(getMessage("Verificação da existencia da tela Resultados do Cálculo"));
				
		return waitUntilExists(tituloPagina, 10);				
	}
	

	public void clicarBotaoSalvar() throws ElementFindException {
		
		logger.debug(getMessage("Início do clique do botao 'Salvar'"));
		
		botaoSalvar.click();
		
		logger.debug(getMessage("Fim do clique do botao 'Salvar'"));
	}
}