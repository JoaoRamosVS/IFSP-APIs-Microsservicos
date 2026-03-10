package AcademiaDev;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import AcademiaDev.classes.*;
import AcademiaDev.classes.enums.Status;
import AcademiaDev.classes.enums.SubscriptionPlan;
import AcademiaDev.exceptions.CourseException;
import AcademiaDev.exceptions.EnrollmentException;
import AcademiaDev.utils.*;

public class AcademiaDev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String emailLogin = "";
        Integer opcaoMenu = 0, opcaoMenuLogado = 0, opcaoRelatorio = 0;
        User usuarioLogado = null;

        // Inicialização dos dados
        HashMap<String, User> users = InitialData.getUsers();
        HashMap<String, Student> students = InitialData.getStudents();
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
                        
                        // MENU PARA ADMIN
                        if (usuarioLogado.getClass() == Admin.class) {
                            do{
                                System.out.println("\n\n===== MENU ADMIN - ACADEMIA DEV =====");
                                System.out.println("- 1. Gerenciar Status de Cursos");
                                System.out.println("- 2. Gerenciar Planos de Alunos");
                                System.out.println("- 3. Atender Tickets de Suporte");
                                System.out.println("- 4. Gerar Relatórios e Análises");
                                System.out.println("- 5. Exportar Dados em CSV");
                                System.out.println("- 0. Deslogar");
                                System.out.print("->: ");
                                opcaoMenuLogado = sc.nextInt();
                                sc.nextLine();      

                                switch (opcaoMenuLogado){
                                    case 1:
                                        for (Entry<String, Course> course : courses.entrySet()) {
                                            System.out.println("CURSO: " + course.getKey() + " | STATUS: " + course.getValue().getStatus());
                                        }
                                        System.out.print("\nDigite o nome do Curso que deseja alterar o status: ");
                                        String courseInput = sc.nextLine();
                                        try{
                                            Course course = courses.get(courseInput);

                                            if(course == null){
                                                throw new CourseException("\nO curso pesquisado não existe na base de dados.");
                                            }
                                            
                                            System.out.println("CURSO: " + course.getTitle() + " | INSTRUTOR: " + course.getInstructor() + " | STATUS: " + course.getStatus());

                                            if(course.getStatus() == Status.ACTIVE){
                                                System.out.print("\nDeseja inativar este curso? Digite 'SIM' para executar: ");
                                                String inactivationOption = sc.nextLine();
                                                if(inactivationOption.equals("SIM")){
                                                    course.setStatus(Status.INACTIVE);
                                                    System.out.println("CURSO: " + course.getTitle() + " FOI ALTERADO PARA " + course.getStatus());
                                                } else{
                                                    return;
                                                }
                                            }

                                            else if(course.getStatus() == Status.INACTIVE){
                                                System.out.print("\nDeseja ativar este curso? Digite 'SIM' para executar: ");
                                                String inactivationOption = sc.nextLine();
                                                if(inactivationOption.equals("SIM")){
                                                    course.setStatus(Status.ACTIVE);
                                                } else{
                                                    return;
                                                }
                                            }
                                        } catch(CourseException c){
                                            System.out.println(c.getMessage() + "\n");
                                        }

                                        break;

                                    case 2:
                                        for (Entry<String, User> user : users.entrySet()) {
                                            if(user.getValue() instanceof Student){
                                                Student student = (Student) user.getValue();
                                                System.out.println("NOME:" + student.getName() + " | EMAIL: " + student.getEmail() + " | PLANO DE ESTUDO: " + student.getSubscriptionPlan());
                                            }
                                        }    
                                        System.out.print("\nDigite o email do aluno que deseja editar o plano: ");
                                        String studentEmail = sc.nextLine();

                                        if(users.containsKey(studentEmail)){
                                            Student student = (Student) users.get(studentEmail);

                                            System.out.println("\nPLANO DE ESTUDO DO(A) ALUNO(A): " + student.getName() + " | PLANO DE ASSINATURA: " + student.getSubscriptionPlan());

                                            if(student.getSubscriptionPlan().equals(SubscriptionPlan.BASIC_PLAN)){
                                                System.out.print("\nDeseja mudar este plano para o PREMIUM? Digite SIM para executar: ");
                                                String subscriptionOption = sc.nextLine();
                                                if(subscriptionOption.equals("SIM")){
                                                    student.setSubscriptionPlan(SubscriptionPlan.PREMIUM_PLAN);
                                                    System.out.println("\nALUNO: " + student.getName() + " TEVE O PLANO ALTERADO PARA " + student.getSubscriptionPlan());
                                                } else{
                                                    return;
                                                }
                                            }
                                            else if(student.getSubscriptionPlan().equals(SubscriptionPlan.PREMIUM_PLAN)){
                                                System.out.print("\nDeseja mudar este plano para o BASIC? Digite SIM para executar: ");
                                                String subscriptionOption = sc.nextLine();
                                                if(subscriptionOption.equals("SIM")){
                                                    student.setSubscriptionPlan(SubscriptionPlan.BASIC_PLAN);
                                                    System.out.println("\nALUNO: " + student.getName() + " TEVE O PLANO ALTERADO PARA " + student.getSubscriptionPlan());
                                                } else{
                                                    return;
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("\nO e-mail digitado não está presente entre os alunos cadastrados.\n");
                                        }
                                        break;
                                    
                                    case 3:
                                        break;
                                    
                                    case 4:
                                        do {
                                            System.out.print("\n----- RELATÓRIOS E ANÁLISES -----\n");
                                            System.out.println("- 1. Relação de cursos ordenados por dificuldade");
                                            System.out.println("- 2. Relação de instrutores de cursos ativos");
                                            System.out.println("- 3. Relação de alunos por plano de assinatura");
                                            System.out.println("- 4. Média geral de progresso de todas as matrículas");
                                            System.out.println("- 5. Aluno com maior número de matrículas ativas");
                                            System.out.println("- Selecione um dos relatórios.");
                                            System.out.print("\n->: ");
                                            opcaoRelatorio = sc.nextInt();
                                            sc.nextLine();
                                            
                                            switch (opcaoRelatorio) {
                                                case 1:
                                                    System.out.println("");
                                                    Course.ListCoursesOrderByDifficultyLevel(courses);
                                                    opcaoRelatorio = 0;
                                                    break;
                                                case 2:
                                                    System.out.println("");
                                                    Course.listActiveCoursesInstructors(courses);
                                                    opcaoRelatorio = 0;
                                                    break;
                                                case 3:
                                                    System.out.println("");
                                                    Student.listStudentsBySubscriptionPlan(students);
                                                    opcaoRelatorio = 0;
                                                    break;
                                                case 4:
                                                    try {
                                                        Double progressAverage = Enrollment.getStudentsProgressAverage(enrollments);
                                                        System.out.printf("\n- MÉDIA GERAL DE PROGRESSO DE TODAS AS MATRÍCULAS: %.2f\n", progressAverage);
                                                    } catch (EnrollmentException e) {
                                                        System.out.println(e.getMessage() + "\n");
                                                    }   
                                                    opcaoRelatorio = 0;
                                                    break;
                                                case 5:
                                                    try {
                                                        Enrollment.showStudentWithMostEnrollments(enrollments);
                                                    } catch (EnrollmentException e) {
                                                        System.out.println(e.getMessage() + "\n");
                                                    }
                                                    opcaoRelatorio = 0;
                                                    break;
                                            
                                                default:
                                                    break;
                                            }
                                        } while (opcaoRelatorio != 0);
                                        break;

                                }
                            }while (opcaoMenuLogado != 0);
                        }

                        // MENU PARA STUDENT
                        if (usuarioLogado.getClass() == Student.class) {
                            Student alunoLogado = (Student) usuarioLogado;
                            do {
                                System.out.println("\n\n===== MENU ALUNO - ACADEMIA DEV =====");
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
                                            System.out.print("\nDigite o nome do curso que você deseja se matricular: ");
                                            String nomeCurso = sc.nextLine();
                                            Course novoCurso = courses.get(nomeCurso);
                                                
                                            if (novoCurso == null) {
                                                throw new EnrollmentException("Esse curso não existe no catálogo.");
                                            }

                                            if (novoCurso.getStatus().equals(Status.INACTIVE)) {
                                               throw new EnrollmentException("Esse curso está inativo.");
                                            }

                                            if (!enrollments.stream()
                                                            .filter(e -> e.getStudent().getEmail().equals(alunoLogado.getEmail()) 
                                                                    && e.getCourse().getTitle().equals(novoCurso.getTitle()))
                                                            .toList()
                                                            .isEmpty()) {
                                                throw new EnrollmentException("Aluno já possui matrícula neste curso.");
                                            }

                                            enrollments.add(new Enrollment(novoCurso, alunoLogado));
                                            System.out.println("Nova matrícula registrada!");
                                            System.out.println("Curso: " + novoCurso.getTitle());
                                            System.out.println("Aluno: " + alunoLogado.getName());
                                        } catch (EnrollmentException e) {
                                            System.out.println(e.getMessage() + "\n");
                                        }
                                        break;
                                
                                    case 2:
                                        System.out.print("\n----- SUAS MATRÍCULAS -----\n");
                                        List<Enrollment> matriculasAlunoLogado = enrollments.stream()
                                                                                            .filter(e -> e.getStudent().getEmail().equals(alunoLogado.getEmail()))
                                                                                            .toList();
                                        if (matriculasAlunoLogado.isEmpty()) {
                                            System.out.println("O aluno ainda não possui matrículas.");
                                        }
                                        else {
                                            for (Enrollment enrollment : matriculasAlunoLogado) {
                                                System.out.println(enrollment.toString());
                                            }
                                        }
                                        break;
                                
                                    case 3:
                                        System.out.print("\n----- ATUALIZAR PROGRESSO -----\n");                                        
                                        try {
                                            System.out.print("\nDigite o nome do curso que você deseja atualizar o progresso: ");
                                            String cursoParaAtualizar = sc.nextLine();
                                            Optional<Enrollment> matriculaAtualizada = enrollments.stream()
                                                                                        .filter(e -> e.getStudent().getEmail().equals(alunoLogado.getEmail())
                                                                                                && e.getCourse().getTitle().equals(cursoParaAtualizar))
                                                                                        .findFirst();
                                            if (matriculaAtualizada.isEmpty()) {
                                                throw new EnrollmentException("Não foi encontrada nenhuma matrícula para este curso e este aluno.");
                                            }

                                            System.out.print("\nDigite o progresso atual (de 0.0 a 100.0): ");
                                            Double novoProgresso = sc.nextDouble();

                                            if (novoProgresso < 0 || novoProgresso > 100) {
                                                throw new EnrollmentException("O novo progresso deve ser de 0 a 100.");
                                            }

                                            enrollments.stream()
                                                       .filter(e -> e.getStudent().getEmail().equals(alunoLogado.getEmail())
                                                               && e.getCourse().getTitle().equals(cursoParaAtualizar))
                                                       .findFirst()
                                                       .get()
                                                       .updateProgress(novoProgresso);                                            
                                            System.out.println("Progresso atualizado!");
                                        } catch (EnrollmentException e) {
                                            System.out.println(e.getMessage() + "\n");
                                        }
                                        break;
                                
                                    case 4:
                                        System.out.print("\n----- CANCELAR MATRÍCULA -----\n");    
                                        try{
                                            Enrollment.listStudentsEnrollments(enrollments, emailLogin);
                                            System.out.print("\nDigite o nome do curso que deseja cancelar a matrícula: ");
                                            String removedEnrollmentCourse = sc.nextLine();
                                            Enrollment enrollment = enrollments.stream()
                                                                            .filter(e -> e.getStudent().getEmail().equals(alunoLogado.getEmail())
                                                                                    && e.getCourse().getTitle().equals(removedEnrollmentCourse))
                                                                            .findFirst()
                                                                            .orElseThrow(() -> new EnrollmentException("\nO aluno não está cadastrado no curso digitado\n"));
                                        
                                            enrollments.remove(enrollment);
                                            System.out.println("\nMatrícula removida com sucesso!\n");
                                        }catch(EnrollmentException e){
                                            System.out.println(e.getMessage() + "\n");
                                        }


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
                    for (Course course : courses.values().stream()
                                                         .filter(c -> c.getStatus().equals(Status.ACTIVE))
                                                         .toList()) {
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
