import java.util.ArrayList;

public class Calculator implements java.io.Serializable{

    private ArrayList<Double> operands = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private double result;

    public Calculator (){}

    public void performOperation(double operand){
        operands.add(operand);
    }
    public void performOperation(String operator){
        if (!operator.equals("=")){
            operators.add(operator);
        }
    }

    private Double calculate(Double num1, String operator, Double num2){
        switch (operator){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }

    public double getResult() {
        while (operators.contains("*")||operators.contains("/")){
            for (int i = 0; i<operands.size(); i++){
                if(operators.get(i)=="*"||operators.get(i)=="/"){
                    operands.set(i,calculate(operands.get(i),operators.get(i),operands.get(i+1)));
                    operands.remove(i+1);
                    operators.remove(i);
                }
            }
        }
        while (operators.contains("+")||operators.contains("-")){
            for (int i = 0; i<operands.size(); i++){
                operands.set(0,calculate(operands.get(0),operators.get(0),operands.get(1)));
                operands.remove(1);
                operators.remove(0);
            }
        }
        result = operands.get(0);
        return result;
    }
}