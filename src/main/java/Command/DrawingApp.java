package Command;


/**
 * Hello world!
 *
 */
public class DrawingApp {
	
	private static DrawingApp INSTANCE ;
	
	private DrawingApp() {
		
	}
	
	public static DrawingApp getInstance() {
		if (INSTANCE == null) INSTANCE = new DrawingApp();
		return INSTANCE;
	}
	
	
    public static void main( String[] args ){
       DrawingTUI d = new DrawingTUI();
       while(true) {
    	   d.nextCommand();
       }
    }
}
