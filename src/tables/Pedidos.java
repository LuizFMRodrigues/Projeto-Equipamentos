package tables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;

public class Pedidos {

	private String pedido;
	private String nome;
	private String cpf;
	private Endereco endereco;
	private String telefone;
	private String email;
	private Equipamento equip;
	private boolean pendente;
	private DateTime Criado;
	private DateTime Finalizado;
	
	public Pedidos(String pedido, String nome, String cpf, Endereco endereco, String telefone, String email, Equipamento equip, int status) {
		this.pedido = pedido;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.equip = equip;
		if (status == 0) {
			this.pendente = true;
		}
		if (status == 1) {
			this.pendente = false;
		}
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public DateTime getCriado() {
		return Criado;
	}

	public void setCriado(DateTime criado) {
		Criado = criado;
	}

	public DateTime getFinalizado() {
		return Finalizado;
	}

	public void setFinalizado(DateTime finalizado) {
		Finalizado = finalizado;
	}

	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isPendente() {
		return pendente;
	}

	public void setStatus(boolean pendente) {
		this.pendente = pendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Equipamento getEquip() {
		return equip;
	}

	public void setEquip(Equipamento equip) {
		this.equip = equip;
	}
	
	public void salvarPedido(String idFunc) throws IOException {
		String linhas[] = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = new Date();
		
		String path = "c:\\Projeto Equipamentos\\Pedidos\\" + this.pedido + ".txt";
		
		String frase;
		
		frase = "-------------------- Cliente --------------------\n";
		frase += "Nome= " + this.nome + "\n";
		frase += "CPF= " + this.cpf + "\n";
		frase += "Cidade= " + this.endereco.getCidade() + "\n";
		frase += "Bairro= " + this.endereco.getBairro() + "\n";
		frase += "Rua= " + this.endereco.getRua() + "\n";
		frase += "Número= " + this.endereco.getNum() + "\n";
		frase += "CEP= " + this.endereco.getCep() + "\n";
		frase += "Bloco= " + this.endereco.getBloco() + "\n";
		frase += "Apartamento= " + this.endereco.getApartamento() + "\n";
		frase += "Telefone= " + this.telefone + "\n";
		frase += "Email= " + this.email + "\n";
		frase += "-------------------- Equipamento --------------------\n";
		frase += "Descrição= " + this.equip.getDescricao() + "\n";
		frase += "Tipo= " + this.equip.getTipo() + "\n";
		frase += "Marca= " + this.equip.getMarca() + "\n";
		frase += "-------------------- Pedido --------------------\n";
		frase += "Funcionário= " + idFunc + "\n";
		
		if (new File (path).exists()) {
			
			linhas = Arquivos.lerLinhasArquivo(path);
			
			String[] dataIni = linhas[18].split("= ");
			
			if (pendente) {
				
				if (dataIni[1].equals("") || dataIni[1].equals(" ") || dataIni[1].equals("  ")) {
					int resposta = JOptionPane.showConfirmDialog(null, "Colocar a data atual como a data inical do pedido?", "Atenção!", JOptionPane.YES_NO_OPTION);
					
					if (resposta == JOptionPane.YES_OPTION) {
						frase += "Data Inicial= " + sdf.format(data) + "\n";
					} else if (resposta == JOptionPane.NO_OPTION) {
						// Mostra o formato de data
						String texto = JOptionPane.showInputDialog(null, "Informe a data inicial do pedido! 'DD/MM/AAAA HH:MM:SS'");
						frase += "Data Inicial= " + texto + "\n";
					}
					
				// Se no arquivo já houver uma Data Inicial
				} else {
					int resposta = JOptionPane.showConfirmDialog(null, "Este pedido já possui uma data inicial: " + dataIni[1] + ". Deseja mante-la?", "Atenção!", JOptionPane.YES_NO_OPTION);
					
					if (resposta == JOptionPane.YES_OPTION) {
						frase += "Data Inicial= " + dataIni[1] + "\n";
					} else if (resposta == JOptionPane.NO_OPTION) {
						// Mostra o formato de data
						String texto = JOptionPane.showInputDialog("Informe a data inicial do pedido! 'DD/MM/AAAA HH:MM:SS'");
						frase += "Data Inicial= " + texto + "\n";
					}
				}
				
				frase += "Data Final= \n";
				frase += "Status= Pendente";
				
			// Se o pedido foi finalizado
			} else {
				if (dataIni[1].equals("") || dataIni[1].equals(" ") || dataIni[1].equals("  ")) {
					int resposta = JOptionPane.showConfirmDialog(null, "Colocar a data atual como a data inical do pedido?", "Atenção!", JOptionPane.YES_NO_OPTION);
					
					if (resposta == JOptionPane.YES_OPTION) {
						frase += "Data Inicial= " + sdf.format(data) + "\n";
					} else if (resposta == JOptionPane.NO_OPTION) {
						// Mostra o formato de data
						String texto = JOptionPane.showInputDialog(null, "Informe a data inicial do pedido! 'DD/MM/AAAA HH:MM:SS'");
						frase += "Data Inicial= " + texto + "\n";
					}
					
				// Se no arquivo já houver uma Data Inicial
				} else {
					int resposta = JOptionPane.showConfirmDialog(null, "Este pedido já possui uma data inicial: " + dataIni[1] + ". Deseja mante-la?", "Atenção!", JOptionPane.YES_NO_OPTION);
					
					if (resposta == JOptionPane.YES_OPTION) {
						frase += "Data Inicial= " + dataIni[1] + "\n";
					} else if (resposta == JOptionPane.NO_OPTION) {
						// Mostra o formato de data
						String texto = JOptionPane.showInputDialog("Informe a data inicial do pedido! 'DD/MM/AAAA HH:MM:SS'");
						frase += "Data Inicial= " + texto + "\n";
					}
				}
				
				int respostaB = JOptionPane.showConfirmDialog(null, "Colocar a data atual como a data FINAL do pedido?", "Atenção!", JOptionPane.YES_NO_OPTION);
				
				if (respostaB == JOptionPane.YES_OPTION) {
					frase += "Data Final= " + sdf.format(data) + "\n";
				} else if (respostaB == JOptionPane.NO_OPTION) {
					String texto = JOptionPane.showInputDialog("Informe a data FINAL do pedido! 'DD/MM/AAAA HH:MM:SS'");
					frase += "Data Final= " + texto + "\n";
				}
				
				frase += "Status= Finalizado";
				
			}
			
			if (!new File("c:\\Projeto Equipamentos\\Pedidos\\").exists()) {
				boolean success = (new File("c:\\Projeto Equipamentos\\Pedidos\\")).mkdirs();
				if (!success) {
					JOptionPane.showMessageDialog(null, "Falha ao criar o diretório!", "Erro!", 0);
				}
			}
			
		// se o arquivo não existir
		} else {
			
			if (pendente) {
				int resposta = JOptionPane.showConfirmDialog(null, "Colocar a data atual como a data inical do pedido?", "Atenção!", JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					frase += "Data Inicial= " + sdf.format(data) + "\n";
				} else if (resposta == JOptionPane.NO_OPTION) {
					// Mostra o formato de data
					String texto = JOptionPane.showInputDialog(null, "Informe a data inicial do pedido! 'DD/MM/AAAA HH:MM:SS'");
					frase += "Data Inicial= " + texto + "\n";
				}
				
				frase += "Data Final= \n";
				frase += "Status= Pendente";
				
			// Se o pedido foi finalizado
			} else {
				String texto = JOptionPane.showInputDialog(null, "Informe a data inicial do pedido! 'DD/MM/AAAA HH:MM:SS'");
				frase += "Data Inicial= " + texto + "\n";
				
				int resposta = JOptionPane.showConfirmDialog(null, "Colocar a data atual como a data final do pedido?", "Atenção!", JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION) {
					frase += "Data Final= " + sdf.format(data) + "\n";
				} else if (resposta == JOptionPane.NO_OPTION) {
					JOptionPane.showInputDialog("Informe a data final do pedido! 'DD/MM/AAAA HH:MM:SS'");
					// ainda não faz nada
				}
				
				frase += "Status= Finalizado";
				
			}
		}
		
		File arq;
		
		// se o pedido estiver finalizado o nome do arquivo começará com "F"
		if (pendente) {
			arq = new File("c:\\Projeto Equipamentos\\Pedidos\\", this.pedido + ".txt");
		} else {
			if (new File (path).exists()) {
				File file = new File(path);
				boolean sucsess = file.delete();
				
				if (!sucsess) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar o arquivo!", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			arq = new File("c:\\Projeto Equipamentos\\Pedidos\\","[F] " + this.pedido + ".txt");
		}
		
		Arquivos.escreverArquivo(arq, frase);
	}
}