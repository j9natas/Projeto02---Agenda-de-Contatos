package CONTATOS;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OS_CONTATOS03 {

    static class Contato {
        private String nome;
        private String telefone;
        private String email;

        public Contato(String nome, String telefone, String email) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Contato{" +
                    "nome='" + nome + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    public static class AgendaContatos {
        public static void main(String[] args) {
            ArrayList<Contato> contatos = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Adicionar contato");
                System.out.println("2. Mostrar todos os contatos");
                System.out.println("3. Excluir contato");
                System.out.println("4. Pesquisar contato");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao;
                try {
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Opção inválida. Tente novamente.");
                    scanner.next(); 
                    continue;
                }

                scanner.nextLine(); 

                if (opcao == 1) {
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o email do contato: ");
                    String email = scanner.nextLine();

                    Contato contato = new Contato(nome, telefone, email);
                    contatos.add(contato);
                    System.out.println("Contato adicionado com sucesso!");
                } else if (opcao == 2) {
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        System.out.println("Contatos:");
                        for (Contato contato : contatos) {
                            System.out.println(contato);
                        }
                    }
                } else if (opcao == 3) {
                    System.out.print("Digite o nome do contato a ser excluído: ");
                    String nome = scanner.nextLine();
                    boolean encontrado = false;
                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(nome)) {
                            contatos.remove(contato);
                            System.out.println("Contato excluído com sucesso!");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Contato não encontrado.");
                    }
                } else if (opcao == 4) {
                    System.out.print("Digite o nome do contato a ser pesquisado: ");
                    String nome = scanner.nextLine();
                    boolean encontrado = false;
                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(nome)) {
                            System.out.println(contato);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Contato não encontrado.");
                    }
                } else if (opcao == 5) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}	
	
	
	
	
	
	
	
	
	
	
