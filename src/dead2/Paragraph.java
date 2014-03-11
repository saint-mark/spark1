package spark1;

import java.util.LinkedList;

public class Paragraph extends Container implements Htmlstuff, Formstuff, HTMLConstants {

	LinkedList<Paragraphstuff> Sequence;
	
	Paragraph(LinkedList<Paragraphstuff> Sequence){
		this.Sequence = Sequence;
	}
	
	@Override
	public LinkedList<ActiveElement> getActiveElements() {
		// TODO Auto-generated method stub
		return null;
	}

}
