import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class exercicio33 {
    
    @Retention(RetentionPolicy.RUNTIME) // Essencial para que a anotação esteja disponível via reflection
    @Target(ElementType.METHOD) // A anotação só pode ser aplicada a métodos
    public @interface Teste {}
    
    public static class ClasseTeste {
        @Teste
        public void testeSoma() {
            System.out.println("Executando testeSoma: SUCESSO");
        }

        public void metodoComum() {
            System.out.println("Este não é um teste.");
        }

        @Teste
        public void testeLogin() {
            System.out.println("Executando testeLogin: SUCESSO");
        }    
    }

    public class ExecutorDeTestes {
        public static void executarTestes(Object obj) throws IllegalAccessException, InvocationTargetException{
            Class objClass = obj.getClass();    
            Method[] objMethods = objClass.getDeclaredMethods();

            for (Method method : objMethods) {
                if(method.isAnnotationPresent(Teste.class)){
                    method.invoke(obj);
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ClasseTeste classeTeste = new ClasseTeste();
        ExecutorDeTestes.executarTestes(classeTeste);
    }
}
