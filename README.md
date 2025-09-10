CODIGO ACERTADO --------------------------



package sistema;

import dados.Item;

public class Quicksort {

    public int movimentacao = 0;
    public int comparacao = 0;
    public Item[] vetor;
    public int nElem = 0;

    public int getComparacao() {
        return this.comparacao;
    }

    public int getMovimentacao() {
        return this.movimentacao;
    }

    public void quicksort(Item[] vetor) {
        this.vetor = vetor;
        this.nElem = vetor.length;
        ordena(0, this.nElem - 1);
    }

    private void ordena(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = this.vetor[(i + j) / 2].getChave();
        Item temp;
        do {
            while (this.vetor[i].getChave() < pivo) {
                i++;
                this.comparacao++;
            }
            this.comparacao++;
            while (this.vetor[j].getChave() > pivo) {
                j--;
                this.comparacao++;
            }
            this.comparacao++;
            if (i <= j) {
                temp = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = temp;
                this.movimentacao++;
                i++;
                j--;
            }
        } while (i <= j); 

      
        if (esq < j) {
            ordena(esq, j);
        }
      
        if (i < dir) {
            ordena(i, dir);
        }
    }
}
