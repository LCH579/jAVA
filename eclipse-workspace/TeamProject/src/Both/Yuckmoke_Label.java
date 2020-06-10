package Both;
//MADE BY CHANHWI

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Yuckmoke_Label {
    // 패널 변수
    Panel p;
    // 레이블 변수
    Yuckmoke_Label label1, label2, label3;
    
    // 레이블 생성자
    public Yuckmoke_Label() 
    {        

    	Dimension dim = new Dimension(500,500);
    	JFrame frame = new JFrame("Yuckmoke");
    	frame.setLocation(200,300);
    	frame.setPreferredSize(dim);
    	
    	JLabel label = new JLabel("<html><br><H2>This is Yuckmoke's Rule<br><br><br>Yukmoke is a game invented by Wu Yi-cheng, a professor at National Jiaotong University in Taiwan,<br>by improving Omoke. Black and white alternately place two  stones on each number,<br>while black places only one stone on the first tree.<br>The one who makes more than six stones come in a row in the same color wins.");

    	frame.add(label);

    	
    	frame.pack();
    	frame.setVisible(true);
    }
}
