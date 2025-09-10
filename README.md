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



<img width="580" height="450" alt="Captura de tela 2025-09-10 130744" src="https://github.com/user-attachments/assets/1080e391-d90c-4ae0-884a-9da3987c237c" />

<img width="727" height="110" alt="Captura de tela 2025-09-10 134341" src="https://github.com/user-attachments/assets/94499591-c608-4d16-b9a1-1f79eb348e8d" />


