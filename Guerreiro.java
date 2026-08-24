package Guildatech;

public class Guerreiro extends Personagem {
    private int escudo;

    public Guerreiro(String nome, int nivel, int hpAtual, int hpMaximo, double moedasOuro) {
        super(nome, nivel, hpAtual, hpMaximo, moedasOuro);
        this.escudo = 20;
    }

    public int getEscudo() {
        return this.escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    @Override
    public void executarAtaqueEspecial(Personagem alvo) {
        int danoBase = 10;
        
        // Exemplo de lógica: o Guerreiro usa o escudo para aumentar o dano do ataque
        int danoFinal = danoBase + (this.escudo / 5);

        // Aplica o dano ao alvo
        alvo.setHpAtual(alvo.getHpAtual() - danoFinal);

        // Exibe a mensagem do ataque
        System.out.println(getNome() + " atacou " + alvo.getNome() + " causando " + danoFinal + " de dano (bônus de escudo aplicado)!");
    }
}