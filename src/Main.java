public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);

        System.out.println("Prefix notation: ");
        String expression = "2 + 3 * 4 + 6 - 9 / 3";

        Integer result = interpreter.interpret(expression);
        System.out.println("\n\nResult: \n" + result);
    }
}