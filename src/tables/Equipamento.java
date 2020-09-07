package tables;

public class Equipamento {
	private String descricao;
	private String tipo;
	private String marca;
	
	public Equipamento(String descricao, String tipo, String marca) {
		this.descricao = descricao;
		this.tipo = tipo;
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}