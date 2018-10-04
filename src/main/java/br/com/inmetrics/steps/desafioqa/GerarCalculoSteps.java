package br.com.inmetrics.steps.desafioqa;

import static com.br.inmetrics.frm.base.DefaultBaseController.getPage_;
import static com.br.inmetrics.frm.helpers.DataTableHelper.getDt_;
import static com.br.inmetrics.frm.helpers.QueryHelper.getElementBys;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.br.inmetrics.frm.base.VirtualElement;
import com.br.inmetrics.frm.bdd.DesignSteps;
import com.br.inmetrics.frm.bdd.Step;
import com.br.inmetrics.frm.exceptions.ElementFindException;

import br.com.inmetrics.pages.desafioqa.CalculosSalvosPage;
import br.com.inmetrics.pages.desafioqa.FormatoPage;
import br.com.inmetrics.pages.desafioqa.MenuPrincipalPage;
import br.com.inmetrics.pages.desafioqa.OrigemEDestinoPage;
import br.com.inmetrics.pages.desafioqa.PopUpsPage;
import br.com.inmetrics.pages.desafioqa.ResultadoDoCalculoPage;
import br.com.inmetrics.pages.desafioqa.ServicosOpcionaisPage;

@DesignSteps 
public class GerarCalculoSteps {
	
	// Paginas que serao utilizadas
	MenuPrincipalPage menuPrincipalPage = getPage_(MenuPrincipalPage.class);
	OrigemEDestinoPage origemEDestinoPage = getPage_(OrigemEDestinoPage.class);
	FormatoPage formatoPage = getPage_(FormatoPage.class);
	ServicosOpcionaisPage servicosOpcionaisPage = getPage_(ServicosOpcionaisPage.class);
	ResultadoDoCalculoPage resultadoDoCalculoPage = getPage_(ResultadoDoCalculoPage.class);
	PopUpsPage popUpsPage = getPage_(PopUpsPage.class);
	CalculosSalvosPage calculosSalvosPage = getPage_(CalculosSalvosPage.class);
	
	
	@Step("Dado que eu esteja na tela de Novo Cálculo")
	public void dadoEstejaNaTelaNovoCalculo() throws ElementFindException {
		
		Assert.assertTrue(menuPrincipalPage.verificarPagina(), "Menu Principal exibido com sucesso");
		
		menuPrincipalPage.clicarNovoCalculo();
		
		Assert.assertTrue(origemEDestinoPage.verificarPagina(), "Pagina 'Origem e Destino' exibida com sucesso.");
	}
	
	@Step("Quando faço a geração do Novo Cálculo para um Envelope")
	public void quandoGeroNovoCalculoParaEnvelope() throws ElementFindException {
	
		origemEDestinoPage.preencherOrigemEDestino(getDt_().getStringOf("CEP_ORIGEM"), getDt_().getStringOf("CEP_DESTINO"));
		origemEDestinoPage.clicarBotaoProximoPasso();
		Assert.assertTrue(formatoPage.verificarPagina(), "Pagina 'Formato e Dimensao e Peso' exibida com sucesso.");
		formatoPage.preencherInformacoesEnvelope(getDt_().getStringOf("LARGURA"), getDt_().getStringOf("COMPRIMENTO"), Boolean.parseBoolean(getDt_().getStringOf("PESO_PADRAO")));
		formatoPage.clicarBotaoContinuar();
		Assert.assertTrue(servicosOpcionaisPage.verificarPagina(), "Pagina 'Servicos Opcionais' exibida com sucesso.");	
		servicosOpcionaisPage.selecionarMaoPropria();
		servicosOpcionaisPage.clicarBotaoCalcular();
		Assert.assertTrue(resultadoDoCalculoPage.verificarPagina(), "Pagina 'Resultados do Calculo' exibida com sucesso.");	
		resultadoDoCalculoPage.clicarBotaoSalvar();
		
		Assert.assertTrue(popUpsPage.popUpNomeDoCalculoVerificarExiste(), "Pagina 'Pop up 'Nome do Calculo' exibido com sucesso.");
		popUpsPage.popUpNomeDoCalculoPreenchimento(getDt_().getStringOf("NOME_CALCULO"));
	}
	
	@Step("Então é exibido novo calculo para um Envelope em Calculos Salvo")
	public void exibeNovoCalculoParaEnvelopeEmCalculosSalvos() throws ElementFindException {
		
		menuPrincipalPage.clicarMenuPrincipal();
		menuPrincipalPage.clicarCalculosSalvos();
		
		Assert.assertTrue(calculosSalvosPage.verificarPagina(), "Pagina 'Calculos Salvos' exibida com sucesso.");	
		
		Assert.assertTrue(calculosSalvosPage.checarNomeCalculoSalvo(getDt_().getStringOf("NOME_CALCULO")),"Nome do calculo exibido com sucesso.");	
		Assert.assertTrue(calculosSalvosPage.checarDataCalculoSalvo(getDt_().getStringOf("NOME_CALCULO"), "Data do cálculo: " + getDt_().getStringOf("DATA_CALCULO")),"Data do calculo exibida com sucesso.");
		Assert.assertTrue(calculosSalvosPage.checarTipoLargXCompSalvo(getDt_().getStringOf("NOME_CALCULO"), "Carta/Envelope (largxcomp): " + getDt_().getStringOf("LARGURA") + "x" + getDt_().getStringOf("COMPRIMENTO")), "Tipo, Largura x Comp. do calculo exibido com sucesso.");
		Assert.assertTrue(calculosSalvosPage.checarOrigemCalculoSalvo(getDt_().getStringOf("NOME_CALCULO"), "Origem: " + getDt_().getStringOf("CEP_ORIGEM_C")), "CEP Origem do calculo exibida com sucesso.");
		Assert.assertTrue(calculosSalvosPage.checarDestinoCalculoSalvo(getDt_().getStringOf("NOME_CALCULO"), "Destino: " + getDt_().getStringOf("CEP_DESTINO_C")), "CEP Destino do calculo exibido com sucesso.");
	}
	
