package spark1;

import java.util.LinkedList;


public class HTMLPage extends Container implements HTMLConstants {

	LinkedList<Htmlstuff> Sequence;
	
	HTMLPage(LinkedList<Htmlstuff> sequence){
		this.Sequence = sequence; 
	}
	
	@Override
	public LinkedList<ActiveElement> getActiveElements() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
