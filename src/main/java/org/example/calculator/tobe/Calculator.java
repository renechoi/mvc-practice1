package org.example.calculator.tobe;



import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = List.of(
            new AdditionOperator(),
            new SubtractionOperator(),
            new DivisionOperator());

    public static int calculate(PositiveNumber num1, String operator, PositiveNumber num2) {
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(num1, num2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
