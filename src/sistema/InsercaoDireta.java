package sistema;

import dados.Item;

public class InsercaoDireta {
    public int comparacao = 0;
	public int movimentacao = 0;

    public int getComparacao(){
        return this.comparacao;
    }

    public int getMovimentacao(){
        return this.movimentacao;
    }
    
    public void insercaoDireta(Item[] vetor) {
        int nElem = vetor.length;

        for (int i = 1; i < nElem; i++) {
            Item temp = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getChave() > temp.getChave()) {
                this.comparacao++;
                vetor[j + 1] = vetor[j];
                this.movimentacao++;
                j--;
            }
            vetor[j + 1] = temp;
            this.movimentacao++;
        }
    }
}
