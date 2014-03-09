package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopState extends State{
	//Frames Per Second Math
		//make map
			int [][] level = new int[][]{
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
					};
		//map
		public Rectangle Rectangle = new Rectangle();
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
				JFrame myFrame= new JFrame("multiUniverse");
				myFrame.setSize(500,500);
				myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				myFrame.setVisible(true);
				myFrame.setLocationRelativeTo(null);
				myFrame.setResizable(false);
				LoopState myDeck = new LoopState();
				myFrame.add(myDeck);
				myFrame.add(myDeck);
				//myFrame.addKeyListener(myDeck); change this if we are adding buttons
				myDeck.enterGameLoop();
			//end
		}
		
		public void enterGameLoop(){
			while(running){
				lastLogicTime = System.nanoTime();
				logicFunction();
				while((System.nanoTime()-lastLogicTime)<Target_Time_Between_Logic){
					System.out.println("Its running");
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
				//Graphics
					super.paint(g);
					Graphics2D g2d = (Graphics2D)g;
					RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					g2d.setRenderingHints(rh);
				//end
					
				//Color Listings
					Color LineColor = new Color(0,0,255);
					Color backgroundColor = new Color(0,0,0);
					Color map = new Color(255,255,255);
				//end
					
				//Drawing Background
//					Rectangle2D.Float background = new Rectangle2D.Float(0F, 0F, (float)getSize().width, (float)getSize().height);
//					g2d.setColor(backgroundColor);
//					g2d.fill(background);
				//end	
					
				//Drawing Test Line
//					int[] floor = {0,getSize().height,getSize().width,getSize().height};
//					Line2D.Float ln = new Line2D.Float(floor[0],floor[1],floor[2],floor[3]);
//					int Line = 10;
//					g2d.setColor(LineColor);
//					g2d.setStroke(new BasicStroke(Line));
//					g2d.draw(ln);
				//End
				//Drawing First Map
					
					for(int i=0;i<level.length;i++){
						   for(int j=0;j<level[0].length;j++){
						     switch(level[i][j]){
						      case 0:
						    	  g2d.setColor(Color.white);
						    	  g2d.drawRect(i,j,WIDTH,HEIGHT);
						       break;
						       //break == break out of the loop so the other code doesn't get ran
						      case 1:
						    	  g2d.setColor(Color.black);
						    	  g2d.drawRect(i,j,WIDTH,HEIGHT);
						       break;
						      case 2: 
						    	  g2d.setColor(Color.blue);
						    	  g2d.drawRect(i,j,WIDTH,HEIGHT);
						       break;
						     }
						   }  
						}
			//cute but not what im looking for
//					GradientPaint gp = new GradientPaint(0F, 0F, Color.gray, 450F, 450F, Color.white, true);
//					g2d.setPaint(gp);
//					GeneralPath fl = new GeneralPath();
//					fl.moveTo(10F, 10F);
//					fl.lineTo(485F, 10F);
//					fl.lineTo(485F, 460F);
//					fl.lineTo(450F, 460F);
//					fl.lineTo(450, 330);
//					fl.lineTo(380, 330);
//					fl.lineTo(380F, 460F);
//					fl.lineTo(10F, 460F);
//					fl.closePath();
//					g2d.fill(fl);
				//end
				
			//end
		}
}

	
