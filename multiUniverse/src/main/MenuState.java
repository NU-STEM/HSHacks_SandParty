package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;




public class MenuState extends State implements ActionListener{
	private boolean running = true;
	private JButton btn = new JButton("Play");
	private JButton btn2 = new JButton("Quit");
	private JButton btn3 = new JButton("Credits");
	private StateManager parent = null;
	
	@Override
	public void activate(){
		running = true;
		
		this.setLayout(null);
		
	    btn.setFont(new Font("SansSerif", Font.ITALIC, 20));

	    btn.addActionListener(this);
	    btn.setActionCommand("Loop");
	    btn.setBounds(190, 300, 120, 30);
	    
        btn2.setFont(new Font("SansSerif", Font.ITALIC, 20));
	    
	    btn2.addActionListener(this);
	    btn2.setActionCommand("Quit");
	    btn2.setBounds(190, 350, 120, 30);
	    
        btn3.setFont(new Font("SansSerif", Font.ITALIC, 20));
	    
	    btn3.addActionListener(this);
	    btn3.setActionCommand("Credits");
	    btn3.setBounds(190, 400, 120, 30);
		
		
	    this.add(btn);
	    this.add(btn2);
	    this.add(btn3);
		while(running){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			//System.out.println("repaint called");
		}
	}
	public void deactivate(){
		btn.removeActionListener(this);
		btn2.removeActionListener(this);
		btn3.removeActionListener(this);
		running = false;
		
	}
	
	
	public void setUp(StateManager m){
		parent = m;
		System.out.println("setup complete-menu");
	}
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
			parent.switchState("loop");
			this.deactivate();
			System.out.println("Loop Pressed!");
		}else if("Quit".equals(arg0.getActionCommand())){
			System.out.println("Quit Pressed!");
		}else if ("Credits".equals(arg0.getActionCommand())){
			System.out.println("Credits Pressed!");
		}
		
	}
	
}
