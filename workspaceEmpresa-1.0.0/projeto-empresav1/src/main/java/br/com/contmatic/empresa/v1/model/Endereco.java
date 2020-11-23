package br.com.contmatic.empresa.v1.model;

import br.com.contmatic.empresa.viacep.ViaCEP;

public class Endereco {

    private static final int TAMANHO_COMPLEMENTO = 15;

    private static final int NUMERO_TAMANHO_MAX = 5;

    private static final int NUMERO_TAMANHO_MIN = 1;

    private static final int TAMANHO_CEP = 8;

    private String rua;

    private String bairro;

    private String numero;

    private String cep;

    private String complemento;

    private String cidade;

    private TipoEstado estado;

    private Endereco(ViaCEP endereco, String numero) {
        this.setRua(endereco.getLogradouro());
        this.setBairro(endereco.getBairro());
        this.setNumero(numero);
        this.setCep(endereco.getCep());
        this.setComplemento("");
        this.setCidade(endereco.getLocalidade());
        this.setEstado(Enum.valueOf(TipoEstado.class, endereco.getUf()));
    }

    private Endereco(ViaCEP endereco, String numero, String complemento) {
        this.setRua(endereco.getLogradouro());
        this.setBairro(endereco.getBairro());
        this.setNumero(numero);
        this.setCep(endereco.getCep());
        this.setComplemento(complemento);
        this.setCidade(endereco.getLocalidade());
        this.setEstado(Enum.valueOf(TipoEstado.class, endereco.getUf()));
    }

    public static Endereco cadastraEndereco(String cep, String numero) {
        validaNulo(cep);
        validaTamanhoCep(cep);
        validaFormatoCep(cep);
        ViaCEP cepValidado = buscaInformacoesCep(cep);
        return new Endereco(cepValidado, numero);
    }

    public static Endereco cadastraEndereco(String cep, String numero, String complemento) {
        validaNulo(cep);
        validaTamanhoCep(cep);
        validaFormatoCep(cep);
        ViaCEP cepValidado = buscaInformacoesCep(cep);
        return new Endereco(cepValidado, numero, complemento);
    }

    private static ViaCEP buscaInformacoesCep(String cep) {
        ViaCEP viaCEP = new ViaCEP();

        try {
            viaCEP.buscar(cep);
            return viaCEP;
        } catch (Exception viaCEPException) {
            throw new IllegalArgumentException(
                    "Ops.. Parece que não foi possível obter as informações do seu CEP. Por favor verifique se você digitou seu CEP corretamente");
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.validaVazioViaCep(rua);
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.validaVazioViaCep(bairro);
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validaNulo(numero);
        this.validaVazio(numero);
        this.validaTamanhoNumero(numero);
        this.validaFormatoNumeracao(numero);
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.validaVazioViaCep(cep);
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        validaNulo(complemento);
        validaTamanhoComplemento(complemento);
        validaFormatoComplemento(complemento);
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.validaVazioViaCep(numero);
        this.cidade = cidade;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    private static void validaNulo(String valor) {
        if (valor == null) {
            throw new NullPointerException("Valor não pode ser nulo");
        }
    }

    private static void validaTamanhoCep(String cep) {
        if (cep.length() != TAMANHO_CEP) {
            throw new IllegalArgumentException(
                    "O tamanho do CEP inserido não é válido. Por favor, insira o CEP sem formatação ou espaços em branco");
        }
    }

    private static void validaFormatoCep(String cep) {
        for (int i = 0; i < TAMANHO_CEP; ++i) {
            if (!Character.isDigit(cep.charAt(i))) {
                throw new IllegalArgumentException("O CEP só pode sor composto de números");
            }
        }
    }

    private void validaVazioViaCep(String valorViaCep) {
        if (valorViaCep.isEmpty()) {
            throw new IllegalArgumentException(
                    "Ops, um valor vazio foi rebecido pelo ViaCep. Isto não deveria ter acontecido");
        }
    }

    private void validaVazio(String numero) {
        if (numero.isEmpty()) {
            throw new IllegalArgumentException("Você não pode inserir uma numeração em branca");
        }
    }

    private void validaTamanhoNumero(String numero) {
        if (numero.length() < NUMERO_TAMANHO_MIN || numero.length() > NUMERO_TAMANHO_MAX) {
            throw new IllegalArgumentException("Tamanho do numero passado não pode ser aceito. Insira uma numeração de "
                    + NUMERO_TAMANHO_MIN + " até " + NUMERO_TAMANHO_MAX);
        }
    }

    private void validaFormatoNumeracao(String numero) {
        for (int i = 0; i < numero.length() - 1; ++i) {
            if (!Character.isDigit(numero.charAt(i))) {
                throw new IllegalArgumentException("Este tipo de numeracao \"" + numero + "\" não pode ser aceita");
            }
        }
        validaUltimoDigito(numero.charAt(numero.length() - 1), numero);
    }

    private void validaUltimoDigito(char c, String numero) {
        if (!isUltimoDigitoLetra(c, numero)) {
            throw new IllegalArgumentException("Último dígito desse formato de número precisa ser uma letra. Não " + c);
        } else if (!isUltimoDigitoLetraOuNumero(c, numero)) {
            throw new IllegalArgumentException(
                    "Último dígito desse formato de número pode ser uma letra ou número. Não " + c);
        }
    }

    private boolean isUltimoDigitoLetraOuNumero(char c, String numero) {
        return !(numero.length() < NUMERO_TAMANHO_MAX && !Character.isLetterOrDigit(c));
    }

    private boolean isUltimoDigitoLetra(char c, String numero) {
        return !(numero.length() == NUMERO_TAMANHO_MAX && !Character.isLetter(c));
    }

    private void validaFormatoComplemento(String complemento) {
        if (complemento.contains("!") || complemento.contains("@") 
                || complemento.contains("#") || complemento.contains("()")
                || complemento.contains("$") || complemento.contains("%")
                || complemento.contains("&") || complemento.contains("_") 
                || complemento.contains("?") || complemento.contains(",")) {
            throw new IllegalArgumentException("Complemento não pode possuir caracteres especiais.");
        }
    }

    private void validaTamanhoComplemento(String complemento) {
        if (complemento.length() > TAMANHO_COMPLEMENTO) {
            throw new IllegalArgumentException(
                    "Tamanho de complemento inserido precisa ser menor que " + TAMANHO_COMPLEMENTO);
        }
    }

    public static int getNumeroTamanhoMax() {
        return NUMERO_TAMANHO_MAX;
    }

    public static int getNumeroTamanhoMin() {
        return NUMERO_TAMANHO_MIN;
    }

    public static int getTamanhoCep() {
        return TAMANHO_CEP;
    }

    public static int getTamanhoComplemento() {
        return TAMANHO_COMPLEMENTO;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Rua=" + rua + ", Numero=" + numero + ", Bairro=" + bairro + ", Cep=" + cep + ", Cidade=" + cidade
                + ", Complemento=" + complemento + ", Estado=" + estado;
    }
}
