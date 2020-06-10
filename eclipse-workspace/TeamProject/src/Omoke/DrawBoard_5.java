package Omoke;



import java.awt.Color;

import java.awt.Graphics;



import javax.swing.JPanel;





@SuppressWarnings("serial")

public class DrawBoard_5 extends JPanel{

	private MapSize_5 size;

	private Map_5 map;

	private final int STONE_SIZE=28; //占쏙옙 占쏙옙占쏙옙占쏙옙

	public DrawBoard_5(MapSize_5 m,Map_5 map) {

		// TODO Auto-generated constructor stub

		setBackground(new Color(206,167,61)); //占쏙옙占쏙옙 占쏙옙占쏙옙

		size=m;

		setLayout(null);

		this.map=map;

		

	}
	

	public DrawBoard_5() {
		// TODO Auto-generated constructor stub
	}

	@Override

	public void paintComponent(Graphics arg0) {

		// TODO Auto-generated method stub

		super.paintComponent(arg0);

		arg0.setColor(Color.BLACK); //占쌓뤄옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

		board(arg0); //占쏙옙占썲를 占쌓몌옙

		drawStone(arg0); //占썼열占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쌓몌옙

	}

	public void board(Graphics arg0) {

		for(int i=1;i<=size.getSize();i++){

			//占쏙옙占쏙옙 占쏙옙 占쌓몌옙占쏙옙

			arg0.drawLine(size.getCell(), i*size.getCell(), size.getCell()*size.getSize(), i*size.getCell()); //占쏙옙占쏙옙占쏙옙 x : 30, 占쏙옙占쏙옙占쏙옙 y : i占쏙옙 (占쌕뱄옙호)*30, 占쏙옙占쏙옙 x : 600,占쏙옙占쏙옙 y : i占쏙옙 (占쌕뱄옙호)*30

			//占쏙옙占쏙옙占쏙옙 占쌓몌옙占쏙옙

			arg0.drawLine(i*size.getCell(), size.getCell(), i*size.getCell() , size.getCell()*size.getSize()); //占쏙옙占쏙옙占쏙옙 x : i占쏙옙 (占쌕뱄옙호)*30, 占쏙옙占쏙옙占쏙옙 y : 30, 占쏙옙占쏙옙 x : i占쏙옙 (占쌕뱄옙호)*30, 占쏙옙占쏙옙 y : 600

		}

	}

	public void drawStone(Graphics arg0) {

		for(int y=0;y<size.getSize();y++){

			for(int x=0;x<size.getSize();x++){

				//占썼열占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占싹곤옙占� 占썸돌, 占쏙옙占싹곤옙占� 占썽돌占쏙옙 占쌓몌옙

				if(map.getXY(y, x)==map.getBlack())

					drawBlack(arg0,x,y);

				else if(map.getXY(y, x)==map.getWhite())

					drawWhite(arg0, x, y);

			}

		}

	}
	
	

	

	public void drawBlack(Graphics arg0,int x,int y){

		//占쌓뤄옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쌕뀐옙

		arg0.setColor(Color.BLACK);

		arg0.fillOval((x+1)*size.getCell()-15, (y)*size.getCell()+15, STONE_SIZE, STONE_SIZE);



	}

	public void drawWhite(Graphics arg0,int x,int y){

		//占쌓뤄옙占쏙옙 占쏙옙占쏙옙 화占쏙옙트占쏙옙 占쌕뀐옙

		arg0.setColor(Color.WHITE);

		arg0.fillOval(x*size.getCell()+15, y*size.getCell()+15, STONE_SIZE, STONE_SIZE);

		

	}

}
