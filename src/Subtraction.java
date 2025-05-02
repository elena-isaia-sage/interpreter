public class Subtraction implements Expression {
    Expression left;
    Expression right;

    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}
