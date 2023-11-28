public class Main {
    public static void main(String[] args) {

        GenericClass<Integer, Cat, String> myClass = new GenericClass<>(9, new Cat(), "K generic");

        System.out.println(myClass.getVar1());
        System.out.println(myClass.getVar2());
        System.out.println(myClass.getVar3());

        myClass.printClassNames();

        Integer[] numbers = {5, 2, 8, 1, 10};
        MinMax<Integer> minMax = new MinMax<>(numbers);

        Integer min = minMax.findMin();
        Integer max = minMax.findMax();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        String[] strings = {"gg", "bb", "ts", "vp", "0", "top", "x"};
        MinMax<String> minMaxS = new MinMax<>(strings);

        String minS = minMaxS.findMin();
        String maxS = minMaxS.findMax();

        System.out.println("Min: " + minS);
        System.out.println("Max: " + maxS);

        double sumResult = Calculator.sum(5, 2.5);
        System.out.println("Sum: " + sumResult);

        double multiplyResult = Calculator.multiply(3, 4.5);
        System.out.println("Multiplication: " + multiplyResult);

        double divideResult = Calculator.divide(10, 2);
        System.out.println("Division: " + divideResult);

        double subtractResult = Calculator.subtract(8, 3.5);
        System.out.println("Subtraction: " + subtractResult);

    }
}