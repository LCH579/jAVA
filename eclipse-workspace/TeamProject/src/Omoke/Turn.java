package Omoke;

//SEUNGYU

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Turn extends JPanel {
        JProgressBar p;
        Label status;
        private GUI_5 g;

        public Turn() {
                setLayout(new BorderLayout());
                p = new JProgressBar();
                p.setMinimum(0);
                p.setMaximum(100);
                p.setValue(0);
                status = new Label("");
                add(p,"Center");
                add(status, "South");
        }
        public void go(String turn) {
                try{
                        for(int i=0;i<=100;i++) {
                                p.setValue(i);
                                Thread.sleep(1);
                                status.setText("                ! "+turn+"turn !");
                        } 
                }
                catch (InterruptedException e) {}
        }
        
        
        public Dimension getPreferredSize() {
                return new Dimension(200, 80);
        }
        public static void main(String[] args) {
                
        }
		
}