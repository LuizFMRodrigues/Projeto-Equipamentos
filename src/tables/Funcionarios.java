package tables;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Funcionarios {

	private String idFuncionario;
	private String nome;
	private String cpf;
	private String cargo;
	
	public Funcionarios(String idFuncionario, String nome, String cpf, String cargo) throws IOException {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		
		this.SalvarFuncionario();
	}
	
	public void SalvarFuncionario() throws IOException {
		String texto;
		
		texto = "Id= " + this.idFuncionario + "\n";
		texto += "Nome= " + this.nome + "\n";
		texto += "CPF= " + this.cpf + "\n";
		texto += "Cargo= " + this.cargo + "\n";
		
		if (!new File("c:\\Projeto Equipamentos\\Funcion�rios\\").exists()) {
			boolean success = (new File("c:\\Projeto Equipamentos\\Funcion�rios\\")).mkdirs();
			if (!success) {
				JOptionPane.showMessageDialog(null, "Falha ao criar o diret�rio!");
			}
		}
		
		boolean existe = new File("c:\\Projeto Equipamentos\\Funcion�rios\\", this.idFuncionario + ".txt").exists();
		
		File arq = new File("c:\\Projeto Equipamentos\\Funcion�rios\\", this.idFuncionario + ".txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(arq));
		bw.write(texto);
		bw.flush();
		bw.close();
		
		if (existe) {
			JOptionPane.showMessageDialog(null, "Funcion�rio atualizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com sucesso!");
		}
	}
	
	public void cadastrarPedido() {
		
	}
}
