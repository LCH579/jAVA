package Yuckmok;
import javax.swing.*;

import Omoke.GUI_5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class YuckmokGameMain extends JFrame {
	private static GUI main;
	static String name;
    public YuckmokGameMain() {
    	setTitle(name + "Do you want to quit?");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel MainContainer = new JPanel(); 

        setContentPane(MainContainer); 
        
        JButton OpenWindow = new JButton("No");
        
        JButton CloseWindow = new JButton("Yes");
        
        OpenWindow.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               
                new newWindow(); 
                dispose(); 
            }
            
        });
        
        CloseWindow.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) { 
            	System.exit(0); 
            }  
            
        });
        
        MainContainer.add(OpenWindow); 
        
        MainContainer.add(CloseWindow);
        setLocation(330,350);
        setSize(400,70); 
        setResizable(false); 
        setVisible(true);
    }
    





	public static void main(String[] args) { 
			new GUI("Yuckmoke");
			name=JOptionPane.showInputDialog("Enter your Name");
		}

}

class newWindow extends JFrame {
	private Yuckmok.MouseEventHandler MEH;
	
    newWindow() {
    	new GUI("exit");
    	String name=JOptionPane.showInputDialog("Enter your Name");
    	MEH.count_click=0;
    }
}

