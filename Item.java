package Guildatech;

public class Item { //criado como sera as informações do item pra pode usa em outra classe
	

	private String nome;
	private int peso;
	private int poderCura;

	
	public Item(String nome, int peso, int podeCura) {
		this.nome=nome;
		this.peso=peso;
		this.poderCura=podeCura;

	}
	public String getnome()	{
		return this.nome;
	}
	public int getpeso()	{
		return this.peso;
	}
	public int getpodeCura()	{
		return this.poderCura;
	}
	
}
