package br.com.contmatic.model.v1.endereco;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static br.com.contmatic.model.v1.endereco.EstadoType.*;
import static br.com.contmatic.model.v1.endereco.PaisType.*;
import static br.com.contmatic.testes.v1.util.TestesUtils.retornaEstadoAleatorio;

public class CidadeTest {

	private String nome;
	
	private Estado estado;

	private Cidade cid;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(" --- Início dos Testes da Classe Cidade --- \n");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("\n --- Fim dos Testes da Classe Cidade --- \n");
	}

	@Before
	public void setUp() throws Exception {
		this.nome = "Cidade Teste";
		this.estado = new Estado(retornaEstadoAleatorio());
		this.cid = new Cidade(nome, estado);
	}

	@After
	public void tearDown() throws Exception {
		this.nome = null;
		this.estado = null;
		this.cid = null;
	}

	@Test(expected = Test.None.class)
	public void deve_aceitar_tipo_cidade_sendo_passado_valido() {
		cid = new Cidade("Pananapiacaba", PR);
	}

	@Test
	public void nao_deve_aceitar_nome_cidade_sendo_passado_nulo() {
		Exception e = assertThrows("Nomes nulos não devem ser aceitos", IllegalArgumentException.class,
				() -> cid = new Cidade(null, SC));
		assertThat(e.getMessage(), equalTo("O campo nome da classe Cidade não pode ser nulo."));
	}
	
	@Test
	public void nao_deve_aceitar_nome_cidade_sendo_passado_vazio() {
		Exception e = assertThrows("Nomes vazios não devem ser aceitos", IllegalArgumentException.class,
				() -> cid = new Cidade("             ", SC));
		assertThat(e.getMessage(), startsWith("O campo nome da classe Cidade foi informado em branco"));
	}

	@Test
	public void nao_deve_aceitar_nome_cidade_muito_grande() {
		Exception e = assertThrows("Nomes enormes não devem ser aceitos", IllegalArgumentException.class,
				() -> cid = new Cidade("ExemploDeUmNomeDeUmaCidadeMuitoMuitoGrandeMesmoQueNaoDeveriaSerAceito", SC));
		assertThat(e.getMessage(), startsWith("O campo nome da classe Cidade não pode ter esse tamanho."));
	}
	
	@Test
	public void nao_deve_aceitar_nome_cidade_contendo_numeros() {
		Exception e = assertThrows("Nomes com numeros não devem ser aceitos", IllegalArgumentException.class,
				() -> cid = new Cidade("Pananapi489", SC));
		assertThat(e.getMessage(), equalTo("O campo nome da classe Cidade não pode possuir dígitos."));
	}
	
	@Test
	public void nao_deve_aceitar_estado_sendo_passado_nulo() {
		Estado estado = null;
		Exception e = assertThrows("Estados nulos não devem ser aceitos", IllegalArgumentException.class,
				() -> cid = new Cidade("Mogi Das Cruzes", estado));
		assertThat(e.getMessage(), equalTo("O campo estado da classe Cidade não pode ser nulo."));
	}

	@Test
	public void teste_toString() {
		assertNotNull(cid.toString());
	}

	@Test
	public void teste_equals_simetria() {
		Cidade a = new Cidade("São Paulo", "São Paulo", "Sp", BRASIL);
		Cidade b = new Cidade("São Paulo", "São Paulo", "SP", BRASIL);
		assertTrue(a.equals(b) && b.equals(a));
	}

	@Test
	public void teste_equals_reflexividade() {
		assertEquals(cid, cid);
	}

	@Test
	public void teste_equals_transitividade() {
		Cidade a = new Cidade("Sidney", "Ohio", "OH", ESTADOS_UNIDOS);
		Cidade b = new Cidade("Sidney", "Ohio", "OH", ESTADOS_UNIDOS);
		Cidade c = new Cidade("Sidney", "Ohio", "OH", ESTADOS_UNIDOS);
		assertTrue((a.equals(b) && b.equals(c)) && (a.equals(c)));
	}

	@Test
	public void teste_equals_objetos_nulos_devem_retornar_false() {
		assertNotEquals(cid, null);
	}

	@Test
	public void teste_equals_Cidades_diferentes_devem_ser_diferentes_uma_da_outra() {
		Cidade cidadeA = new Cidade("Campo Grande", AL);
		Cidade cidadeB = new Cidade("Rio Branco", AC);
		assertNotEquals(cidadeA, cidadeB);
	}
	
	@Test
	public void teste_equals_Cidades_com_nomes_diferentes_nao_devem_ser_iguais() {
		Cidade cidadeA = new Cidade("Tartarugalzinho", AP);
		Cidade cidadeB = new Cidade("Porto Grande", AP);
		assertNotEquals(cidadeA, cidadeB);
	}
	
	@Test
	public void teste_equals_Cidades_com_nomes_iguais_mas_UF_diferentes_nao_devem_ser_iguais() {
		Cidade cidadeA = new Cidade("Rio Branco", AC);
		Cidade cidadeB = new Cidade("Rio Branco", MT);
		assertNotEquals(cidadeA, cidadeB);
	}

	@Test
	public void teste_hashcode_consistencia() {
		Cidade a = new Cidade("Houston", "Texas", "TX", ESTADOS_UNIDOS);
		Cidade b = new Cidade("Houston", "Texas", "TX", ESTADOS_UNIDOS);
		assertEquals(a.hashCode(), b.hashCode());
	}

}
