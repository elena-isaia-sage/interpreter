public class Division implements Expression {
    private Expression left;
    private Expression right;

    public Division(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer interpret(Context context) {
        return left.interpret(context) / (right.interpret(context));
    }
}
