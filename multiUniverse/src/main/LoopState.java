package main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopState extends State{
	//Math
		int [] floor = {0,500,500,500};
		final double Logic_Hertz = 60;
		final double Target_Time_Between_Logic=(1000000000/Logic_Hertz);
		final double Render_Hertz = 60;
		final double Target_Time_Between_Render = (1000000000/Render_Hertz);
		double lastLogicTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();
		boolean running = true;
		double Interpolation = 0;
	//End
		
		public static void main(String[] args) {
			
			//Making the Panel and adding the frame
				JFrame myFrame= new JFrame();
				myFrame.setSize(500,500);
				myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				myFrame.setVisible(true);
				myFrame.setLocationRelativeTo(null);
				LoopState myDeck = new LoopState();
				myFrame.add(myDeck);
					//no panel to add yet
				//myFrame.add(myDeck);
				//myFrame.addKeyListener(myDeck); change this if we are adding buttons
				myDeck.enterGameLoop();
			
			//end
		}
		
		public void enterGameLoop(){
			while(running){
				lastLogicTime = System.nanoTime();
				logicFunction();
				while((System.nanoTime()-lastLogicTime)<Target_Time_Between_Logic){
					System.out.println("Enter Render Function, Rend-her");
					lastRenderTime = System.nanoTime();
					Interpolation = ((System.nanoTime() - lastLogicTime)/Target_Time_Between_Logic);
					renderFunction(Interpolation);
					while((System.nanoTime()-lastRenderTime)<Target_Time_Between_Render){
						Thread.yield();
					}
				}
			}
		}
		
		public void renderFunction(double Interpolation){
			
		}
		
		public void logicFunction(){
			
		}
		
		public void paint (Graphics g){
			//add when we have a super class
			//Graphics
				//super.paint(g);
				Graphics2D g2d = (Graphics2D)g;
				RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setRenderingHints(rh);
				//g2d.draw(floor);
			//end
		}
}
