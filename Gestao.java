package Guildatech;

public class Gestao {

    private String nome;
    private Personagem[] membros;

    public Gestao(String nome, int capacidadeMax) {
        this.nome = nome;
        this.membros = new Personagem[capacidadeMax];
    }

    public String getnome() {
        return this.nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public Personagem[] getmembros() {
        return this.membros;
    }

    public boolean recrutarMembro(Personagem novoMembro) {
        if (novoMembro == null) {
            System.out.println("Membro inválido.");
            return false;
        }

        for (int i = 0; i < this.membros.length; i++) {
            if (this.membros[i] == null) {
                this.membros[i] = novoMembro;
                System.out.println(novoMembro.getNome() + " entrou para a guilda " + this.nome + " no slot " + i);
                return true; // Recrutado com sucesso
            }
        }

        System.out.println("A guilda " + this.nome + " está cheia! Não foi possível recrutar " + novoMembro.getNome());
        return false;
    }

    public void listarMembros() {
        System.out.println("==== Membros da guilda " + this.nome.toUpperCase() + " ====");
        for (int i = 0; i < this.membros.length; i++) {
            if (this.membros[i] != null) {
                System.out.println("Slot " + i + ": " + this.membros[i].getNome() + " - Nível: " + this.membros[i].getNivel());
            }
        }
    }

    public int calcularPoderTotal() {
        int somaNiveis = 0;
        for (int i = 0; i < this.membros.length; i++) {
            if (this.membros[i] != null) {
                somaNiveis += this.membros[i].getNivel();
            }
        }
        return somaNiveis;
    }
}