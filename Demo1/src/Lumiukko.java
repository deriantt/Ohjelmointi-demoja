import fi.jyu.mit.graphics.EasyWindow;
public class Lumiukko {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	EasyWindow window = new EasyWindow();
	
	window.addCircle(20,80-2*15-20-10,10);
	window.addCircle(20,80-15-20,15);
	window.addCircle(20,80,20);
	
	window.showWindow();
	

	}

}
