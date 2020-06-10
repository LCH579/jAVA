package Yuckmok;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Omoke.DrawBoard_5;
import Omoke.GUI_5;
import Omoke.MapSize_5;
import Omoke.Map_5;


public class MouseEventHandler extends MouseAdapter{
	
	JLabel timeLeft1 = new JLabel();
	JLabel turn_color = new JLabel();
	Timer t;
	Timer timer1;
	boolean end;
	private Map map;
	private MapSize ms;
	private DrawBorad d;
	private GUI main;
	public static int count_click=0;
	public int count=0;
	public int curcount = 0;
	public int[][] position = new int [400][2];
	public boolean check = false;
	public boolean check_turn = false;
	
	public MouseEventHandler(Map m, MapSize ms, DrawBorad d2 , Yuckmok.GUI main) {
		map = m;
		this.ms = ms;
		this.d = d2;
		this.main = main;
		stat();
	}


	/*public void saveData(){
	newGame();
	String workingDir = System.getProperty("user.dir")+"\\LoadGame.txt";
	File f = new File(workingDir);
	FileWriter myWriter = null;
	for(int i = 0 ; i < count ; i++) {
	try {
		
		myWriter = new FileWriter(f,true);
		BufferedWriter writer = new BufferedWriter(myWriter);
		writer.append(position[i][0] + " " +  position[i][1] + "\n");
		writer.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	}*/

	public void newGame(){
		String workingDir = System.getProperty("user.dir")+"\\LoadGame.txt";
		try {
			PrintWriter writer = new PrintWriter(workingDir);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void saveData(int x, int y){
		String workingDir = System.getProperty("user.dir")+"\\LoadGame.txt";
		File f = new File(workingDir);
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter(f,true);
			BufferedWriter writer = new BufferedWriter(myWriter);
			writer.append(x + " " +  y + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadData(){
		count_click = 0;
		count = 0;
		if(map.getCheck() == false)
			map.changeCheck();
		BufferedReader reader;
		try {

			reader = new BufferedReader(new FileReader("LoadGame.txt"));
			String line;

			while((line = reader.readLine()) != null){
				String[] splitted = line.split(" ");
				int x = 0;
				int y = 1;
				position[count][0] = Integer.parseInt(splitted[x]);
				position[count][1] = Integer.parseInt(splitted[y]);
				count++;
				map.setMap(Integer.parseInt(splitted[y]),Integer.parseInt(splitted[x]));
				count_click++;
				map.changeCheck();
				d.repaint();
				x += 1;
				y += 1;

			}
			curcount = count;
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void undo() {
		if(count<1) {
			System.out.println("count = 0");
			return ;
		}
		count--;
		count_click--;
		map.changeCheck();
		map.deletestone(position[count][0], position[count][1]);
		d.repaint();
		
	}
	public void redo() {
		if(count > curcount-1) {
			System.out.println("full");
			return ;
		}
		
		map.setMap(position[count][1], position[count][0]);
		map.changeCheck();
		count++;
		count_click++;		
		d.repaint();
	}
	public void replay() {
		while(count>0) {
			count--;
			count_click--;
			map.deletestone(position[count][0], position[count][1]);
		}
		d.repaint();
		
		count = 0;
		count_click = 0;
		System.out.println("replay");

	}

	int cc;
	public void mousePressed(MouseEvent arg0) {
		end =false;
		super.mousePressed(arg0);
		int x = (int) Math.round(arg0.getX() / (double) ms.getCell()) -1;
		int y = (int) Math.round(arg0.getY() / (double) ms.getCell()) -2;
		
		System.out.println("Count of Click: " + count_click);
		
		if(x<0 || x>19 || y<0 || y>19) {
			return ;
		}
		
		for(int i = 0 ; i < count ; i++) {
			if(position[i][0]==x && position[i][1]==y)
				return ;
		}
		position[count][0] = x;
		position[count][1] = y;
		count++;
		curcount = count;
		
		System.out.println(x+" "+y);
		count_click ++;
		saveData(x,y);
		map.setMap(y, x);
		map.changeCheck();
		turn(map.getCheck());
		d.repaint();
		
		if(map.winCheck(x, y)) {
			newGame();
			if(map.getCheck()==true) {
				main.showPopUp("White win!");
			}
			else {
				main.showPopUp("Black win!");
				
			}
		}
	}
	public void stat() { // done by Nigel, timer function.
        timeLeft1.setForeground(Color.BLACK);
        timeLeft1.setFont(new Font("Tahoma", Font.BOLD, 14));
        timeLeft1.setBounds(106, 11, 46, 14);
        d.add(timeLeft1);
        t = new Timer(1000, new ActionListener() {

            int time = 60; // timer is set at 60 seconds per turn

            @Override
            public void actionPerformed(ActionEvent e) {

                time--; 

                if (time >= 0) { // if time is not at 0 when action is performed,
                    timeLeft1.setText(Integer.toString(time)); // reset time to 60

                } else { // if not (i.e time is at 0), player loses.

                    JOptionPane.showMessageDialog(d, "Time has run out, player has lost.", "Alert", JOptionPane.WARNING_MESSAGE);
                    System.exit(0);
                }

            }

        }
        );
        t.start();

    }

   public void turn(boolean turn_check) {
	  if(turn_check) {
	   turn_color.setForeground(Color.BLACK); 
	   turn_color.setFont(new Font("Tahoma", Font.BOLD, 25));
	   turn_color.setBounds(360, 616, 150, 50);
       d.add(turn_color);
       turn_color.setText("black turn");
	  }
	  else {
		  turn_color.setForeground(Color.white); 
		  turn_color.setFont(new Font("Tahoma", Font.BOLD, 25));
		  turn_color.setBounds(360, 616, 150, 50);
	      d.add(turn_color);
	      turn_color.setText("white turn");
	  }
   }
      

    public int check()
    {
        return count_click;
    }
    
    public void mouseReleased(MouseEvent me) { // when mouse is released, timer stops and restarts (because player has made a move)

        t.stop();
        stat();
    }

    public void lable(String a) { // details for countdown part of timer

        timeLeft1.setText(a);
        timeLeft1.setForeground(Color.BLACK);
        timeLeft1.setFont(new Font("Tahoma", Font.BOLD, 14));
        timeLeft1.setBounds(106, 11, 46, 14);
        d.add(timeLeft1);
    }


}
