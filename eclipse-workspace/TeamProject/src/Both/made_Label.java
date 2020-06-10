package Both;
//MADE BY CHANHWI

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class made_Label {
    Panel p;
    // 레이블 변수
    made_Label label1, label2, label3;
    
    // 레이블 생성자
    public made_Label() 
    {        

    	Dimension dim = new Dimension(250,250);
    	JFrame frame = new JFrame("Who made this?");
    	frame.setLocation(100,100);
    	frame.setPreferredSize(dim);
    	
    	JLabel label = new JLabel("<html><br><H2>유이새<br><이찬휘 <br>한승유<br>Nigel<br></html>",JLabel.CENTER);

    	frame.add(label);

    	frame.pack();
    	frame.setVisible(true);
    }
}
