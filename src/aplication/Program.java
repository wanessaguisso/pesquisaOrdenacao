package aplication;

import dados.Item;
import exceptions.DomainException;
import exceptions.ValidationUtils;
import java.util.ArrayList;
import java.util.Scanner;
import sistema.Bubblesort;
import sistema.ControleArquivos;
import sistema.HeapSort;
import sistema.InsercaoDireta;
import sistema.SelecaoDireta;
import sistema.Shellsort;
import sistema.Shakesort;
import sistema.TabelaComparativos;

public class Program {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<String[]> dados = new ArrayList<>();

	public static void main(String[] args) {
		int op;
		ControleArquivos controleArq = new ControleArquivos();

		do {
			menu();
			op = lerInt("Escolha uma opção: ");
			sc.nextLine();

			switch (op) {
				case 1:
					gerarGravar(controleArq);
					break;

				case 2:
					lerEimprimir(controleArq);
					break;

				case 3:
					ordenarArquivo(controleArq);
					break;

				case 4:
					imprimirTabela();
					break;
				case 5:
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
			}

		} while (op != 5);

		System.out.println("Programa encerrado.");
	}

	// ----------------------------------------------------------- OPERAÇÕES COM
	// ARQUIVOS
	// ---------------------------------------------------------------------
	public static void gerarGravar(ControleArquivos controleArq) {
		int num;

		num = lerInt("Digite quantos números deseja gerar aleatoriamente:");
		sc.nextLine();

		String nome = lerString("Digite o nome do arquivo que deseja salvar: ");

		System.out.println(
				"\033[38;2;255;181;192m----------------------------- Tipos de Arquivo ----------------------------");
		System.out.println("Digite qual arquivo você quer criar: \n" +
				"1. Arquivo com números aleatórios desordenados\n" +
				"2. Arquivo com números ordenados crescente\n" +
				"3. Arquivo com números ordenados decrescente\033[0m");

		int opcao = lerInt("Opção: ");

		switch (opcao) {
			case 1:
				controleArq.escreverArquivo(nome, controleArq.gerarNumerosAleatorios(nome, num));
				break;
			case 2:
				controleArq.escreverArquivo(nome, controleArq.gerarNumerosCrescentes(nome, num));
				break;
			case 3:
				controleArq.escreverArquivo(nome, controleArq.gerarNumerosDecrescentes(nome, num));
				break;
			default:
				System.out.println("Invadido");
		}
		controleArq.criar(nome);
	}

	public static void lerEimprimir(ControleArquivos controleArq) {
		String nome = lerString("Digite o nome do arquivo que deseja ler: ");
		Item[] vetor;

		if (!verificarNomeArq(nome)) {
			return;
		}

		vetor = controleArq.lerArquivo(nome);

		for (Item n : vetor) {
			System.out.print(n.getChave() + "  ");
		}
		System.out.println();
	}

	public static void ordenarArquivo(ControleArquivos controleArq) {
		menuOrdenacao();
		int alg = lerInt("Opção: ");
		String nome = lerString("Digite o nome do arquivo que deseja ordenar: ");

		sc.nextLine();

		switch (alg) {
			case 1:
				algoritimoSelecao(controleArq, nome);
				break;

			case 2:
				algoritimoHeapSort(controleArq, nome);
				break;

			case 3:
				algoritimoInsercaoDireta(controleArq, nome);
				break;

			case 4:
				algoritimoShellsort(controleArq, nome);
				break;

			case 5:
				algoritimoBubblesort(controleArq, nome);
				break;

			case 6:
				algoritimoShakesort(controleArq, nome);
				break;

			case 7:
				System.out.println("QuickSort ainda não implementado.");
				break;

			default:
				System.out.println("Opção inválida!");
		}
	}

	// -------------------------------------------------------------------
	// ALGORITIMOS
	// ------------------------------------------------------------------------
	public static void algoritimoSelecao(ControleArquivos controleArq, String nome) {
		if (!verificarNomeArq(nome)) {
			return;
		}

		SelecaoDireta sd = new SelecaoDireta();
		Item[] numeros = controleArq.lerArquivo(nome);

		long inicio = System.nanoTime();
		sd.selecaoDireta(numeros);
		long fim = System.nanoTime();

		System.out.println("Vetor ordenado:");
		for (Item numero : numeros) {
			System.out.println(numero.getChave());
		}

		System.out.println("Número de Comparações: " + sd.getComparacao());
		System.out.println("Número de Movimentações: " + sd.getMovimentacao());

		double duracao = (fim - inicio) / 1_000_000.0;
		System.out.println("Tempo de execução da Seleção Direta: " + duracao + " ms");

		adicionarNaTabela("Seleção Direta", sd.getComparacao(), sd.getMovimentacao(), duracao);

	}

	public static void algoritimoHeapSort(ControleArquivos controleArq, String nome) {
		if (!verificarNomeArq(nome)) {
			return;
		}

		Item[] numeros = controleArq.lerArquivo(nome);
		HeapSort hp = new HeapSort();

		long inicio = System.nanoTime();
		hp.heapSort(numeros);
		long fim = System.nanoTime();

		System.out.println("Numero de movimentações: " + hp.getMovimentacao());
		System.out.println("Numero de comparações: " + hp.getComparacao());

		System.out.println("\nVetor ordenado: ");
		for (Item n : numeros) {
			System.out.println(n.getChave());
		}

		double duracao = (fim - inicio) / 1_000_000.0;
		System.out.println("Tempo de execução do HeapSort: " + duracao + " ms");

		adicionarNaTabela("HeapSort", hp.getComparacao(), hp.getMovimentacao(), duracao);
	}

