package spark1;

import java.util.LinkedList;

public class Form extends Container implements Htmlstuff, HTMLConstants  {
	
	LinkedList<Formstuff> Sequence;
	
	Form(LinkedList<Formstuff> sequence){
		this.Sequence = sequence;
	}
	
	

	@Override
	public LinkedList<ActiveElement> getActiveElements() {
		return null;
	}

}
