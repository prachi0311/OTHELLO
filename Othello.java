package game;

import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import UI.blockexception;



public class Othello  extends JFrame implements ActionListener ,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel[] row = new JPanel[9];
	JButton[] button = new JButton[64];
	JButton newgame=new JButton();
	JButton white=new JButton();
	JButton black=new JButton();
	Dimension displayDimension = new Dimension(50,50);
	Dimension displaytext=new Dimension(300,35);
	boolean player1turn;
	boolean player2turn;
	JTextArea display = new JTextArea(2,10);
	Font font = new Font("Times new Roman", Font.BOLD, 14);
	Othello() {
		setDesign();
		setSize(550,550);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(9,9);
		setLayout(grid);
		player1turn=true;
		player2turn=false;
		display.setText("white's turn");
		FlowLayout f2 = new FlowLayout(FlowLayout.CENTER);
		FlowLayout f3=new FlowLayout(FlowLayout.RIGHT);
		for(int i = 0; i <9; i++)
			row[i] = new JPanel();
		for(int i = 0; i <9; i++)
			row[i].setLayout(f2);


		for(int i = 0; i <64; i++) {
			button[i] = new JButton();
			button[i].setBackground(Color.GREEN.darker().darker().darker());
			button[i].addActionListener(this);
		
		}
		for(int i = 0; i <64; i++){
			button[i].setPreferredSize(displayDimension);
		}
		display.setFont(font);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		display.setPreferredSize(displaytext);
		row[0].add(white);
		white.setBackground(Color.white);
		white.setForeground(Color.red);
		white.setText("0");
		white.addMouseListener(new MouseAdapter() {
		});
	//	white.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	//	white.addActionListener(this);
		row[0].add(black);
		black.setBackground(Color.black);
		black.setText("0");
		black.addMouseListener(new MouseAdapter() {
		});
	//	black.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	//	black.addActionListener(this);
		row[0].add(display);
		add(row[0]);
		for(int i = 0; i < 8; i++)
			row[1].add(button[i]);
		add(row[1]);
		newgame=new JButton();
		row[0].add(newgame);
		newgame.setText("new game");
		newgame.addActionListener(this);
		newgame.setLayout(f3);
		for(int i = 8; i < 16; i++)
			row[2].add(button[i]);
		add(row[2]);
		for(int i = 16; i < 24; i++)
			row[3].add(button[i]);
		add(row[3]);
		for(int i = 24; i < 32; i++)
			row[4].add(button[i]);
		add(row[4]);
		for(int i = 32; i < 40; i++)
			row[5].add(button[i]);
		add(row[5]);
		for(int i = 40; i < 48; i++)
			row[6].add(button[i]);
		add(row[6]);
		for(int i = 48; i <56; i++)
			row[7].add(button[i]);
		add(row[7]);
		for(int i = 56; i <64; i++)
			row[8].add(button[i]);
		add(row[8]);
		button[27].setBackground(Color.white);
		button[28].setBackground(Color.black);
		button[35].setBackground(Color.black);
		button[36].setBackground(Color.white);

		setVisible(true);

	}
	public boolean upper(int i){
		int flag=0;
		boolean upper=false;
		if(player1turn){
			for(int j=i-8;j>=0;j=j-8){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.white) && flag==0){
					upper=true;
					break;
				}
			}
		}
		else if(player2turn==true){
			for(int j=i-8;j>=0;j=j-8){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.black) && flag==0){
					upper=true;
					break;
				}
			}

		}
		return upper;

	}
	public boolean rightupperdiag(int i){
		int flag=0;
		boolean rightupperdiag=false;
		if(player1turn==true){
			for(int j=i-7;j>=0;j=j-7){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.white)&& flag==0){
					rightupperdiag=true;
					break;
				}
			}
		}
		else if(player2turn==true){
			for(int j=i-7;j>=0;j=j-7){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.black)&& flag==0){
					rightupperdiag=true;
					break;
				}
			}

		}
		return rightupperdiag;

	}
	public boolean leftupperdiag(int i){
		int flag=0;
		boolean leftupperdiag=false;
		if(player1turn==true ){
			for(int j=i-9;j>=0;j=j-9){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.white) && flag==0){
					leftupperdiag=true;
					break;
				}
			}
		}
		else if(player2turn==true ){
			for(int j=i-9;j>=0;j=j-9){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.black) && flag==0){
					leftupperdiag=true;
					break;
				}
			}

		}
		return leftupperdiag;

	}
	public boolean lower(int i){
		int flag=0;
		boolean lower=false;
		if(player1turn==true){
			for(int j=i+8;j<64;j=j+8){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.white) && flag==0){
					lower=true;
					break;
				}
			}
		}
		else if(player2turn==true){
			for(int j=i+8;j<64;j=j+8){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.black)&& flag==0){
					lower=true;
					break;
				}
			}

		}
		return lower;

	}
	public boolean rightlowerdiag(int i){
		int flag=0;
		boolean rightlowerdiag=false;
		if(player1turn==true ){
			for(int j=i+9;j<64;j=j+9){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.white) && flag==0){
					rightlowerdiag=true;
					break;
				}
			}
		}
		else if(player2turn==true ){
			for(int j=i+9;j<64;j=j+9){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.black) && flag==0){
					rightlowerdiag=true;
					break;
				}
			}

		}
		return rightlowerdiag;

	}
	public boolean leftlowerdiag(int i){
		int flag=0;
		boolean leftlowerdiag=false;
		if(player1turn==true){
			for(int j=i+7;j<64;j=j+7){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.white) && flag==0){
					leftlowerdiag=true;
					break;
				}
			}
		}
		else if(player2turn==true ){
			for(int j=i+7;j<64;j=j+7){
				if(button[j].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[j].getBackground().equals(Color.black) && flag==0){
					leftlowerdiag=true;
					break;
				}
			}

		}
		return leftlowerdiag;

	}
	public boolean horight(int i){
		int flag=0;
		boolean horight=false;
		int x=i%8;
		int num=i-x+7;
		if(player1turn==true){

			for(int j=0;j<=(num-i);j++){
				if(button[i+1].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[i+1].getBackground().equals(Color.white) && flag==0 ){
					horight=true;
					break;
				}
				i++;
			}
		}
		else{
			for(int j=0;j<=(num-i);j++){
				if(button[i+1].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[i+1].getBackground().equals(Color.black) && flag==0){
					horight=true;
					break;
				}
				i++;
			}

		}
		return horight;

	}
	public boolean horleft(int i){
		int flag=0;
		boolean horleft=false;
		int x=i%8;
		if(player1turn==true){

			for(int j=0;j<x;j++){

				if(button[i-1].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[i-1].getBackground().equals(Color.white) && flag==0 ){
					horleft=true;
					break;
				}
				i--;
			}
		}
		else{
			for(int j=0;j<=x;j++){
				if(button[i-1].getBackground().equals(Color.GREEN.darker().darker().darker())){
					flag++;
				}
				if(button[i-1].getBackground().equals(Color.black) & flag==0){
					horleft=true;
					break;
				}
				i--;
			}

		}
		return horleft;

	}

	public boolean greencheck(int i){
		boolean greencheck=false;
		if(button[i+1].getBackground().equals(Color.GREEN.darker().darker().darker())
				&& button[i-1].getBackground().equals(Color.GREEN.darker().darker().darker())
				&&button[i+8].getBackground().equals(Color.GREEN.darker().darker().darker())
				&&button[i-8].getBackground().equals(Color.GREEN.darker().darker().darker())
				&&button[i+7].getBackground().equals(Color.GREEN.darker().darker().darker())
				&&button[i+9].getBackground().equals(Color.GREEN.darker().darker().darker())
				&&button[i-9].getBackground().equals(Color.GREEN.darker().darker().darker())
				&&button[i-7].getBackground().equals(Color.GREEN.darker().darker().darker())){
			greencheck=true;
		}
		return greencheck;
	}
	public boolean gameover(){
		for(int i=0;i<64;i++){
			if(button[i].getBackground().equals(Color.GREEN.darker().darker().darker())){
				return false;
			}

		}
		return true;
	}
	public int gamestatus(){
		int white=0,black=0;
		for(int k=0;k<64;k++){
			if(button[k].getBackground().equals(Color.white)) {
				white++;
			}
			else{
				black++;
			}
		}
		if(white>black){
			return 1;
		}
		else if(white<black){
			return 2;
		}
		else{
			return 3;
		}
	}
 public int whitecount(){
	 int white=0;
	 for(int i=0;i<64;i++){
		 if(button[i].getBackground().equals(Color.white)){
			 white++;
		 }
	 }
	 return white;
 }
 public int blackcount(){
	 int black=0;
	 for(int i=0;i<64;i++){
		 if(button[i].getBackground().equals(Color.black)){
			 black++;
		 }
	 }
	 return black;
 }
  public void mouseExited(MouseEvent e){
	  if(e.getSource()==button[1]){
		  button[1].setBackground(Color.white);
	  }
  }

	public void actionPerformed(ActionEvent ae) {
		for(int i=0;i<64;i++){
			if(ae.getSource()==button[i]){
				if(player1turn==true){
					try{

						if((upper(i)==false && lower(i)==false && rightupperdiag(i)==false && 
								leftupperdiag(i)==false && rightlowerdiag(i)==false && 
								leftlowerdiag(i)==false && 
								horight(i)==false && horleft(i)==false )  ){
							display.setText("invalid move");
						}
						else{
							button[i].setBackground(Color.white);
							if(upper(i)){
								int j=i-8;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j-8;
								}
							}
							if(lower(i)){
								int j=i+8;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j+8;
								}
							}
							if(rightupperdiag(i)){
								int j=i-7;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j-7;
								}
							}
							if(leftupperdiag(i)){
								int j=i-9;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j-9;
								}

							}
							if(rightlowerdiag(i)){
								int j=i+9;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j+9;
								}
							}
							if(leftlowerdiag(i)){
								int j=i+7;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j+7;
								}
							}
							if(horight(i)){
								int j=i+1;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j+1;
								}
							}
							if(horleft(i)){
								int j=i-1;
								while(button[j].getBackground().equals(Color.black)){
									button[j].setBackground(Color.white);
									j=j-1;
								}
							}


							player1turn=false;
							player2turn=true;
							display.setText("black's turn");
						}
					}
					catch(Exception e){
						//System.out.println(e.getMessage());
					}

				}
				else{
					try{
						if((!upper(i)&& !lower(i)&& !rightupperdiag(i) && !leftupperdiag(i) && !rightlowerdiag(i) && !leftlowerdiag(i)&& !horight(i)&& !horleft(i))  ){
							display.setText("invalid move");
						}
						else{
							button[i].setBackground(Color.black);
							if(upper(i)){
								int j=i-8;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j-8;
								}
							}
							if(lower(i)){
								int j=i+8;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j+8;
								}
							}
							if(rightupperdiag(i)){
								int j=i-7;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j-7;
								}
							}
							if(leftupperdiag(i)){
								int j=i-9;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j-9;
								}

							}
							if(rightlowerdiag(i)){
								int j=i+9;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j+9;
								}
							}
							if(leftlowerdiag(i)){
								int j=i+7;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j+7;
								}
							}
							if(horight(i)){
								int j=i+1;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j+1;
								}
							}
							if(horleft(i)){
								int j=i-1;
								while(button[j].getBackground().equals(Color.white)){
									button[j].setBackground(Color.black);
									j=j-1;
								}
							}

							player1turn=true;
							player2turn=false;
							display.setText("white's turn");
						}

					}
					catch(Exception e){
					}

				}
			}
		}
		white.setText(String.valueOf(whitecount()));
		black.setText(String.valueOf(blackcount()));
		System.out.println(gameover());
		if(gameover()){
			int gamestatus=gamestatus();
			if(gamestatus==1){
				display.setText("player 1 wins");
			}
			else if(gamestatus==2){
				display.setText("player 2 wins");
			}
			else{
				display.setText("it's a draw");
			}
		}
		if(ae.getSource()==newgame){
			for(int i=0;i<64;i++){
				button[i].setBackground(Color.GREEN.darker().darker().darker());
			}
			button[27].setBackground(Color.white);
			button[28].setBackground(Color.black);
			button[35].setBackground(Color.black);
			button[36].setBackground(Color.white);
			player1turn=true;
			player2turn=false;
			display.setText("white's turn");

		}

	}	

	public final void setDesign() {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {   
		}
	}
	public static void main(String[] arguments) {
		Othello c = new Othello();
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button[1]){
			button[1].setBackground(Color.cyan);
		}
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
