package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MenuState extends State implements ActionListener{
	private boolean running = true;
	int x = 0;
	JButton btn = new JButton("Play");
	JButton btn2 = new JButton("Quit");
	@Override
	public void activate(){
		running = true;
		JFrame myFrame = new JFrame();
		MenuState ms = new MenuState();
		myFrame.add(ms);
		myFrame.setSize(500, 500);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
     	myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ms.setLayout(null);
		
	   
	    
	    btn.setFont(new Font("SansSerif", Font.ITALIC, 20));
	    
	    btn.addActionListener(this);
	    btn.setActionCommand("Loop");
		btn.addActionListener(this);
	    btn.setBounds(190, 300, 120, 30);
		ms.add(btn);
	    
		
		
		while(running){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x++;
			this.repaint();
			//System.out.println("repaint called");
		}
	}
	public void deactivate(){
		btn.removeActionListener(this);
		running = false;
		
	}
	
	
	public void setup(StateManager m){
		parent = m;
		//this.setLayout(null);
	}
	StateManager parent = null;
	//JButton btn = new JButton("Play");
	
//	public void paint(Graphics g){
//		super.paint(g);
//		Graphics2D g2d = (Graphics2D)g;
//		g2d.setColor(new Color(0.5f,0.0f,0.5f));
//		g2d.fillRect(x, 0, 20, 20);
//		
		//System.out.println("Paint Called");
//	}
	public void paintComponent(Graphics g){
		//super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0.0f,1.0f,1.0f));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		System.out.println("Paint Component");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if("Loop".equals(arg0.getActionCommand())){
			//parent.switchState("loop");
			System.out.println("Loop Pressed!");
		}
		
	}

}