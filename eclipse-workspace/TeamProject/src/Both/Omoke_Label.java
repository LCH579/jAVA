package Both;
//MADE BY CHANHWI

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Omoke_Label extends JFrame 
{
    // 패널 변수
    Panel p;
    // 레이블 변수
    Omoke_Label label1, label2, label3;
    
    // 레이블 생성자
    public Omoke_Label() 
    {        

    	Dimension dim = new Dimension(500,500);
    	JFrame frame = new JFrame("Omoke");
    	frame.setLocation(200,300);
    	frame.setPreferredSize(dim);
    	
    	JLabel label = new JLabel("<html><br><H2>This is Omoke's Rule<br><br><br>using 19 rows of wooden plates, <br>while the stone uses black and white.<br>Black should be placed first and alternately placed from the center of the board.<br>If either black or white is placed horizontally, vertically, or diagonally, in a row of five magnetic stones,Win.<br></html>");

    	frame.add(label);

    	
    	frame.pack();
    	frame.setVisible(true);
    }
}
