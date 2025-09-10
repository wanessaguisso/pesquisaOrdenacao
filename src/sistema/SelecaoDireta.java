package sistema;

import dados.Item;

public class SelecaoDireta {
	public int comparacao = 0;
	public int movimentacao = 0;

	public int getComparacao(){
		return this.comparacao;
	}

	public int getMovimentacao(){
		return this.movimentacao;
	}

	public void selecaoDireta(Item[] vetor) {
		int min;
		Item temp;
		for (int i = 0; i < vetor.length; i++) {
			min = i;
			for (int j = i + 1; j < vetor.length; j++) {
				//comparação
				this.comparacao++;
				if (vetor[j].getChave() < vetor[min].getChave()) {
					min = j;
				}
			}
			temp = vetor[i];
			vetor[i] = vetor[min];
			vetor[min] = temp;
			this.movimentacao++;
		}
	}
}