/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpatterndemo;

/**
 *
 * @author Tuấn Anh
 */
public class CalculatorCommand extends Command
{
    char operator;
    float operand;
    Calculator calculator;

    public CalculatorCommand(char operator, float operand,
            Calculator calculator)
    {
        this.operator = operator;
        this.operand = operand;
        this.calculator = calculator;
    }

     
    @Override
    public void execute()
    {
        System.out.println(calculator.operation(operator, operand));
    }
    @Override
    public void unExecute()
    {
        System.out.println(calculator.operation(undo(operator),
                operand));
    }
     
    private char undo(char operand)
    {
        switch(operand)
        {
            case '+': return '-';
            case '-': return '+';
            case '*': return '/';
            case '/': return '*';
        }
        return ' ';
    }
}
