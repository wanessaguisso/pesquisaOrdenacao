package sistema;

import java.util.ArrayList;

public class TabelaComparativos {
 
      public static void imprimirTabela(ArrayList<String[]> dados) {
        String formatoLinha = "| %-15s | %-12s | %-15s | %-10s |\n";
        String formatoSeparador = "+-----------------+--------------+-----------------+------------+\n";

        System.out.print(formatoSeparador);
        System.out.printf(formatoLinha, "Algoritmo", "Comparações", "Movimentações", "Tempo (ms)");
        System.out.print(formatoSeparador);

        for (String[] linha : dados) {
            System.out.printf(formatoLinha, linha[0], linha[1], linha[2], linha[3]);
        }

        System.out.print(formatoSeparador);
    }
}
