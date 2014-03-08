package main;

public interface IState {
	public void setUp(StateManager m);
	public void activate();
	public void deactivate();
}
