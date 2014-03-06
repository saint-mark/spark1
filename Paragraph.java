package sparkzilla;

import java.util.LinkedList;

public class Paragraph extends Container implements Htmlstuff, HTMLConstants {

	LinkedList<Paragraphstuff> Sequence;
	
	Paragraph(HTMLTokenizer Tokens){
		while (Tokens.current().getKind() != CLOSEPARAGRAPH){
			
		}
	}
	
	@Override
	public LinkedList<ActiveElement> getActiveElements() {
		// TODO Auto-generated method stub
		return null;
	}

}