	public static void algoritimoInsercaoDireta(ControleArquivos controleArq, String nome) {
		if (!verificarNomeArq(nome)) {
			return;
		}

		InsercaoDireta id = new InsercaoDireta();
		Item[] nums = controleArq.lerArquivo(nome);

		long start = System.nanoTime();
		id.insercaoDireta(nums);
		long end = System.nanoTime();

		System.out.println("Vetor ordenado (Inserção Direta):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		System.out.println("Número de Comparações: " + id.getComparacao());
		System.out.println("Número de Movimentações: " + id.getMovimentacao());

		double duracao = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução da Inserção Direta: " + duracao + " ms");

		adicionarNaTabela("Inserção Direta", id.getComparacao(), id.getMovimentacao(), duracao);
	}

	public static void algoritimoShellsort(ControleArquivos controleArq, String nome) {
		if (!verificarNomeArq(nome)) {
			return;
		}

		Shellsort shell = new Shellsort();
		Item[] nums = controleArq.lerArquivo(nome);

		long start = System.nanoTime();
		shell.shellSort(nums);
		long end = System.nanoTime();

		System.out.println("Vetor ordenado (Shellsort):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		System.out.println("Número de Comparações: " + shell.getComparacao());
		System.out.println("Número de Movimentações: " + shell.getMovimentacao());

		double duracao = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução do Shellsort: " + duracao + " ms");

		adicionarNaTabela("ShellSort", shell.getComparacao(), shell.getMovimentacao(), duracao);
	}

	public static void algoritimoBubblesort(ControleArquivos controleArq, String nome) {
		if (!verificarNomeArq(nome)) {
			return;
		}

		Bubblesort bubb = new Bubblesort();
		Item[] nums = controleArq.lerArquivo(nome);

		long start = System.nanoTime();
		bubb.bubblesort(nums);
		long end = System.nanoTime();

		// adicionar numero de movimentações e comparativos
		System.out.println("Vetor ordenado (Bubblesort):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		System.out.println("Número de Comparações: " + bubb.getComparacao());
		System.out.println("Número de Movimentações: " + bubb.getMovimentacao());

		double duration = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução do Bubblesort: " + duration + " ms");

		adicionarNaTabela("Bubblesort", bubb.getComparacao(), bubb.getMovimentacao(), duration);
	}

	public static void algoritimoShakesort(ControleArquivos controleArq, String nome) {
		if (!verificarNomeArq(nome)) {
			return;
		}

		Shakesort shak = new Shakesort();
		Item[] nums = controleArq.lerArquivo(nome);

		shak.vetor = nums;
		shak.nElem = nums.length;

		long start = System.nanoTime();
		shak.shakeSort();
		long end = System.nanoTime();

		System.out.println("Vetor ordenado (Shakesort):");
		for (Item n : nums) {
			System.out.println(n.getChave());
		}

		System.out.println("Número de Comparações: " + shak.getComparacao());
		System.out.println("Número de Movimentações: " + shak.getMovimentacao());

		double duracao = (end - start) / 1_000_000.0;
		System.out.println("Tempo de execução do Shakesort: " + duracao + " ms");

		adicionarNaTabela("Shakesort", shak.getComparacao(), shak.getMovimentacao(), duracao);
	}

	// -------------------------------------------------------------------- TABELA
	// TESTE
	// ------------------------------------------------------------------------

	public static void imprimirTabela() {
		TabelaComparativos.imprimirTabela(dados);
	}

	public static void adicionarNaTabela(String algoritmo, int comp, int mov, double duration) {
		dados.add(new String[] {
				algoritmo,
				String.valueOf(comp),
				String.valueOf(mov),
				String.format("%.3f", duration)
		});
	}

	// ----------------------------------------------------------------- UTILITÁRIOS
	// ---------------------------------------------------------------------------
	public static void menuOrdenacao() {
		String amarelo = "\u001B[33m";
		String reset = "\u001B[0m";
		System.out.println("\n" + amarelo + "========== Escolha o algoritmo de Ordenação =========="
				+ "\n1. Seleção Direta"
				+ "\n2. HeapSort"
				+ "\n3. Inserção Direta"
				+ "\n4. ShellSort"
				+ "\n5. BubbleSort"
				+ "\n6. ShakeSort"
				+ "\n7. QuickSort");
		System.out.println("======================================================" + reset);
	}

	public static void menu() {
		System.out.println("\n========== MENU PRINCIPAL =========="
				+ "\n1. Gerar e Gravar Arquivo com Números Aleatórios"
				+ "\n2. Ler e Exibir Conteúdo de um Arquivo"
				+ "\n3. Ordenar Arquivo"
				+ "\n4. Imprimir Tabela"
				+ "\n5. Sair");
		System.out.println("==================================");
	}

	public static boolean verificarNomeArq(String nome) {
		try { // metodo para verificar se o nome do arquivo está correto
			ValidationUtils.validarArquivo(nome);
		} catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
			return false;// se o nome estiver errado o algoritmo não continua, pq irá dar erro por n ter
			// encontrado o arquivo
		}
		return true;
	}

	public static String lerString(String mensagem) {
		System.out.println(mensagem);
		return sc.next();
	}

	public static int lerInt(String mensagem) {
		System.out.println(mensagem);
		return sc.nextInt();
	}

}
