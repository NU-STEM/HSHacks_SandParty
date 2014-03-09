package main;

import javax.swing.JFrame;

public class StateManager extends JFrame{
	LoopState gameLoop = null;
	State currentState = null;
	State mainMenu = null;
	
	public StateManager(){
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void activate(){
		gameLoop  = new LoopState();
		mainMenu  = new MenuState();
		mainMenu.setUp(this);
		mainMenu.setIgnoreRepaint(true);
		gameLoop.setIgnoreRepaint(true);
		this.setIgnoreRepaint(true);
		currentState = gameLoop;
		this.add(currentState);
		currentState.setUp(this);
		this.paintComponents(this.getGraphics());
		
		while(true){
			currentState.activate();
			System.out.println("main Finished");
		}
		
		
	}
	public void switchState(String state){
		
	}
	
}