	@Step("Então é exibido novo calculo para uma Caixa/Pacote em Calculos Salvo")
	public void exibeNovoCalculoParaCaixaPacoteEmCalculosSalvos() throws ElementFindException {
		
		menuPrincipalPage.clicarMenuPrincipal();
		menuPrincipalPage.clicarCalculosSalvos();
		
		Assert.assertTrue(calculosSalvosPage.verificarPagina(), "Pagina 'Calculos Salvos' exibida com sucesso.");	
		
		Assert.assertTrue(calculosSalvosPage.checarNomeCalculoSalvo(getDt_().getStringOf("NOME_CALCULO")),"Nome do calculo exibido com sucesso.");	
		Assert.assertTrue(calculosSalvosPage.checarDataCalculoSalvo(getDt_().getStringOf("NOME_CALCULO"), "Data do cálculo: " + getDt_().getStringOf("DATA_CALCULO")),"Data do calculo exibida com sucesso.");
		Assert.assertTrue(calculosSalvosPage.checarTipoLargXCompSalvo(getDt_().getStringOf("NOME_CALCULO"), "Caixa (altxlargxcomp): " + getDt_().getStringOf("ALTURA") + "x" + getDt_().getStringOf("LARGURA") + "x" + getDt_().getStringOf("COMPRIMENTO")), "Tipo, Altura x Largura x Comp. do calculo exibido com sucesso.");
		Assert.assertTrue(calculosSalvosPage.checarOrigemCalculoSalvo(getDt_().getStringOf("NOME_CALCULO"), "Origem: " + getDt_().getStringOf("CEP_ORIGEM_C")), "CEP Origem do calculo exibida com sucesso.");
		Assert.assertTrue(calculosSalvosPage.checarDestinoCalculoSalvo(getDt_().getStringOf("NOME_CALCULO"), "Destino: " + getDt_().getStringOf("CEP_DESTINO_C")), "CEP Destino do calculo exibido com sucesso.");
	}
	
	
	@Step("Quando faço a geração do Novo Cálculo para uma Caixa/Pacote")
	public void quandoGeroNovoCalculoParaCaixaPacote() throws ElementFindException {
		origemEDestinoPage.preencherOrigemEDestino(getDt_().getStringOf("CEP_ORIGEM"), getDt_().getStringOf("CEP_DESTINO"));
		origemEDestinoPage.clicarBotaoProximoPasso();
		Assert.assertTrue(formatoPage.verificarPagina(), "Pagina 'Formato e Dimensao e Peso' exibida com sucesso.");
		formatoPage.preencherInformacoesCaixaPacote(getDt_().getStringOf("ALTURA"), getDt_().getStringOf("LARGURA"), getDt_().getStringOf("COMPRIMENTO"), Boolean.parseBoolean(getDt_().getStringOf("PESO_PADRAO")));
		formatoPage.clicarBotaoContinuar();
		Assert.assertTrue(servicosOpcionaisPage.verificarPagina(), "Pagina 'Servicos Opcionais' exibida com sucesso.");	
		servicosOpcionaisPage.selecionarMaoPropria();
		servicosOpcionaisPage.clicarBotaoCalcular();
		Assert.assertTrue(resultadoDoCalculoPage.verificarPagina(), "Pagina 'Resultados do Calculo' exibida com sucesso.");	
		resultadoDoCalculoPage.clicarBotaoSalvar();
		
		Assert.assertTrue(popUpsPage.popUpNomeDoCalculoVerificarExiste(), "Pagina 'Pop up 'Nome do Calculo' exibido com sucesso.");
		popUpsPage.popUpNomeDoCalculoPreenchimento(getDt_().getStringOf("NOME_CALCULO"));
		
	}
	
	@Step("Quando faço a geração do Novo Cálculo sem Preencher CEP Origem")
	public void geroNovoCalculoSemCEPOrigem() throws ElementFindException {
		origemEDestinoPage.preencherOrigemEDestino("", getDt_().getStringOf("CEP_DESTINO"));
		origemEDestinoPage.clicarBotaoProximoPasso();
	}
	
	@Step("Quando faço a geração do Novo Cálculo sem Preencher CEP Destino")
	public void geroNovoCalculoSemCEPDestino() throws ElementFindException {
		origemEDestinoPage.preencherOrigemEDestino(getDt_().getStringOf("CEP_ORIGEM"), "");
		origemEDestinoPage.clicarBotaoProximoPasso();
	}
	
	@Step("Quando faço a geração do Novo Cálculo sem Preencher CEP Origem e CEP Destino")
	public void geroNovoCalculoSemCEPOrigemECEPDestino() throws ElementFindException {
		origemEDestinoPage.preencherOrigemEDestino("", "");
		origemEDestinoPage.clicarBotaoProximoPasso();
	}
	
	@Step("Então não sou direcionado para a página de Formato") 
	public void paginaFormatoNaoApresentada() throws ElementFindException {
		Assert.assertTrue(!servicosOpcionaisPage.verificarPagina(), "Pagina 'Servicos Opcionais'não exibida com sucesso.");	
	}
}
