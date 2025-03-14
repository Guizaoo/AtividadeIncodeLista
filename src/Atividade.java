import javax.swing.*;
import java.util.ArrayList;

public class Atividade {
    public static void main(String[] args) {
        ArrayList<String> tarefasConcluidas = new ArrayList<>();
        ArrayList<String> tarefasPendentes = new ArrayList<>();
        boolean sistema = true;

        do {
            String[] opcoes = {
                    "Adicionar Tarefa",
                    "Marcar Tarefa como Concluída",
                    "Listar Tarefas",
                    "Remover Tarefa",
                    "Sair"
            };

            int gerenciador = JOptionPane.showOptionDialog(
                    null,
                    "Selecione a opção desejada:",
                    "Gerenciador de Tarefas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    0);

            switch (gerenciador) {
                case 0:
                    String novaTarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
                    if (novaTarefa != null && !novaTarefa.trim().isEmpty()) {
                        tarefasPendentes.add(novaTarefa);
                        JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
                    }
                    break;

                case 1:
                    if (tarefasPendentes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma tarefa pendente para marcar como concluída.");
                    } else {
                        String tarefaSelecionada = (String) JOptionPane.showInputDialog(
                                null,
                                "Selecione a tarefa concluída:",
                                "Marcar Tarefa como Concluída",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                tarefasPendentes.toArray(),
                                tarefasPendentes.get(0));

                        if (tarefaSelecionada != null) {
                            tarefasPendentes.remove(tarefaSelecionada);
                            tarefasConcluidas.add(tarefaSelecionada);
                            JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!");
                        }
                    }
                    break;

                case 2:
                    String tarefasPendentesStr = "Tarefas Pendentes:\n" + String.join("\n- ", tarefasPendentes);
                    String tarefasConcluidasStr = "Tarefas Concluídas:\n" + String.join("\n- ", tarefasConcluidas);
                    JOptionPane.showMessageDialog(null, tarefasPendentesStr + "\n\n" + tarefasConcluidasStr);
                    break;

                case 3:
                    String input = JOptionPane.showInputDialog("Digite o índice da tarefa que deseja remover:");
                    if (input != null && !input.trim().isEmpty()) {
                        try {
                            int indice = Integer.parseInt(input);
                            if (indice >= 0 && indice < tarefasConcluidas.size()) {
                                tarefasConcluidas.remove(indice);
                                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Índice inválido. Tarefa não removida.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número válido.");
                        }
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    sistema = false;
                    break;
            }
        } while (sistema);
    }
}