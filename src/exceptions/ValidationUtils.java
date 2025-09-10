package exceptions;

import java.io.File;

public class ValidationUtils {
	

	public static void validarStringNaoVazia(String n, String campo) {
		if (n == null || n.trim().isEmpty()) {
			throw new DomainException("O campo " + campo + "não pode ser vazio");
		}
	}
	
	public static void validarArquivo(String nome) { //ele valida o nome do arquivo, vê se existe e se pode ler
	    ValidationUtils.validarStringNaoVazia(nome, "caminho do arquivo");//é usado no lerEimprimir
	     File arquivo = new File(nome);
	    
	    if (!arquivo.exists()) {
	        throw new DomainException("O arquivo " + nome + " não existe.");
	    }
	    
	    if (!arquivo.canRead()) {
	        throw new DomainException("Não é possível ler o arquivo " + nome + ".");
	    }
	}
	
}
