package presentation;

public class MainController {
	Dispatcher dispatcher;
	

	static MainController mc = new MainController();

	public MainController() {
		this.dispatcher = new Dispatcher();
	}

	public void dispatchrequest(String request) {
		this.dispatcher.dispatch(request);
	}
	public static MainController getIstance(){
		return mc;
	}
}