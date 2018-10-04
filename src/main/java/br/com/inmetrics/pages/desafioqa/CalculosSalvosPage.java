package br.com.inmetrics.pages.desafioqa;

import static com.br.inmetrics.frm.helpers.QueryHelper.getElementByText;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementBys;
import static com.br.inmetrics.frm.utils.LoggerUtils.getMessage;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.br.inmetrics.frm.base.PageBase;
import com.br.inmetrics.frm.base.VirtualElement;
import com.br.inmetrics.frm.exceptions.ElementFindException;

public class CalculosSalvosPage extends PageBase {

	Logger logger = Logger.getLogger(CalculosSalvosPage.class);

	@SuppressWarnings("rawtypes")
	VirtualElement tituloPagina = getElementByText("Cálculos Salvos");

	public boolean verificarPagina() throws ElementFindException {

		logger.debug(getMessage("Verificação da existencia da tela Calculos Salvos"));

		return waitUntilExists(tituloPagina, 10);
	}

	public boolean checarNomeCalculoSalvo(String nome_) throws ElementFindException {
		
		@SuppressWarnings("rawtypes")
		VirtualElement nomeCalculo = getElementBys(By.xpath("//android.widget.TextView[@text='" + nome_ + "']"));

		return nomeCalculo.getText().equals(nome_);
	}

	public boolean checarDataCalculoSalvo(String nome_, String dataCalculo_) throws ElementFindException {

		@SuppressWarnings("rawtypes")
		VirtualElement dataCalculo = getElementBys(By.xpath("//android.widget.TextView[@text='" + nome_
				+ "']//ancestor::android.widget.RelativeLayout[1]/android.widget.TextView[2]"));

		return dataCalculo.getText().equals(dataCalculo_);
		
	}

	public boolean checarTipoLargXCompSalvo(String nome_, String tipoELargXComp_) throws ElementFindException {

		@SuppressWarnings("rawtypes")
		VirtualElement tipoELargXComp = getElementBys(By.xpath("//android.widget.TextView[@text='" + nome_
				+ "']//ancestor::android.widget.RelativeLayout[1]/android.widget.TextView[3]"));

		return  tipoELargXComp.getText().equals(tipoELargXComp_);

	}

	public boolean checarOrigemCalculoSalvo(String nome_, String origem_) throws ElementFindException {
		
		@SuppressWarnings("rawtypes")
		VirtualElement origem = getElementBys(By.xpath("//android.widget.TextView[@text='" + nome_
				+ "']//ancestor::android.widget.RelativeLayout[1]/android.widget.TextView[4]"));

		return  origem.getText().equals(origem_);

	}

	public boolean checarDestinoCalculoSalvo(String nome_, String destino_) throws ElementFindException {

		@SuppressWarnings("rawtypes")
		VirtualElement destino = getElementBys(By.xpath("//android.widget.TextView[@text='" + nome_
				+ "']//ancestor::android.widget.RelativeLayout[1]/android.widget.TextView[5]"));

		return destino.getText().equals(destino_);

	}

}