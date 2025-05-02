public class Number implements Expression {
    private Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    @Override
    public Integer interpret(Context context) {
        return number;
    }
}
