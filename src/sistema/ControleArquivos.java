package sistema;

import dados.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ControleArquivos {

	// ---------------------------- criação do arquivo para a mesma pasta que está
	// nosso código ----------------------------

	public boolean criar(String nome) {
		try {
			File arquivo = new File(nome);

			if (arquivo.createNewFile()) {
				System.out.println("Arquivo criado com sucesso.\nCaminho: " + arquivo.getAbsolutePath());
				return true;
			} else {
				System.out.println("Arquivo já existe.");
				return true;
			}

		} catch (IOException e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
			return false;
		}
	}

	// ---------------------------- escrita e leitura do arquivo
	// ----------------------------
	public void escreverArquivo(String nome, ArrayList<Integer> vetor) {

		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nome))) {
			for (int num : vetor) {
				escritor.write(num + "\n");
			}
		} catch (IOException e) {
			System.out.println("erro ao salvar numeros " + e.getMessage());
		}

	}

	public ArrayList<Integer> gerarNumerosAleatorios(String nome, int num) {
		int valor; 
		Random aleatorio = new Random();
		ArrayList<Integer> vetor = new ArrayList<>(num);
		
			for (int i = 0; i < num; i++) {
				valor = aleatorio.nextInt(1000);
				vetor.add(valor);
			}
			return vetor;
	}

	public ArrayList<Integer> gerarNumerosCrescentes(String nome, int num) {
		ArrayList<Integer> vetor = gerarNumerosAleatorios(nome, num);
		Collections.sort(vetor);
	
		return vetor;
	}

	public ArrayList<Integer> gerarNumerosDecrescentes(String nome, int num) {
		ArrayList<Integer> vetor = gerarNumerosAleatorios(nome, num);
		Collections.sort(vetor);
		Collections.reverse(vetor);
		
		return vetor;
	}

	public Item[] lerArquivo(String nome) {
		String linha; // o proprio codigo pode ler uma linha de cada vez
		ArrayList<Item> numerosList = new ArrayList<>();
		Item num;

		try (BufferedReader leitor = new BufferedReader(new FileReader(nome))) {

			while ((linha = leitor.readLine()) != null) {
				num = new Item(Integer.parseInt(linha.trim()));
				numerosList.add(num);
			}

			leitor.close();
		} catch (IOException e) {
			System.out.println("erro ao carregar números: " + e.getMessage());
		}

		Item[] vetor = new Item[numerosList.size()];
		for (int i = 0; i < numerosList.size(); i++) {
			vetor[i] = numerosList.get(i);
		}

		return vetor;
	}

}