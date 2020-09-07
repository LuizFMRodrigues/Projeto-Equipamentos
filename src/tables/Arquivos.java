package tables;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

// classe para ler e criar os arquivos de texto
public class Arquivos {

	public static String lerTodoArquivo(String path) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String linha = "";
		String dados = "";
		
		linha = reader.readLine();
		
		while (true) {
			if (linha != null) {
				dados += linha;
				dados += "\n";
			} else 
				break;
			
			linha = reader.readLine();
		}
		
		reader.close();
		
		return dados;
	}
	
	public static String[] lerLinhasArquivo(String path) throws IOException {
		
		String texto = Arquivos.lerTodoArquivo(path);
		return texto.split("\n");
	}
	
	public static void escreverArquivo(File arq, String frase) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(arq));
		bw.write(frase);
		bw.flush();
		bw.close();
		
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}
	
	public static String[] prepararLista(File file) throws IOException {
		if (!file.exists()) {
			JOptionPane.showMessageDialog(null, "Erro ao ler um arquivo!");
			return null;
		}
		
		String[] linhas = Arquivos.lerLinhasArquivo(file.toString());
		
		String[] status = linhas[20].split("=");
		String[] nome = linhas[1].split("=");
		String[] cpf = linhas[2].split("=");
		String[] equip = linhas[14].split("=");
		String[] dataIni = linhas[18].split("=");
		String[] dataFin = linhas[19].split("=");
		
		String[] dados = {status[1], nome[1], cpf[1], equip[1], dataIni[1], dataFin[1]};
		
		return dados;
	}
}
