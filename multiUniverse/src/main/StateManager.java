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
		if (GameDisplay.gameStates)
	}
	public void activate(){
		gameLoop  = new LoopState();
		mainMenu  = new MenuState();
		gameLoop.setUp(this);

		mainMenu.setIgnoreRepaint(true);
		//gameLoop.setIgnoreRepaint(true);
		
		this.setIgnoreRepaint(true);
		currentState = mainMenu;
		this.add(currentState);
		currentState.setUp(this);
		
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

		}
		if (state.equals("loop")){
			System.out.println("change called");
			State lastState =currentState;
			
			this.remove(lastState);
			currentState = gameLoop;
			this.add(currentState);
			lastState.deactivate();
			currentState.activate();
			
			
			//currentState.setVisible(true);
			
			
			
			
			//currentState.repaint(0);
			
			//this.repaint();
			//this.paintComponents(this.getGraphics());
		}
	}
	
}
