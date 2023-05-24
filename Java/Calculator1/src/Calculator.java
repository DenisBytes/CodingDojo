public class Calculator implements java.io.Serializable{

    double operandOne;
    double operandTwo;
    String operation;
    double result;
    public Calculator (){}

    public void setOperandOne(double operandOne){
        this.operandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void performOperation(){
        if (operation.equals("+")){
            result = operandOne + operandTwo;
        }
        else if (operation.equals("-")){
            result = operandOne - operandTwo;
        }
    }

    public double getResult() {
        return result;
    }
}
