package dados;

public class Item {
	private int chave;
	
	public Item(int ch) {
		this.chave = ch;
	}
	//Modifica o valor do atributo chave
	public void setChave (int ch){
		this.chave = ch;
	}
	//Faz a leitura do valor do atributo chave
	public int getChave (){
		return this.chave;
	}

}
