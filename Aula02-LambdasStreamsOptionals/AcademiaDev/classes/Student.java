package AcademiaDev.classes;

import java.util.HashMap;
import java.util.Map.Entry;

import AcademiaDev.classes.enums.SubscriptionPlan;

public class Student extends User {
    private SubscriptionPlan subscriptionPlan;

    public Student(String name, String email, SubscriptionPlan subscriptionPlan) {
        super(name, email);
        this.subscriptionPlan = subscriptionPlan;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public static void listStudentsBySubscriptionPlan(HashMap<String, Student> studentsList) {
        HashMap<SubscriptionPlan, Long> studentsByPlan = new HashMap<>();
        studentsByPlan.put(SubscriptionPlan.BASIC_PLAN, studentsList.values()
                                                                    .stream()
                                                                    .filter(s -> s.getSubscriptionPlan().equals(SubscriptionPlan.BASIC_PLAN))
                                                                    .count());
        
        studentsByPlan.put(SubscriptionPlan.PREMIUM_PLAN, studentsList.values()
                                                                    .stream()
                                                                    .filter(s -> s.getSubscriptionPlan().equals(SubscriptionPlan.PREMIUM_PLAN))
                                                                    .count());
        for (Entry<SubscriptionPlan, Long> sumByPlan : studentsByPlan.entrySet()) {
            System.out.println("PLANO DE ASSINATURA: " 
                               + sumByPlan.getKey() 
                               + " | QUANTIDADE DE ALUNOS: " 
                               + sumByPlan.getValue()
                               + "\n");
        }
    }
}
