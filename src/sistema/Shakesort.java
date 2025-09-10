package sistema;

import dados.Item;

public class Shakesort {

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

    public void shakeSort() {
        int esq, dir, i, j;
        Item temp;
        esq = 1;
        dir = this.nElem - 1;
        j = dir;

        do {
            for (i = dir; i >= esq; i--) {
                    this.comparacao++;
                if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
                    temp = this.vetor[i];
                    this.vetor[i] = this.vetor[i - 1];
                    this.vetor[i - 1] = temp;
                    this.movimentacao++;
                    j = i;
                }
            }
            esq = j + 1;
            for (i = esq; i <= dir; i++) {
                this.comparacao++;
                if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
                    temp = this.vetor[i];
                    this.vetor[i] = this.vetor[i - 1];
                    this.vetor[i - 1] = temp;
                    this.movimentacao++;
                    j = i;
                }
            }
            dir = j - 1;
        } while (esq <= dir);
    }
}
