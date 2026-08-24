package Guildatech;

public class Inventario {

    private Item[] itens;
    private int limitePeso;

    public Inventario(int limitePeso) {
        this.itens = new Item[5];
        this.limitePeso = limitePeso;
    }

    public Item[] getitens() {
        return this.itens;
    }

    public int getlimitePeso() {
        return this.limitePeso;
    }

    public int calcularPesoAtual() {
        int pesoAtual = 0;
        for (int i = 0; i < this.itens.length; i++) {
            if (this.itens[i] != null) {
                pesoAtual += this.itens[i].getpeso();
            }
        }
        return pesoAtual;
    }

    public boolean adicionarItem(Item novoItem) {
        if (novoItem == null) {
            System.out.println("Item inválido.");
            return false;
        }

        // Verifica limite de peso
        if (calcularPesoAtual() + novoItem.getpeso() > this.limitePeso) {
            System.out.println("Inventário muito pesado, não foi possível armazenar: " + novoItem.getnome());
            return false;
        }

        // Procura primeiro slot vazio
        for (int i = 0; i < this.itens.length; i++) {
            if (this.itens[i] == null) {
                this.itens[i] = novoItem;
                System.out.println("O item [" + novoItem.getnome() + "] foi armazenado no slot " + i);
                return true;
            }
        }

        System.out.println("Inventário cheio, sem slot disponível para: " + novoItem.getnome());
        return false;
    }

    public void usarPocao(int indice, Personagem p) {
        // Validação do índice
        if (indice < 0 || indice >= this.itens.length) {
            System.out.println("Slot inválido!");
            return; // Interrompe para não gerar erro no array
        }

        Item itemSelecionado = this.itens[indice];
        
        if (itemSelecionado != null) {
            int cura = itemSelecionado.getpodeCura();
            
            // Aplica a cura no personagem
            p.setHpAtual(p.getHpAtual() + cura);
            
            System.out.println(p.getNome() + " consumiu [" + itemSelecionado.getnome() + "] do slot " + indice + " e recuperou " + cura + " pontos de vida.");
            
            // Esvazia o slot após o uso
            this.itens[indice] = null;
        } else {
            System.out.println("O slot " + indice + " está vazio!");
        }
    }
}