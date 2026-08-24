package Guildatech;

public class Mago extends Personagem {

    private int mana;

    public Mago(String nome, int nivel, int hpAtual, int hpMaximo, double moedasOuro) {
        super(nome, nivel, hpAtual, hpMaximo, moedasOuro);
        this.mana = 20; // Mana inicial
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void executarAtaqueEspecial(Personagem p) {
        int custoMana = 10;

        if (this.mana >= custoMana) {//definido pra gasta mana quando for faze o ataque
            this.mana -= custoMana;
            int danoMagico = 20;

            // Aplica o dano na vida do alvo
            p.setHpAtual(p.getHpAtual() - danoMagico);

            // Imprime a mensagem da ação
            System.out.println(getNome() + " lançou uma magia em " + p.getNome() + " causando " + danoMagico + " de dano mágico! Mana restante: " + this.mana); // caso o mago tenha mana o suficiente o ataca ira acontecer
        } else {
            System.out.println(getNome() + " tentou atacar, mas não possui mana suficiente! Mana atual: " + this.mana); //caso não o ataca sera cancelado
        }
    }
}
