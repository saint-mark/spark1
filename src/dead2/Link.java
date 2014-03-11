package spark1;

public class Link extends Expression implements ActiveElement, Formstuff, Paragraphstuff {

	String url;
	
	String value;
	
	Link(String url, String value){
		this.url = url;
		this.value = value;
	}
	
	@Override
	public void activate() {
		// TODO Direct to url
		
	}

}
