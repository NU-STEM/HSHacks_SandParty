package main;

import javax.swing.JFrame;

public class StateManager extends JFrame{
	LoopState gameLoop = null;
	State currentState = null;
	State mainMenu = null;
	
	public StateManager(){
		this.setSize(500,500);
		this.setVisible(true);
	    this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void activate(){
		gameLoop  = new LoopState();
		mainMenu  = new MenuState();
		mainMenu.setUp(this);
		mainMenu.setIgnoreRepaint(true);
		gameLoop.setIgnoreRepaint(true);
		this.setIgnoreRepaint(true);
		currentState = mainMenu;
		this.add(currentState);
		currentState.setUp(this);
		this.paintComponents(this.getGraphics());
		
		while(true){
			currentState.activate();
			System.out.println("main Finished");
		}
		
		
	}
	public void switchState(String state){
		if (state.equals("mainmenu")){
			State lastState =currentState;
			
			this.remove(lastState);
			currentState = mainMenu;
			this.add(currentState);
			lastState.deactivate();
			this.repaint();
			this.repaint();
			this.paintComponents(this.getGraphics());
		}
		if (state.equals("loop")){
			System.out.println("change called");
			State lastState =currentState;
			this.remove(lastState);
			currentState = mainMenu;
			this.add(currentState);
			currentState.setVisible(true);
			//mainMenu.activate();
			//mainMenu.repaint(0);
			lastState.deactivate();
			this.repaint();
			this.paintComponents(this.getGraphics());
		}
	}
	
}
