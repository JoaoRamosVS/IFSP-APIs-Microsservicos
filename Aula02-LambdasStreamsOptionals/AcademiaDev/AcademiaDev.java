package AcademiaDev;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import AcademiaDev.classes.*;
import AcademiaDev.classes.enums.Status;
import AcademiaDev.classes.enums.SubscriptionPlan;
import AcademiaDev.exceptions.EnrollmentException;
import AcademiaDev.utils.*;

public class AcademiaDev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String emailLogin = "";
        Integer opcaoMenu = 0, opcaoMenuLogado = 0;
        User usuarioLogado = null;

        // Inicialização dos dados
        HashMap<String, User> users = InitialData.getUsers();
        HashMap<String, Course> courses = InitialData.getCourses();
        List<Enrollment> enrollments = new ArrayList<>();
        enrollments = InitialData.getEnrollments();
        List<String> instructorsList = courses.values().stream().filter(c -> c.getStatus().equals(Status.ACTIVE)).map(c -> c.getInstructor()).toList();
        Set<String> instructors = new HashSet<String>();
        for (String string : instructorsList) {
            instructors.add(string);
        }
        Queue<SupportTicket> supportTickets = InitialData.getSupportTickets();

        // ---------------------------

        do {
            System.out.println("===== MENU - ACADEMIA DEV ====");
            System.out.println("= DIGITE UMA DAS OPÇÕES PARA PROSSEGUIR.");
            System.out.println("- 1. Login");
            System.out.println("- 2. Consultar catálogo de cursos");
            System.out.println("- 3. Abrir ticket de suporte");
            System.out.println("- 0. Sair do sistema");
            System.out.print("->: ");
            opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu) {
                case 1:
                    System.out.println("===== LOGIN =====");
                    System.out.print("- Digite o seu e-mail: ");
                    emailLogin = sc.nextLine();
                    
                    if (users.containsKey(emailLogin)) {
                        usuarioLogado = users.get(emailLogin);
                        
                        if (usuarioLogado.getClass() == Admin.class) {

                        }

                        if (usuarioLogado.getClass() == Student.class) {
                            Student alunoLogado = (Student) usuarioLogado;
                            System.out.println("\n\n===== MENU ALUNO - ACADEMIA DEV =====");
                            do {
                                System.out.println("- 1. Matricular-se em curso");
                                System.out.println("- 2. Consultar minhas matrículas");
                                System.out.println("- 3. Atualizar progresso");
                                System.out.println("- 4. Cancelar matrícula");
                                System.out.println("- 0. Deslogar");
                                System.out.print("->: ");
                                opcaoMenuLogado = sc.nextInt();
                                sc.nextLine();      

                                switch (opcaoMenuLogado) {
                                    case 1:
                                        try {
                                            if (alunoLogado.getSubscriptionPlan().equals(SubscriptionPlan.BASIC_PLAN)) {
                                               if (enrollments.stream()
                                                              .filter(e -> e.getStudent().getEmail().equals(alunoLogado.getEmail()))
                                                              .count() >= 3) {
                                                    throw new EnrollmentException("Matrícula proibida: aluno possui plano básico e já tem 3 matrículas.");
                                            }
                                        }
                                        } catch (EnrollmentException e) {
                                            System.out.println(e.getMessage() + "\n");
                                        }
                                        break;
                                
                                    case 2:
                                        
                                        break;
                                
                                    case 3:
                                        
                                        break;
                                
                                    case 4:
                                        
                                        break;
                                
                                    case 0:
                                        System.out.println("Deslogando do sistema...\n");
                                        break;
                                
                                    default:
                                        break;
                                }
                            } while (opcaoMenuLogado != 0);
                        }
                    }
                    else {
                        System.out.println("\nE-mail não está cadastrado na base.\n");
                    }

                    break;
            
                case 2:
                    System.out.println("\n===== CURSOS DISPONÍVEIS =====");
                    for (Course course : courses.values()) {
                        System.out.println("NOME: " + course.getTitle() + " | CARGA HORÁRIA: " + course.getDurationInHours());
                        System.out.println("DESCRIÇÃO: " + course.getDescription());
                        System.out.println("PROFESSOR: " + course.getInstructor());
                        System.out.println("DIFICULDADE: " + course.getDifficultyLevel());
                        System.out.println();
                    }
                    break;
            
                case 3:
                    System.out.println("\n===== ABERTURA DE TICKET =====");
                    System.out.print("Digite o assunto do ticket: ");
                    String tituloTicket = sc.nextLine();
                    System.out.print("Digite a descrição do ticket: ");
                    String mensagemTicket = sc.nextLine();
                    supportTickets.add(new SupportTicket(tituloTicket, mensagemTicket));
                    System.out.println("\nTicket enviado para a equipe de suporte!\n");
                    break;

                case 0:
                    System.out.println("Saindo do sistema...\n");
                    break;
            
                default:
                    System.out.println("Digite uma opção válida!\n");
                    break;
            }
        } while (opcaoMenu != 0);
        
        sc.close();
    }
}
