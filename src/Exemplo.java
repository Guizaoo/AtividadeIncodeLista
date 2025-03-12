import javax.swing.*;
import java.util.ArrayList;

public class Exemplo {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        int opcao;

        do {
            try {
                // Exibe o menu de opções
                String menu = "--- Gerenciador de Tarefas ---\n" +
                        "1. Adicionar Nova Tarefa\n" +
                        "2. Sair\n" +
                        "Escolha uma opção:";
                String input = JOptionPane.showInputDialog(menu);

                // Verifica se o usuário cancelou ou fechou a janela
                if (input == null) {
                    break;
                }

                opcao = Integer.parseInt(input); // Converte a entrada para inteiro

                switch (opcao) {
                    case 1:
                        // Adiciona uma nova tarefa
                        String novaTarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
                        if (novaTarefa != null && !novaTarefa.trim().isEmpty()) {
                            tarefas.add(novaTarefa);
                            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tarefa inválida! Nenhuma tarefa foi adicionada.");
                        }
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Saindo do programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número válido.");
                opcao = 0; // Para garantir que o loop continue
            }
        } while (opcao != 2);
    }
}
