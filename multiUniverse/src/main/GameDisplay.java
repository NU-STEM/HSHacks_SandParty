package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameDisplay extends JPanel implements ActionListener{
	
	private JButton btn = new JButton("Play");
	private JButton btn2 = new JButton("Quit");
	private JButton btn3 = new JButton("Credits");
	
	double Interpolation = 0;
	int gameState = 0;
	
	final int MENU = 0;
	final int IN_GAME = 1;
	final int CREDITS = 2;
	final int QUIT = 3;
	
	//game Loop
	double Logic_Hertz = 30;
	double Target_Time_Between_Logic=(1000000000/Logic_Hertz);
	double Render_Hertz = 60;
	double Target_Time_Between_Render = (1000000000/Render_Hertz);
	double lastLogicTime = System.nanoTime();
	double lastRenderTime = System.nanoTime();
	boolean gameRunning = true;
	
		public void startGameLoop(){
			while(gameRunning){
				lastLogicTime = System.nanoTime();
				System.out.println("Enter Logic Function");
				
				logicFunction();
				
				while((System.nanoTime()-lastLogicTime)<Target_Time_Between_Logic){
					System.out.println("Enter Render Function");
					lastRenderTime = System.nanoTime();
					Interpolation = ((System.nanoTime() - lastLogicTime)/Target_Time_Between_Logic);
					renderFunction(Interpolation);

					
					while((System.nanoTime()-lastRenderTime)<Target_Time_Between_Render){
						Thread.yield();
					}
				}
			}
		}
		
		
	//menu Loop
	double MENU_Logic_Hertz = 60;
	double MENU_Target_Time_Between_Logic=(1000000000/MENU_Logic_Hertz);
	double MENU_Render_Hertz = 120;
	double MENU_Target_Time_Between_Render = (1000000000/MENU_Render_Hertz);
	double MENU_lastLogicTime = System.nanoTime();
	double MENU_lastRenderTime = System.nanoTime();
	boolean menuRunning = true;
	
		public void startMenuLoop(){
			renderFunction(Interpolation);
			while(menuRunning){
				MENU_lastLogicTime = System.nanoTime();
				System.out.println("Enter Logic Function");
				
				logicFunction();
				
				while((System.nanoTime()-MENU_lastLogicTime)<MENU_Target_Time_Between_Logic){
					System.out.println("Enter Render Function");
					MENU_lastRenderTime = System.nanoTime();
					Interpolation = ((System.nanoTime() - MENU_lastLogicTime)/MENU_Target_Time_Between_Logic);
					renderFunction(Interpolation);

					
					while((System.nanoTime()-lastRenderTime)<MENU_Target_Time_Between_Render){
						Thread.yield();
					}
				}
			}
		}
		
		
		private void logicFunction() {
			switch(gameState){
				case 0: 
					gameRunning = false;
					this.setIgnoreRepaint(false);
					//menuRunning = true;
					this.setLayout(null);
					renderFunction(Interpolation);
					btn.setFont(new Font("SansSerif", Font.ITALIC, 20));

				    btn.addActionListener(this);
				    btn.setActionCommand("Loop");
				    btn.setBounds(530, 350, 180, 45);
				    
			        btn2.setFont(new Font("SansSerif", Font.ITALIC, 20));
				    
				    btn2.addActionListener(this);
				    btn2.setActionCommand("Quit");
				    btn2.setBounds(530, 400, 180, 45);
				    
			        btn3.setFont(new Font("SansSerif", Font.ITALIC, 20));
				    
				    btn3.addActionListener(this);
				    btn3.setActionCommand("Credits");
				    btn3.setBounds(530, 450, 180, 45);
					
					
				    this.add(btn);
				    this.paintComponents(this.getGraphics());
				    this.add(btn2);
				    this.paintComponents(this.getGraphics());
				    this.add(btn3);
				    this.paintComponents(this.getGraphics());
				    
				    
					break;
				case 1: 
					
					break;
				case 2: 
					
					break;
			}
		}
		private void renderFunction(double Interpolation) {
			this.paintComponents(this.getGraphics());
			//this.repaint();
			
		}
		public void paint(Graphics g){
			super.paint(g);
			Graphics2D g2d = (Graphics2D)g;
			switch(gameState){
				case 0: 
					g2d.setColor(new Color(0.0f,1.0f,1.0f));
					g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
					break;
				case 1: 
					
					break;
				case 2: 
					
					break;
			}
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if("Loop".equals(arg0.getActionCommand())){
				System.out.println("Loop Pressed!");
				gameState = IN_GAME;
			}else if("Quit".equals(arg0.getActionCommand())){
				System.out.println("Quit Pressed!");
				gameState = QUIT;
			}else if ("Credits".equals(arg0.getActionCommand())){
				System.out.println("Credits Pressed!");
				gameState = CREDITS;
			}
			
		}
}
