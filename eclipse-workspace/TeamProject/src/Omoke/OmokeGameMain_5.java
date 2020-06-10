package Omoke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Omoke.GUI_5;
import Omoke.newWindow;

public class OmokeGameMain_5 extends JFrame {
	
	private static GUI_5 main;
	static String name;
    public OmokeGameMain_5() {
    	setTitle(name+", do you want to quit?");
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
			new GUI_5("Omoke");
			name=JOptionPane.showInputDialog("Enter your Name");
		}








}

class newWindow extends JFrame {
	private Yuckmok.MouseEventHandler MEH;
	
    newWindow() {
    	new GUI_5("exit");
    	String name=JOptionPane.showInputDialog("Enter your Name");
    	MEH.count_click=0;
    }
}