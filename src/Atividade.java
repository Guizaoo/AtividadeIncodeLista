import java.util.ArrayList;
import java.util.Scanner;

public class Atividade {

    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        ArrayList<String> tarefasConcluidas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Menu de opções
            System.out.println("\n--- Gerenciador de Tarefas ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Marcar Tarefa como Concluída");
            System.out.println("3. Ver Tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // Adicionar tarefa
                    System.out.print("Digite a nova tarefa: ");
                    String novaTarefa = scanner.nextLine();
                    if (!novaTarefa.trim().isEmpty()) {
                        tarefas.add(novaTarefa);
                        System.out.println("Tarefa adicionada!");
                    } else {
                        System.out.println("Tarefa inválida! Nenhuma tarefa foi adicionada.");
                    }
                    break;

                case 2: // Marcar tarefa como concluída
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas pendentes!");
                    } else {
                        System.out.println("Tarefas Pendentes:");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                        System.out.print("Digite o número da tarefa concluída: ");
                        String indiceInput = scanner.nextLine();
                        try {
                            int indice = Integer.parseInt(indiceInput) - 1;
                            if (indice >= 0 && indice < tarefas.size()) {
                                tarefasConcluidas.add(tarefas.remove(indice));
                                System.out.println("Tarefa concluída!");
                            } else {
                                System.out.println("Número inválido!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Digite um número.");
                        }
                    }
                    break;

                case 3: // Ver tarefas
                    System.out.println("\n--- Tarefas Pendentes ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa pendente.");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                    }
                    System.out.println("\n--- Tarefas Concluídas ---");
                    if (tarefasConcluidas.isEmpty()) {
                        System.out.println("Nenhuma tarefa concluída.");
                    } else {
                        for (int i = 0; i < tarefasConcluidas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefasConcluidas.get(i));
                        }
                    }
                    break;

                case 4: // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}