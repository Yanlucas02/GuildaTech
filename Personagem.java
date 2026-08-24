package Guildatech;

public class Personagem {
    private String nome;
    private int nivel;
    private int hpAtual;
    private int hpMaximo;
    private double moedasOuro;

    public Personagem(String nome, int nivel, int hpAtual, int hpMaximo, double moedasOuro) {
        this.nome = nome;
        this.nivel = nivel;
        this.hpAtual = hpAtual;
        this.hpMaximo = hpMaximo;
        this.moedasOuro = moedasOuro;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getHpAtual() {
        return this.hpAtual;
    }

    public int getHpMaximo() {
        return this.hpMaximo;
    }

    public double getMoedasOuro() {
        return this.moedasOuro;
    }

    public void setHpAtual(int valor) {
        if (valor <= 0) {
            this.hpAtual = 0;
            System.out.println(this.nome + " foi derrotado em combate!");
        } else if (valor > this.hpMaximo) {
            this.hpAtual = this.hpMaximo;
        } else {
            this.hpAtual = valor;
        }
    }

    public void executarAtaqueEspecial(Personagem alvo) {
        int danoBase = 10;
        
       
        alvo.setHpAtual(alvo.getHpAtual() - danoBase);
        
       
        System.out.println(this.nome + " executou um ataque especial em " + alvo.getNome() + " e causou " + danoBase + " de dano!");
    }
}