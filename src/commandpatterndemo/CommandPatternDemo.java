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
public class CommandPatternDemo
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        User user  = new User();
        user.compute('+', 5);
        user.compute('-', 1);
        user.compute('*', 4);
        user.compute('/', 2);
        
        user.undo();
        user.undo();
        user.redo();
        user.compute('+', 3);
        user.redo();
    }
    
}
