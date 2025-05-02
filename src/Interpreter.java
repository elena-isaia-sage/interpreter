public class Interpreter {
    private final Context context;

    public Interpreter(Context context) {
        this.context = context;
    }

    public Integer interpret(String expression) {
        Expression expressionTree = buildExpressionTree(expression);
        return expressionTree.interpret(context);
    }

    private Expression buildExpressionTree(String expression) {
        expression = expression.trim();

        Integer plusPos = expression.lastIndexOf('+');
        Integer minusPos = expression.lastIndexOf('-');
        if (plusPos != -1 || minusPos != -1) {
            if (plusPos > minusPos) {
                System.out.print('+');
                return new Addition(buildExpressionTree(expression.substring(0, plusPos)),
                        buildExpressionTree(expression.substring(plusPos + 1)));
            }
            System.out.print('-');
            return new Subtraction(buildExpressionTree(expression.substring(0, minusPos)),
                        buildExpressionTree(expression.substring(minusPos + 1)));
        }

        Integer multiplyPos = expression.lastIndexOf('*');
        Integer dividePos = expression.lastIndexOf('/');
        if (multiplyPos != -1 || dividePos != -1) {
            if (multiplyPos > dividePos) {
                System.out.print('*');
                return new Multiplication(buildExpressionTree(expression.substring(0, multiplyPos)),
                        buildExpressionTree(expression.substring(multiplyPos + 1)));
            }
            System.out.print("/");
            return new Division(buildExpressionTree(expression.substring(0, dividePos)),
                    buildExpressionTree(expression.substring(dividePos + 1)));
        }

        System.out.print(expression);
        return new Number(Integer.parseInt(expression));
    }
}
