package br.com.contmatic.model.v1.endereco;

import static br.com.contmatic.model.v1.endereco.EstadoType.AC;
import static br.com.contmatic.model.v1.endereco.EstadoType.AL;
import static br.com.contmatic.model.v1.endereco.EstadoType.MT;
import static br.com.contmatic.model.v1.endereco.EstadoType.RO;
import static br.com.contmatic.model.v1.endereco.PaisType.BRASIL;
import static br.com.contmatic.model.v1.endereco.PaisType.ESTADOS_UNIDOS;
import static br.com.contmatic.testes.v1.util.TestesUtils.NULLSTR;
import static br.com.contmatic.testes.v1.util.TestesUtils.retornaEstadoAleatorio;
import static br.com.contmatic.util.v1.CamposTypes.ENDERECO_TAMANHO_COMPLEMENTO;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class EnderecoTest {

	private static Random random = new Random();

	private String rua;

	private String bairro;

	private Integer numero;

	private String complemento;

	private String cep;

	private Cidade cidade;

	private Endereco end;

	private static final List<String> CEPS_VALIDOS_LISTA = Arrays.asList("77017004", "29170713", "59607084", "69318708",
			"68030190");

	private static final List<String> COMPLEMENTOS_LISTA = Arrays.asList("Apt 801", "Casa A", "Casa B", "Apt 21", "");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(" --- Início dos Testes da Classe Endereco --- \n");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("\n --- Fim dos Testes da Classe Endereco --- \n");
	}

	@Before
	public void setUp() throws Exception {
		this.rua = "Rua Teste";
		this.bairro = "Bairro Teste";
		this.numero = retornaNumero();
		this.cep = retornaCepValido();
		this.complemento = retornaComplemento();
		this.cidade = retornaCidade();
		this.end = new Endereco(rua, bairro, numero, cep, complemento, cidade);
	}
	
	@After
	public void tearDown() throws Exception {
		this.rua = null;
		this.bairro = null;
		this.numero = 0;
		this.cep = null;
		this.complemento = null;
		this.cidade = null;
		this.end = null;
	}

	private Cidade retornaCidade() {
		return new Cidade("Cidade Teste", retornaEstadoAleatorio());
	}

	private static String retornaComplemento() {
		return COMPLEMENTOS_LISTA.get(random.nextInt(COMPLEMENTOS_LISTA.size()));
	}

	private static Integer retornaNumero() {
		return random.nextInt(9999);
	}

	private static String retornaCepValido() {
		return CEPS_VALIDOS_LISTA.get(random.nextInt(CEPS_VALIDOS_LISTA.size()));
	}

	@Test(expected = Test.None.class)
	public void deve_aceitar_Endereco_passando_valores_validos() {
		end = new Endereco("Rua Genêrica", "Bairro Genêrico", retornaNumero(), "45869081", "Apt 81", new Cidade("Campus do Jordão", RO));
	}

	@Test(expected = Test.None.class)
	public void deve_aceitar_Endereco_mesmo_nao_passando_complemento() {
		end = new Endereco("Rua dos Testes", "Lago dos testes", retornaNumero(), retornaCepValido(), new Cidade("Sydnei", "Ohio", "OH", PaisType.ESTADOS_UNIDOS));
	}

	@Test(expected = Test.None.class)
	public void deve_aceitar_rua_com_símbolos_ou_numeros() {
		end.setRua("1ª Travessa Tomé de Sousa");
	}

	@Test
	public void nao_deve_aceitar_rua_nula() {
		Exception nu = assertThrows("Nao deve permitir rua nula", IllegalArgumentException.class,
				() -> end.setRua(NULLSTR));
		assertThat(nu.getMessage(), equalTo("O campo rua da classe Endereco não pode ser nulo."));
	}

	@Test
	public void nao_deve_aceitar_rua_com_tamanho_invalido() {
		Exception e = assertThrows("Nao deve permitir rua com tamanho invalido", IllegalArgumentException.class,
				() -> end.setRua("ExemploDeUmNomeParaRuaQueNaoDeveriaSerAceitoDevidoOSeuTamanho"));
		assertThat(e.getMessage(), startsWith("O campo rua da classe Endereco não pode ter esse tamanho."));
	}

	@Test(expected = Test.None.class)
	public void deve_bairro_com_simbolos_ou_numeros() {
		end.setBairro("Setor Norte (Brazlândia)");
	}

	@Test
	public void nao_deve_aceitar_bairro_nulo() {
		Exception nu = assertThrows("Nao deve permitir bairro nulo", IllegalArgumentException.class,
				() -> end.setBairro(NULLSTR));
		assertThat(nu.getMessage(), equalTo("O campo bairro da classe Endereco não pode ser nulo."));
	}

	@Test
	public void nao_deve_aceitar_bairro_com_tamanho_invalido() {
		Exception e = assertThrows("Nao deve permitir bairro com tamanho invalido",
				IllegalArgumentException.class, () -> end.setBairro("ExemploDeUmNomeParaEnderecoQueNaoDeveriaSerAceitoDevidoOSeuTamanho"));
		assertThat(e.getMessage(), startsWith("O campo bairro da classe Endereco não pode ter esse tamanho."));
	}

	@Test(expected = Test.None.class)
	public void deve_numeracao_de_endereco_valida() {
		end.setNumero(1148);
	}

	@Test
	public void nao_deve_aceitar_numeracao_de_endereco_nula() {
		assertThrows("Numeração de endereco nula não deve ser permitida",
				IllegalArgumentException.class, () -> end.setNumero(null));
	}

	@Test
	public void nao_deve_aceitar_numeracoes_de_endereco_invalidas() {
		Integer[] numerosMalFormados = { -1, 10000, 0, -545 };
		for (Integer numero : numerosMalFormados) {
			Exception e = assertThrows("Nao deve permitir numero com formato errado",
					IllegalArgumentException.class, () -> end.setNumero(numero));
			assertThat(e.getMessage(), startsWith("O campo numero da classe Endereco não pode ter esse tamanho."));
		}
	}

	@Test(expected = Test.None.class)
	public void deve_aceitar_cep_com_tamanho_formato_validos() {
		end.setCep("03575090");
	}

	@Test
	public void nao_deve_aceitar_cep_nulo() {
		Exception nu = assertThrows("Nao deve permitir cep nulo", IllegalArgumentException.class,
				() -> end.setCep(NULLSTR));
		assertThat(nu.getMessage(), equalTo("O campo cep da classe Endereco não pode ser nulo."));
	}

	@Test
	public void nao_deve_aceitar_cep_com_tamanho_errado() {
		Exception e = assertThrows("Nao deve permitir cep com tamanho errado", IllegalArgumentException.class,
				() -> end.setCep("03575 09000"));
		assertThat(e.getMessage(), startsWith("O campo cep da classe Endereco não pode ter esse tamanho."));
	}

	@Test
	public void nao_deve_aceitar_cep_com_formato_errado() {
		Exception e = assertThrows("Nao deve permitir cep com formato errado", IllegalArgumentException.class,
				() -> end.setCep("        "));
		assertThat(e.getMessage(), equalTo("O campo cep da classe Endereco só pode possuir dígitos."));
	}


	@Test(expected = Test.None.class)
	public void deve_aceitar_complemento_valido() {
		end.setComplemento("Apt 126");
	}

	@Test
	public void nao_deve_aceitar_complemento_nulo() {
		Exception nu = assertThrows("Nao deve permitir complemento nulo", IllegalArgumentException.class,
				() -> end.setComplemento(NULLSTR));
		assertThat(nu.getMessage(), equalTo("O campo complemento da classe Endereco não pode ser nulo."));
	}

	@Test
	public void nao_deve_aceitar_complemento_com_tamanho_invalido() {
		Exception e = assertThrows("Nao deve permitir complemento com tamanho invalido",
				IllegalArgumentException.class, () -> end.setComplemento("Exemplo de um Complemento Muito Grande"));
		assertThat(e.getMessage(),
				equalTo("Tamanho de complemento inserido precisa ser menor que " + ENDERECO_TAMANHO_COMPLEMENTO + "."));
	}

	@Test
	public void nao_deve_aceitar_complemento_com_formato_invalido() {
		Exception e = assertThrows("Nao deve permitir complemento invalido", IllegalArgumentException.class,
				() -> end.setComplemento("Apt.@#$@"));
		assertThat(e.getMessage(),
				equalTo("O campo complemento da classe Endereco não pode possuir caracteres especiais."));
	}

	@Ignore("ViaCep não está mais presente no projeto")
	@Test
	public void nao_deve_aceitar_valor_retornado_do_viaCep_que_estiver_vazio() {
		Exception e = assertThrows("Algo improvável acabou de acontecer...",
				IllegalArgumentException.class, () -> end.setRua(""));
		assertThat(e.getMessage(),
				equalTo("Ops, um valor vazio foi rebecido pelo ViaCep. Isto não deveria ter acontecido."));
	}

	@Test(expected = Test.None.class)
	public void deve_aceitar_cidade_valida() {
		end.setCidade(new Cidade("Guarulhos", "São Paulo", "SP", BRASIL));
	}

	@Test
	public void nao_deve_aceitar_cidade_nula() {
		Exception e = assertThrows("Cidades nulas não devem ser aceitas", IllegalArgumentException.class,
				() -> end.setCidade(null));
		assertThat(e.getMessage(), equalTo("O campo cidade da classe Endereco não pode ser nulo."));
	}

	@Test
	public void teste_equals_simetria() {
		Endereco a = new Endereco("Rua dos testes", "Jardim test", 4564, "74323139", new Cidade("Sidney", "Ohio", "OH", ESTADOS_UNIDOS));
		Endereco b = new Endereco("Rua dos testes", "Jardim test", 4564, "74323139", new Cidade("Sidney", "Ohio", "OH", ESTADOS_UNIDOS));
		assertTrue(a.equals(b) && b.equals(a));
	}

	@Test
	public void teste_equals_reflexividade() {
		assertEquals(end, end);
	}

	@Test
	public void teste_equals_transitividade() {
		Endereco a = new Endereco("Avenida Radial Teste", "Jardim test", 841, "30775540", new Cidade("Campo Grande", AL));
		Endereco b = new Endereco("Avenida Radial Teste", "Jardim test", 841, "30775540", new Cidade("Campo Grande", AL));
		Endereco c = new Endereco("Avenida Radial Teste", "Jardim test", 841, "30775540", new Cidade("Campo Grande", AL));
		assertTrue((a.equals(b) && b.equals(c)) && (a.equals(c)));
	}

	@Test
	public void teste_equals_objetos_nulos_devem_retornar_false() {
		assertNotEquals(end, null);
	}

	@Test
	public void teste_equals_Enderecos_com_ceps_diferente_nao_devem_ser_iguais() {
		Endereco Endereco1 = new Endereco("Travessa Lourenço do Teste", "Centro", 921, "68997970", new Cidade("Rio Branco", AC));
		Endereco Endereco = new Endereco("Travessa Lourenço do Teste", "Centro", 921, "68997991", new Cidade("Rio Branco", AC));
		assertNotEquals(Endereco1, Endereco);
	}

	@Test
	public void teste_equals_Enderecos_com_numeros_diferente_nao_devem_ser_iguais() {
		Endereco Endereco1 = new Endereco("Travessa Lourenço do Teste", "Centro", 921, "68997970", new Cidade("Houston", "Texas", "TX", ESTADOS_UNIDOS));
		Endereco Endereco = new Endereco("Travessa Lourenço do Teste", "Centro", 1021, "68997991", new Cidade("Houston", "Texas", "TX", ESTADOS_UNIDOS));
		assertNotEquals(Endereco1, Endereco);
	}

	@Test
	public void teste_hashcode_consistencia() {
		new Endereco(rua, bairro, numero, cep, cidade);
		Endereco a = new Endereco("Avenida Testedade", "São Bento", 921, "58305006", new Cidade("Rio Branco", MT));
		Endereco b = new Endereco("Avenida Testedade do Teste", "São Bento", 921, "58305006", new Cidade("Rio Branco", MT));
		assertEquals(a.hashCode(), b.hashCode());
	}

	@Test
	public void teste_toString() {
		assertNotNull(end.toString());
	}
}
