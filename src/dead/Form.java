package dead;

import java.util.LinkedList;

public class Form extends Container implements Htmlstuff, HTMLConstants  {
	
	LinkedList<Formstuff> Sequence;
	
	Form(HTMLTokenizer Tokens){
		while (Tokens.current().getKind() != CLOSEFORM){
			
		}
	}
	
	

	@Override
	public LinkedList<ActiveElement> getActiveElements() {
		return null;
	}

}
