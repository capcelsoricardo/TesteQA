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

public class PopUpsPage extends PageBase {
	
	Logger logger = Logger.getLogger(PopUpsPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement 	popUpNomeDoCalculoTitulo = getElementByText("Nome do cálculo"),
					popUpNomeDoCalculoCampoNomeCalculo = getElementById("br.com.correios.calculaprecoprazo:id/ed_nome_calculo"),
					popUpNomeDoCalculoBotaoOk = getElementById("br.com.correios.calculaprecoprazo:id/bt_ok");
					
	
	public boolean popUpNomeDoCalculoVerificarExiste() throws ElementFindException {
		
		logger.debug(getMessage("Verificação da existencia do popUp Nome do Calculo"));
				
		return waitUntilExists(popUpNomeDoCalculoTitulo, 10);				
	}
	

	public void popUpNomeDoCalculoPreenchimento (String nome) throws ElementFindException {
		
		logger.debug(getMessage("Preenchimento do 'Nome do Cálculo' e clique no botao 'Ok'"));
		
		popUpNomeDoCalculoCampoNomeCalculo.sendKeys(nome);
		popUpNomeDoCalculoBotaoOk.click();

		
		logger.debug(getMessage("Fim do preenchimento do 'Nome do Cálculo' e clique no botao 'Ok'"));
	}
}