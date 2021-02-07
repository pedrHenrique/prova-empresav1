package br.com.contmatic.model.v1.telefone;

import br.com.contmatic.model.v1.empresa.endereco.PaisType;

public enum DDIType {
	
	DDI1_ANGUILA   					("1 ", PaisType.ANGUILA),
	DDI1_ANTIGUA_E_BARBUDA  		("1 ", PaisType.ANTIGUA_E_BARBUDA),
	DDI1_BAHAMAS   					("1 ", PaisType.BAHAMAS),
	DDI1_BARBADOS   				("1 ", PaisType.BARBADOS),
	DDI1_BERMUDAS   				("1 ", PaisType.BERMUDAS),
	DDI1_CANADA   					("1 ", PaisType.CANADA),
	DDI1_DOMINICA   				("1 ", PaisType.DOMINICA),
	DDI1_ESTADOS_UNIDOS   			("1 ", PaisType.ESTADOS_UNIDOS),
	DDI1_GRANADA   					("1 ", PaisType.GRANADA),
	DDI1_ILHAS_CAIMAO   			("1 ", PaisType.ILHAS_CAIMAO),
	DDI1_ILHAS_MARIANAS_DO_NORTE   	("1 ", PaisType.MARIANAS_DO_NORTE),
	DDI1_ILHAS_VIRGENS_AMERICANAS   ("1 ", PaisType.ILHAS_VIRGENS_AMERICANAS),
	DDI1_ILHAS_VIRGENS_BRITANICAS   ("1 ", PaisType.ILHAS_VIRGENS_BRITANICAS),
	DDI1_JAMAICA   					("1 ", PaisType.JAMAICA),
	DDI1_MONTSERRAT   				("1 ", PaisType.MONSERRATE),
	DDI1_PORTO_RICO   				("1 ", PaisType.PORTO_RICO),
	DDI1_REPUBLICA_DOMINICANA   	("1 ", PaisType.REPUBLICA_DOMINICANA),
	DDI1_SAMOA_AMERICANA   			("1 ", PaisType.SAMOA_AMERICANA),
	DDI1_SANTA_LUCIA   				("1 ", PaisType.SANTA_LUCIA),
	DDI1_SAO_CRISTOVAO_E_NEVES   	("1 ", PaisType.SAO_CRISTOVAO_E_NEVES),
	DDI1_SAO_VICENTE_E_GRANADINAS   ("1 ", PaisType.SAO_VICENTE_E_GRANADINAS),
	DDI1_TRINIDAD_E_TOBAGO   		("1 ", PaisType.TRINDADE_E_TOBAGO),
	DDI1_TURCAS_E_CAICOS   			("1 ", PaisType.ILHAS_TURCAS_E_CAICOS),
	DDI7_CASAQUISTAO   				("7 ", PaisType.CAZAQUISTAO),
	DDI7_RUSSIA   					("7 ", PaisType.RUSSIA),
	DDI20  							("20 ", PaisType.EGITO),
	DDI27  							("27 ", PaisType.AFRICA_DO_SUL),
	DDI30  							("30 ", PaisType.GRECIA),
	DDI31  							("31 ", PaisType.PAISES_BAIXOS),
	DDI32  							("32 ", PaisType.BELGICA),
	DDI33  							("33 ", PaisType.FRANCA),
	DDI34  							("34 ", PaisType.ESPANHA),
	DDI36  							("36 ", PaisType.HUNGRIA),
	DDI39  							("39 ", PaisType.ITALIA),
	DDI40  							("40 ", PaisType.ROMENIA),
	DDI41  							("41 ", PaisType.SUICA),
	DDI43  							("43 ", PaisType.AUSTRIA),
	DDI44  							("44 ", PaisType.REINO_UNIDO),
	DDI45  							("45 ", PaisType.DINAMARCA),
	DDI46  							("46 ", PaisType.SUECIA),
	DDI47  							("47 ", PaisType.NORUEGA),
	DDI48  							("48 ", PaisType.POLONIA),
	DDI49  							("49 ", PaisType.ALEMANHA),
	DDI51  							("51 ", PaisType.PERU),
	DDI52  							("52 ", PaisType.MEXICO),
	DDI53  							("53 ", PaisType.CUBA),
	DDI54  							("54 ", PaisType.ARGENTINA),
	DDI55  							("55 ", PaisType.BRASIL),
	DDI56  							("56 ", PaisType.CHILE),
	DDI57  							("57 ", PaisType.COLOMBIA),
	DDI58  							("58 ", PaisType.VENEZUELA),
	DDI60  							("60 ", PaisType.MALASIA),
	DDI61  							("61 ", PaisType.AUSTRALIA),
	DDI62  							("62 ", PaisType.INDONESIA),
	DDI63  							("63 ", PaisType.FILIPINAS),
	DDI64  							("64 ", PaisType.NOVA_ZELANDIA),
	DDI65  							("65 ", PaisType.SINGAPURA),
	DDI66  							("66 ", PaisType.TAILANDIA),
	DDI81  							("81 ", PaisType.JAPAO),
	DDI82  							("82 ", PaisType.COREIA_DO_SUL),
	DDI84  							("84 ", PaisType.VIETNA),
	DDI86  							("86 ", PaisType.CHINA),
	DDI90  							("90 ", PaisType.TURQUIA),
	DDI91  							("91 ", PaisType.INDIA),
	DDI92  							("92 ", PaisType.PAQUISTAO),
	DDI93  							("93 ", PaisType.AFEGANISTAO),
	DDI94  							("94 ", PaisType.SRI_LANCA),
	DDI95  							("95 ", PaisType.BIRMANIA),
	DDI98  							("98 ", PaisType.IRA),
	DDI212_MARROCOS 				("212", PaisType.MARROCOS),
	DDI212_SAARA_OCIDENTAL 			("212", PaisType.SAARA_OCIDENTAL),
	DDI213 							("213", PaisType.ARGELIA),
	DDI216 							("216", PaisType.TUNISIA),
	DDI218 							("218", PaisType.LIBIA),
	DDI220 							("220", PaisType.GAMBIA),
	DDI221 							("221", PaisType.SENEGAL),
	DDI222 							("222", PaisType.MAURITANIA),
	DDI223 							("223", PaisType.MALI),
	DDI224 							("224", PaisType.GUINE),
	DDI225 							("225", PaisType.COSTA_DO_MARFIM),
	DDI226 							("226", PaisType.BURQUINA_FASO),
	DDI227 							("227", PaisType.NIGER),
	DDI228 							("228", PaisType.TOGO),
	DDI229 							("229", PaisType.BENIM),
	DDI230 							("230", PaisType.MAURICIO),
	DDI231 							("231", PaisType.LIBERIA),
	DDI232 							("232", PaisType.SERRA_LEOA),
	DDI233 							("233", PaisType.GANA),
	DDI234 							("234", PaisType.NIGERIA),
	DDI235 							("235", PaisType.CHADE),
	DDI236 							("236", PaisType.REPUBLICA_CENTRO_AFRICANA),
	DDI237 							("237", PaisType.CAMAROES),
	DDI238 							("238", PaisType.CABO_VERDE),
	DDI239 							("239", PaisType.SAO_TOME_E_PRINCIPE),
	DDI240 							("240", PaisType.GUINE_EQUATORIAL),
	DDI241 							("241", PaisType.GABAO),
	DDI242 							("242", PaisType.CONGO_BRAZZAVILLE),
	DDI243 							("243", PaisType.CONGO_KINSHASA),
	DDI244 							("244", PaisType.ANGOLA),
	DDI245 							("245", PaisType.GUINE_BISSAU),
	DDI246 							("246", PaisType.TERRITORIO_BRITANICO_DO_OCEANO_INDICO),
	DDI247 							("247", PaisType.ILHA_DE_ASCENSAO),
	DDI248 							("248", PaisType.SEICHELES),
	DDI249 							("249", PaisType.SUDAO),
	DDI250 							("250", PaisType.RUANDA),
	DDI251 							("251", PaisType.ETIOPIA),
	DDI252 							("252", PaisType.SOMALIA),
	DDI253 							("253", PaisType.DJIBUTI),
	DDI254 							("254", PaisType.QUENIA),
	DDI255 							("255", PaisType.TANZANIA),
	DDI256 							("256", PaisType.UGANDA),
	DDI257 							("257", PaisType.BURUNDI),
	DDI258 							("258", PaisType.MOCAMBIQUE),
	DDI260 							("260", PaisType.ZAMBIA),
	DDI261 							("261", PaisType.MADAGASCAR),
	DDI262 							("262", PaisType.REUNIAO),
	DDI263 							("263", PaisType.ZIMBABUE),
	DDI264 							("264", PaisType.NAMIBIA),
	DDI265 							("265", PaisType.MALAWI),
	DDI266 							("266", PaisType.LESOTO),
	DDI267 							("267", PaisType.BOTSUANA),
	DDI268 							("268", PaisType.SUAZILANDIA),
	DDI269_COMORES 					("269", PaisType.COMORES),
	DDI269_MAYOTTE 					("269", PaisType.MAYOTTE),
	DDI290 							("290", PaisType.SANTA_HELENA),
	DDI291 							("291", PaisType.ERITREIA),
	DDI297 							("297", PaisType.ARUBA),
	DDI298 							("298", PaisType.FAROE),
	DDI299 							("299", PaisType.GROELANDIA),
	DDI350 							("350", PaisType.GIBRALTAR),
	DDI351 							("351", PaisType.PORTUGAL),
	DDI352 							("352", PaisType.LUXEMBURGO),
	DDI353 							("353", PaisType.IRLANDA),
	DDI354 							("354", PaisType.ISLANDIA),
	DDI355 							("355", PaisType.ALBANIA),
	DDI356 							("356", PaisType.MALTA),
	DDI357 							("357", PaisType.CHIPRE),
	DDI358 							("358", PaisType.FINLANDIA),
	DDI359 							("359", PaisType.BULGARIA),
	DDI370 							("370", PaisType.LITUANIA),
	DDI371 							("371", PaisType.LETONIA),
	DDI372 							("372", PaisType.ESTONIA),
	DDI373 							("373", PaisType.MOLDAVIA),
	DDI374 							("374", PaisType.ARMENIA),
	DDI375 							("375", PaisType.BIELORRUSSIA),
	DDI376 							("376", PaisType.ANDORRA),
	DDI377 							("377", PaisType.MONACO),
	DDI378 							("378", PaisType.SAO_MARINHO),
	DDI379 							("379", PaisType.VATICANO),
	DDI380 							("380", PaisType.UCRANIA),
	DDI381 							("381", PaisType.SERVIA),
	DDI382 							("382", PaisType.MONTENEGRO),
	DDI385 							("385", PaisType.CROACIA),
	DDI386 							("386", PaisType.ESLOVENIA),
	DDI387 							("387", PaisType.BOSNIA_E_HERZEGOVINA),
	DDI389 							("389", PaisType.MACEDONIA),
	DDI420 							("420", PaisType.REPUBLICA_TCHECA),
	DDI421 							("421", PaisType.ESLOVAQUIA),
	DDI423 							("423", PaisType.LISTENSTAINE),
	DDI473 							("473", PaisType.GRENADA),
	DDI500 							("500", PaisType.MALDIVAS),
	DDI501 							("501", PaisType.BELIZE),
	DDI502 							("502", PaisType.GUATEMALA),
	DDI503 							("503", PaisType.EL_SALVADOR),
	DDI504 							("504", PaisType.HONDURAS),
	DDI505 							("505", PaisType.NICARAGUA),
	DDI506 							("506", PaisType.COSTA_RICA),
	DDI507 							("507", PaisType.PANAMA),
	DDI508 							("508", PaisType.SAO_PEDRO_E_MIQUELON),
	DDI509 							("509", PaisType.HAITI),
	DDI590_GUADALUPE 				("590", PaisType.GUADALUPE),
	DDI590_SAO_MARTINHO 			("590", PaisType.SAO_MARTINHO),
	DDI591 							("591", PaisType.BOLIVIA),
	DDI592 							("592", PaisType.GUIANA),
	DDI593 							("593", PaisType.EQUADOR),
	DDI594 							("594", PaisType.GUIANA_FRANCESA),
	DDI595 							("595", PaisType.PARAGUAI),
	DDI596 							("596", PaisType.MARTINICA),
	DDI597 							("597", PaisType.SURINAME),
	DDI598 							("598", PaisType.URUGUAI),
	DDI599 							("599", PaisType.SAO_MARTINHO),
	DDI670 							("670", PaisType.TIMOR_LESTE),
	DDI671 							("671", PaisType.GUAME),
	DDI672_ILHA_DO_NATAL 			("672", PaisType.ILHA_DO_NATAL),
	DDI672_ILHAS_DOS_COCOS 			("672", PaisType.ILHAS_DOS_COCOS),
	DDI672_ILHA_NORFOLK 			("672", PaisType.ILHA_NORFOLK),
	DDI672_ILHAS_HEARD_E_MCDONALD 	("672", PaisType.ILHAS_HEARD_E_MCDONALD),
	DDI673 							("673", PaisType.BRUNEI),
	DDI674 							("674", PaisType.NAURU),
	DDI675 							("675", PaisType.PAPUA_NOVA_GUINE),
	DDI676 							("676", PaisType.TONGA),
	DDI677 							("677", PaisType.ILHAS_SALOMAO),
	DDI678 							("678", PaisType.VANUATU),
	DDI679 							("679", PaisType.FIJI),
	DDI680 							("680", PaisType.PALAU),
	DDI681 							("681", PaisType.WALLIS_E_FUTUNA),
	DDI682 							("682", PaisType.ILHAS_COOK),
	DDI683 							("683", PaisType.NIUE),
	DDI685 							("685", PaisType.SAMOA),
	DDI686 							("686", PaisType.QUIRIBATI),
	DDI687 							("687", PaisType.NOVA_CALEDONIA),
	DDI688 							("688", PaisType.TUVALU),
	DDI689 							("689", PaisType.POLINESIA_FRANCESA),
	DDI690 							("690", PaisType.TOKELAU),
	DDI691 							("691", PaisType.MICRONESIA),
	DDI692 							("692", PaisType.ILHAS_MARSHALL),
	DDI850 							("850", PaisType.COREIA_DO_NORTE),
	DDI852 							("852", PaisType.HONG_KONG),
	DDI853 							("853", PaisType.MACAU),
	DDI855 							("855", PaisType.CAMBOJA),
	DDI856 							("856", PaisType.LAOS),
	DDI880 							("880", PaisType.BANGLADECHE),
	DDI886 							("886", PaisType.TAIWAN),
	DDI960 							("960", PaisType.MALDIVAS),
	DDI961 							("961", PaisType.LIBANO),
	DDI962 							("962", PaisType.JORDANIA),
	DDI963 							("963", PaisType.SIRIA),
	DDI964 							("964", PaisType.IRAQUE),
	DDI965 							("965", PaisType.KUWAIT),
	DDI966 							("966", PaisType.ARABIA_SAUDITA),
	DDI967 							("967", PaisType.IEMEN),
	DDI968 							("968", PaisType.OMA),
	DDI970 							("970", PaisType.ESTADO_DE_PALESTINA),
	DDI971 							("971", PaisType.EMIRADOS_ARABES_UNIDOS),
	DDI972 							("972", PaisType.ISRAEL),
	DDI973 							("973", PaisType.BAREM),
	DDI974 							("974", PaisType.CATAR),
	DDI975 							("975", PaisType.BUTAO),
	DDI976 							("976", PaisType.MONGOLIA),
	DDI977 							("977", PaisType.NEPAL),
	DDI992 							("992", PaisType.TAJIQUISTAO),
	DDI993 							("993", PaisType.TURQUEMENISTAO),
	DDI994 							("994", PaisType.AZERBAIJAO),
	DDI995 							("995", PaisType.GEORGIA),
	DDI996 							("996", PaisType.QUIRGUIZISTAO),
	DDI998 							("998", PaisType.USBEQUISTAO),
	NAO_EXISTE 						("Não possui");

	private String ddi;
	
	private PaisType pais;
	
	private DDIType(String ddi, PaisType pais) {
		this.ddi = ddi;
		this.pais = pais;
	}
	
	private DDIType(String ddi) {
		this.ddi = ddi;
	}

	public String getDdi() {
		return ddi;
	}

	public PaisType getPais() {
		return pais;
	}
	
}
