public class LambdaIntro {
    public static void main(String[] args) {
        ISum sum = new ISum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        ISum sum1 = (a, b) -> a + b;
    }

    @FunctionalInterface
    public interface ISum {
        public int sum(int a, int b);
    }
}
