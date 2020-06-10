package Both;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Omoke.*;
import Yuckmok.*;

//MADE BY CHANHWI

public class Main extends JFrame implements ActionListener{
	JButton btn, btn1;
	OmokeGameMain_5 O ;
	YuckmokGameMain y ;
	public Main() {
		super("Select!");
		Button();
        Menu();
        setLocation(200,200);
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
	}

	public void Menu() {
		JMenuBar mb = new JMenuBar();
		JMenu help = new JMenu("help");
		JMenu who = new JMenu("Who made this?");
		
		JMenuItem [] menuItem = new JMenuItem [3];
		JMenuItem menuItem1 = new JMenuItem();
		
		String[] itemTitle = {"How to play Omoke","How to play Yuckmoke","Exit"};
		String itemTitle1 = "Who made this?";
		
		MenuActionListner listener = new MenuActionListner();
		
		menuItem[0] = new JMenuItem(itemTitle[0]);
		menuItem[1] = new JMenuItem(itemTitle[1]);
		menuItem[2] = new JMenuItem(itemTitle[2]);	
		menuItem1 = new JMenuItem(itemTitle1);
		
		menuItem[0].addActionListener(listener);
		menuItem[1].addActionListener(listener);
		menuItem[2].addActionListener(listener);
		
		
		menuItem1.addActionListener(listener);
		
		help.add(menuItem[0]);
		help.add(menuItem[1]);
		help.add(menuItem[2]);
		
		who.addActionListener(listener);	
		
		who.add(menuItem1);

		mb.add(help);
		mb.add(who);

		setJMenuBar(mb);
	}
	


	public void Button() {
		JPanel buttonPanel = new JPanel();

		btn = new JButton("Omoke");
		btn1 = new JButton("Yuckmoke");
		buttonPanel.add(btn);
		buttonPanel.add(btn1);
		
		btn.addActionListener(this);
		btn1.addActionListener(this);
		
        add(buttonPanel);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if((JButton)obj == btn) {
			O.main(null);
		}
		
		else if ((JButton)obj == btn1){
			y.main(null);
		}
				
		}
	
    public static void main(String[] args)
    {
        new Main();        
    }
		
	}

class MenuActionListner implements ActionListener{
	public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();

	switch(cmd) {
	
	case "How to play Omoke" :
		new Omoke_Label();
		break;
	
	case "How to play Yuckmoke" :
		new Yuckmoke_Label();
		break;
	
	case "Who made this?":
		new made_Label();
		break;
	case "Exit" :
		System.exit(0);
		break;

	

		}
	}
}



