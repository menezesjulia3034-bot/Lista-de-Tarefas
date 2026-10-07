package scr;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Tarefa> tarefas = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU DE TAREFAS ---");
            System.out.println("1 - Adicionar uma tarefa");
            System.out.println("2 - Listar todas as tarefas");
            System.out.println("3 - Editar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Mudar status da tarefa");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    entrada.nextLine(); // consome o Enter que sobrou do nextInt()
                    System.out.print("Informe o título da tarefa: ");
                    String titulo = entrada.nextLine();
                    System.out.print("Informe a descrição da tarefa: ");
                    String descricao = entrada.nextLine();

                    tarefas.add(new Tarefa(titulo, descricao));
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa salva.");
                    } else {
                        for (Tarefa tarefa : tarefas) {
                            System.out.println(tarefa);
                        }
                    }
                    break;

                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas para editar.");
                        break;
                    }
                    System.out.print("Informe o ID da tarefa que deseja editar: ");
                    int idEditar = entrada.nextInt();
                    entrada.nextLine();

                    Tarefa tarefaEditar = null;
                    for (Tarefa t : tarefas) {
                        if (t.getId() == idEditar) {
                            tarefaEditar = t;
                            break;
                        }
                    }

                    if (tarefaEditar != null) {
                        System.out.print("Digite o novo título: ");
                        tarefaEditar.setTitulo(entrada.nextLine());
                        System.out.print("Digite a nova descrição: ");
                        tarefaEditar.setDescricao(entrada.nextLine());
                        System.out.println("Tarefa editada com sucesso!");
                    } else {
                        System.out.println("Tarefa com o ID " + idEditar + " não foi encontrada.");
                    }
                    break;

                case 4:
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas para remover.");
                        break;
                    }
                    System.out.print("Informe o ID da tarefa que deseja remover: ");
                    int idRemover = entrada.nextInt();

                    Tarefa tarefaRemover = null;
                    for (Tarefa t : tarefas) {
                        if (t.getId() == idRemover) {
                            tarefaRemover = t;
                            break;
                        }
                    }

                    if (tarefaRemover != null) {
                        tarefas.remove(tarefaRemover);
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Tarefa com o ID " + idRemover + " não foi encontrada.");
                    }
                    break;

                case 5:
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas para alterar o status.");
                        break;
                    }
                    System.out.print("Informe o ID da tarefa: ");
                    int idStatus = entrada.nextInt();

                    Tarefa tarefaStatus = null;
                    for (Tarefa t : tarefas) {
                        if (t.getId() == idStatus) {
                            tarefaStatus = t;
                            break;
                        }
                    }

                    if (tarefaStatus != null) {
                        System.out.println("\nEscolha o novo status:");
                        System.out.println("1 - PENDENTE");
                        System.out.println("2 - EM ANDAMENTO");
                        System.out.println("3 - CONCLUÍDA");
                        System.out.print("Opção: ");
                        int opcaoStatus = entrada.nextInt();
                        entrada.nextLine();

                        switch (opcaoStatus) {
                            case 1:
                                tarefaStatus.setStatus(Status.PENDENTE);
                                System.out.println("Status atualizado para PENDENTE!");
                                break;
                            case 2:
                                tarefaStatus.setStatus(Status.EM_ANDAMENTO);
                                System.out.println("Status atualizado para EM ANDAMENTO!");
                                break;
                            case 3:
                                tarefaStatus.setStatus(Status.CONCLUIDA);
                                System.out.println("Status atualizado para CONCLUÍDA!");
                                break;
                            default:
                                System.out.println("Opção de status inválida. Nada foi alterado.");
                                break;
                        }
                    } else {
                        System.out.println("Tarefa com o ID " + idStatus + " não foi encontrada.");
                    }
                    break;

                case 6:
                    System.out.println("Sessão encerrada.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 6);

        entrada.close();
    }
}
