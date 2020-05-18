package Command;


/**
 * Main Logiciel dessin
 */
public class DrawingApp {
	
	private static DrawingApp INSTANCE ;
	
	private DrawingApp() {
		DrawingTUI d = new DrawingTUI();
	       while(true) {
	    	   d.nextCommand();
	       }
	}
	
	public static DrawingApp getInstance() {
		if (INSTANCE == null) INSTANCE = new DrawingApp();
		return INSTANCE;
	}
	
	
    public static void main( String[] args ){
      INSTANCE = getInstance();
    }
}
