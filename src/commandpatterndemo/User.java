/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpatterndemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuấn Anh
 */
public class User
{
    Calculator calculator  = new Calculator();
    int current = -1;
    List<Command> listCommands = new ArrayList<>();
     public void compute(char operator, float operand)
     {
         Command command = new CalculatorCommand(operator, operand, calculator);
         command.execute();
         addCommand(command);
     }
     
     private void addCommand(Command command)
     {
         current++;
         for(int i = current; i<listCommands.size();i++)
             listCommands.remove(i);
         listCommands.add(command);
         current = listCommands.size()-1;
     }
     
     public void undo()
     {
         if(current>=0)
         {
             System.out.print("Undo: ");
             listCommands.get(current).unExecute();
             current--;
         }
         else
             System.out.println("Can not perform undo!");
     }
     public void redo()
     {
         if(current<listCommands.size()-1)
         {
             System.out.print("Redo: ");
             current++;
             listCommands.get(current).execute();
         }
         else
            System.out.println("Can not perform redo");
     }
}
