package Yuckmok;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Omoke.DrawBoard_5;
import Omoke.Map_5;
import Omoke.MapSize_5;
import Omoke.MouseEventHandler_5;
import Omoke.OmokeGameMain_5;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.Timer;

import Omoke.MouseEventHandler_5;

public class GUI extends JFrame {
	private Container c;
	MapSize size = new MapSize();
	final Map map = new Map(size);
	final DrawBorad d = new DrawBorad(size,map);
	final MouseEventHandler meh = new MouseEventHandler(map, size, d, this);
	
	
	public GUI(String title) {
		super.setTitle(title);
		c= getContentPane();
		setBounds(200,20,650,720);
		
		setContentPane(d);
		
		/*JButton save = new JButton(new AbstractAction(" save ") {
		@Override
		public void actionPerformed(ActionEvent e){
			meh.saveData();
		}
	});*/
	JButton replay = new JButton(new AbstractAction(" reset ") {
		@Override
		public void actionPerformed(ActionEvent e){
			meh.replay();
		}
	});
	JButton undo = new JButton(new AbstractAction(" <- ") {
		@Override
		public void actionPerformed(ActionEvent e){
			meh.undo();
		}
	});
	JButton redo = new JButton(new AbstractAction(" -> ") {
		@Override
		public void actionPerformed(ActionEvent e){
			meh.redo();
		}
	});
	/*d.add(save);
	save.setSize(80, 20);
	save.setLocation(210, 1);
	save.setVisible(true);*/
	d.add(replay);
	replay.setSize(80, 20);
	replay.setLocation(300, 1);
	replay.setVisible(true);
	d.add(redo);
	redo.setSize(80, 20);
	redo.setLocation(460, 1);
	redo.setVisible(true);
	d.add(undo);
	undo.setSize(80, 20);
	undo.setLocation(380, 1);
	undo.setVisible(true);
		
		JButton newgame = new JButton(new AbstractAction("Delete Save") {
			@Override
			public void actionPerformed(ActionEvent e){
				meh.newGame();
			}
		});
		
		JButton load = new JButton(new AbstractAction("Load") {
			@Override
			public void actionPerformed(ActionEvent e){
				meh.loadData();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Time Left:"); // done by Nigel, details for timer GUI
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setBounds(32, 11, 80, 14);
        d.add(lblNewLabel);

       
        JLabel timeLeft1;
		
        d.add(newgame);
		newgame.setSize(100, 50);
		newgame.setLocation(20, 616);
		newgame.setVisible(true);
		
		d.add(load);
		load.setSize(100, 50);
		load.setLocation(140, 616);
		load.setVisible(true);
		
		addMouseListener(meh);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message,"",JOptionPane.INFORMATION_MESSAGE);
		new YuckmokGameMain();
		//System.exit(0);
	}
}
