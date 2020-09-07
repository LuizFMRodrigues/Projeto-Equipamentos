package tables;
public class Endereco {
	
	private String cidade;
	private String bairro;
	private String rua;
	private String num;
	private String cep;
	private String bloco;
	private String apartamento;
	
	public Endereco(String cidade, String bairro, String rua, String num, String cep, String bloco, String apartamento) {
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.num = num;
		this.cep = cep;
		this.bloco = bloco;
		this.apartamento = apartamento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
}
