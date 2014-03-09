package main;

import javax.swing.JFrame;

//Alex
//Can
//Yoshi
public class MainProgram {
	public static int[] gameWindowSize = {1920,1080};
	
	public static void main(String[] args0){
		
		JFrame gameWindow = new JFrame();
		GameDisplay gameDisplay = new GameDisplay();
		
		gameWindow.setSize(gameWindowSize[0], gameWindowSize[1]);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setLocationRelativeTo(null);
		gameWindow.add(gameDisplay);
		gameDisplay.startGameLoop();
		if (GameDisplay.gameState == 1){
			gameWindow.setResizable(true);
			gameWindow.setSize(1920,1080);
		}
	}
	
}	
	
	
	
/*	//static StateManager sm;
	public static void main(String[] args) {
		//Frame
			//MenuState ms = new MenuState();
			StateManager sm = new StateManager();
			//sm = new StateManager();
			sm.activate();
			
			
		//End
	}*/
