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

public class MenuPrincipalPage extends PageBase {
	
	Logger logger = Logger.getLogger(MenuPrincipalPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement 	menu = getElementById("android:id/up"),
					menuNovoCalculo = getElementByText("Novo cálculo"),
					menuCalculosSalvos = getElementByText("Cálculos Salvos");

	public boolean verificarPagina() throws ElementFindException {
		
		logger.debug(getMessage("Verificação da existencia do menu principal"));
				
		return waitUntilExists(menu, 10);				
	}
	
	
	
   public void clicarMenuPrincipal() throws ElementFindException {
		
		logger.debug(getMessage("Início clicar Menu"));
		
		menu.click();
		
		logger.debug(getMessage("Final clicar Menu"));
	}

	public void clicarNovoCalculo() throws ElementFindException {	
				
		logger.debug(getMessage("Início Novo Calculo"));
		
		menuNovoCalculo.click();
		
		logger.debug(getMessage("Final Novo Calculo"));
	
	}	
	
	public void clicarCalculosSalvos() throws ElementFindException {	
		
		logger.debug(getMessage("Início clicar 'Calculos Salvos'"));
		
		menuCalculosSalvos.click();
		
		logger.debug(getMessage("Final clicar 'Calculos Salvos'"));
	
	}	
}