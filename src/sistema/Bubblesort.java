package sistema;

import dados.Item;

public class Bubblesort {
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

    public void bubblesort(Item[] vetor) {
        this.vetor = vetor;
        this.nElem = vetor.length;
        bubblesort();
    }

    private void bubblesort() {
        int n, i, j;
        Item temp;
        n = this.nElem - 1;
        do {
            i = 0;
            for (j = 0; j < n; j++) {
                this.comparacao++;
                if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
                    temp = this.vetor[j];
                    this.vetor[j] = this.vetor[j + 1];
                    this.vetor[j + 1] = temp;
                    this.movimentacao++;
                    i = j;
                }
            }
            n = i;
        } while (n >= 1);
    }
}