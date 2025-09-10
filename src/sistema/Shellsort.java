package sistema;

import dados.Item;


public class Shellsort {
    public int comparacao = 0;
    public int movimentacao = 0;

     public int getComparacao(){
        return this.comparacao;
    }

    public int getMovimentacao(){
        return this.movimentacao;
    }
    
    public void shellSort(Item[] vetor) {
        int i, j, h;
        Item temp;
        h = 1;
        do {
            h = 3 * h + 1;
        } while (h < vetor.length);
        do {
            h = h / 3;
            for (i = h; i < vetor.length; i++) {
                temp = vetor[i];
                j = i;
                while (vetor[j - h].getChave() > temp.getChave()) {
                    this.comparacao++;
                    vetor[j] = vetor[j - h];
                    j -= h;
    
                    if (j < h)
                        break;
                }
                this.movimentacao++;
                vetor[j] = temp;
            }
        } while (h != 1);
    }
}
