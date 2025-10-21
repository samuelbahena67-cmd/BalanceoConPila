import java.util.Stack;

public class Main {

    // Metodo para verificar si las llaves están balanceadas
    public static boolean estaBalanceado(String codigo) {
        Stack<Character> pila = new Stack<Character>();

        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);

            // Si encuentra una llave de apertura la mete en la pila
            if (c == '{') {
                pila.push(c);
            }
            // Si encuentra una llave de cierre, intenta sacar una de la pila
            else if (c == '}') {
                if (pila.isEmpty()) {
                    // Hay una llave de cierre sin haber abierto antes
                    return false;
                }
                pila.pop();
            }
        }

        // Si la pila esta vacia, entonces esta balanceado
        return pila.isEmpty();
    }

    public static void main(String[] args) {
        // Código que se va a verificar
        String codigoFuente =
                "public class Main {" +
                        "    public static void main(String[] args) {" +
                        "        System.out.println(\"Hola mundo\");" +
                        "    }" +
                        "}";

        // Verifica si el código esta balanceado
        boolean resultado = estaBalanceado(codigoFuente);

        // Muestra el resultado
        if (resultado) {
            System.out.println("El código está balanceado.");
        } else {
            System.out.println("El código No está balanceado.");
        }
    }
}
