package br.com.inmetrics.pages.desafioqa;

import static com.br.inmetrics.frm.helpers.QueryHelper.getElementById;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementByText;
import static com.br.inmetrics.frm.utils.LoggerUtils.getMessage;

import org.testng.log4testng.Logger;

import com.br.inmetrics.frm.base.PageBase;
import com.br.inmetrics.frm.base.VirtualElement;
import com.br.inmetrics.frm.exceptions.ElementFindException;

public class FormatoPage extends PageBase {
	
	Logger logger = Logger.getLogger(FormatoPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement 	tituloPagina = getElementByText("FORMATO"), 	
					imagemEnvelope = getElementById("br.com.correios.calculaprecoprazo:id/imgCarta"),
					imagemCaixaPacote = getElementById("br.com.correios.calculaprecoprazo:id/imgCaixa"),
					campoAltura = getElementById("br.com.correios.calculaprecoprazo:id/txt_altura"),
					campoLargura = getElementById("br.com.correios.calculaprecoprazo:id/txt_largura"),
					campoComprimento = getElementById("br.com.correios.calculaprecoprazo:id/txt_comprimento"),
					checkBoxPesoEstimado = getElementById("br.com.correios.calculaprecoprazo:id/checkAte300"),
					botaoContinuar = getElementById("br.com.correios.calculaprecoprazo:id/button_prox");

	
	public boolean verificarPagina() throws ElementFindException {
		
		logger.debug(getMessage("Verificação da existencia da tela Origem e Destino"));
				
		return waitUntilExists(tituloPagina, 10);				
	}
	
	public void preencherInformacoesEnvelope(String largura, String comprimento, boolean qtdGramasDefault) throws ElementFindException {	
				
		logger.debug(getMessage("Início do preenchimento das informações do Envelope"));
		imagemEnvelope.click();
		
		campoLargura.sendKeys(largura);
		campoComprimento.sendKeys(comprimento);
		hideKeyboard();
		
		if (qtdGramasDefault)
			checkBoxPesoEstimado.click();
		
		logger.debug(getMessage("Fim do preenchimento das informações do Envelope"));
	
	}	
	
	
	public void preencherInformacoesCaixaPacote(String altura, String largura, String comprimento, boolean qtdGramasDefault) throws ElementFindException {	
		
		logger.debug(getMessage("Início do preenchimento das informações do Envelope"));
		imagemCaixaPacote.click();
		
		campoAltura.sendKeys(altura);
		campoLargura.sendKeys(largura);
		campoComprimento.sendKeys(comprimento);
		
		hideKeyboard();
		if (qtdGramasDefault)
			checkBoxPesoEstimado.click();
		
		logger.debug(getMessage("Fim do preenchimento das informações do Envelope"));
	
	}
	
	public void clicarBotaoContinuar() throws ElementFindException {
		logger.debug(getMessage("Início do clique do botão 'Continuar'"));
		
		botaoContinuar.click();
		
		logger.debug(getMessage("Fim do clique do botão 'Continuar'"));
	
	}
}