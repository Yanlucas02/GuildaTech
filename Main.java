package Guildatech;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instancia a guilda com capacidade para 5 membros
        Gestao guilda = new Gestao("Guardiões Tech", 5);
        Inventario inventario = new Inventario(20);

        // Carga inicial no inventário para testes
        inventario.adicionarItem(new Item("Poção de Vida Menor", 2, 30));
        inventario.adicionarItem(new Item("Poção de Vida Maior", 4, 70));

        int opcao = -1;

        do {
            exibirMenuPrincipal();

            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                switch (opcao) {
                    case 1:
                        recrutarHeroiCLI(scanner, guilda);
                        break;

                    case 2:
                        System.out.println("\n--- [MEMBROS ATIVOS DA GUILDA] ---");
                        guilda.listarMembros();
                        break;

                    case 3:
                        simularArenaCLI(scanner, guilda);
                        break;

                    case 4:
                        usarPocaoCLI(scanner, guilda, inventario);
                        break;

                    case 5:
                        System.out.println("\n--- [PODER TOTAL DA GUILDA] ---");
                        int poderTotal = guilda.calcularPoderTotal();
                        System.out.println("Poder total somado dos heróis vivos: " + poderTotal + " pts.");
                        break;

                    case 0:
                        System.out.println("\nEncerrando o sistema GuildaTech Enterprise. Até a próxima jornada!");
                        break;

                    default:
                        System.out.println("\n⚠️ Opção inválida! Escolha um número entre 0 e 5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n⚠️ [ERRO DE ENTRADA]: Você deve digitar um número inteiro válido!");
                scanner.nextLine(); // Limpa o buffer após o erro
                opcao = -1;
            }

            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n==============================================");
        System.out.println("          GUILDATECH - MENU PRINCIPAL         ");
        System.out.println("==============================================");
        System.out.println("1. Recrutar Novo Herói (Mago ou Guerreiro)");
        System.out.println("2. Listar Heróis da Guilda");
        System.out.println("3. Simular Arena de Batalha (Polimorfismo)");
        System.out.println("4. Usar Poção do Inventário");
        System.out.println("5. Exibir Poder Total da Guilda");
        System.out.println("0. Sair do Sistema");
        System.out.println("==============================================");
    }

    private static void recrutarHeroiCLI(Scanner scanner, Gestao guilda) {
        System.out.println("\n--- [RECRUTAMENTO DE HERÓIS] ---");
        System.out.println("1 - Mago");
        System.out.println("2 - Guerreiro");
        System.out.print("Selecione a classe: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do Herói: ");
        String nome = scanner.nextLine();

        System.out.print("Nível inicial: ");
        int nivel = scanner.nextInt();

        System.out.print("HP Máximo: ");
        int hpMax = scanner.nextInt();

        System.out.print("Moedas de Ouro iniciais: ");
        double ouro = scanner.nextDouble();

        if (tipo == 1) {
            scanner.nextLine();
            // Instancia o Mago com o HP inicial igual ao máximo
            Mago novoMago = new Mago(nome, nivel, hpMax, hpMax, ouro);
            guilda.recrutarMembro(novoMago);
        } else if (tipo == 2) {
            scanner.nextLine();
            // Instancia o Guerreiro com o HP inicial igual ao máximo
            Guerreiro novoGuerreiro = new Guerreiro(nome, nivel, hpMax, hpMax, ouro);
            guilda.recrutarMembro(novoGuerreiro);
        } else {
            System.out.println("⚠️ Classe inválida! Recrutamento cancelado.");
        }
    }

    private static void simularArenaCLI(Scanner scanner, Gestao guilda) {
        System.out.println("\n--- [ARENA DE BATALHA (POLIMORFISMO)] ---");
        guilda.listarMembros();

        Personagem[] membros = guilda.getmembros();

        System.out.print("\nDigite o slot do atacante (0 a " + (membros.length - 1) + "): ");
        int idxAtacante = scanner.nextInt();

        System.out.print("Digite o slot do alvo/defensor (0 a " + (membros.length - 1) + "): ");
        int idxAlvo = scanner.nextInt();
        scanner.nextLine();

        if (idxAtacante < 0 || idxAtacante >= membros.length || membros[idxAtacante] == null) {
            System.out.println("⚠️ Atacante inválido ou slot vazio!");
            return;
        }

        if (idxAlvo < 0 || idxAlvo >= membros.length || membros[idxAlvo] == null) {
            System.out.println("⚠️ Alvo inválido ou slot vazio!");
            return;
        }

        Personagem atacante = membros[idxAtacante];
        Personagem alvo = membros[idxAlvo];

        if (atacante.getHpAtual() <= 0) {
            System.out.println("⚠️ " + atacante.getNome() + " está derrotado e não pode combater.");
            return;
        }

        System.out.println("\n⚔️ " + atacante.getNome() + " desfere seu ataque especial em " + alvo.getNome() + "!");
        atacante.executarAtaqueEspecial(alvo);
    }

    private static void usarPocaoCLI(Scanner scanner, Gestao guilda, Inventario inventario) {
        System.out.println("\n--- [USO DE POÇÕES DO INVENTÁRIO] ---");
        
        // Exibe os itens do inventário
        Item[] itens = inventario.getitens();
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] != null) {
                System.out.println("Slot " + i + ": " + itens[i].getnome() + " (Cura: " + itens[i].getpodeCura() + ")");
            } else {
                System.out.println("Slot " + i + ": [Vazio]");
            }
        }

        guilda.listarMembros();
        Personagem[] membros = guilda.getmembros();

        System.out.print("\nInforme o slot do herói que receberá a poção (0 a " + (membros.length - 1) + "): ");
        int idxHeroi = scanner.nextInt();

        System.out.print("Informe o slot da poção no inventário (0 a " + (itens.length - 1) + "): ");
        int slotPocao = scanner.nextInt();
        scanner.nextLine();

        if (idxHeroi >= 0 && idxHeroi < membros.length && membros[idxHeroi] != null) {
            inventario.usarPocao(slotPocao, membros[idxHeroi]);
        } else {
            System.out.println("⚠️ Herói não encontrado no slot informado.");
        }
    }
}