package spark1;

public class Text extends Expression implements Formstuff, Paragraphstuff {
	
	String value;
	
	Text(String value){
		this.value = value;
	}
	
	@Override
	public String toString(){
		return this.value;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof Text){
			Text other = (Text) o;
			return this.value.equals(other.value);
		} else {
			return false;
		}
	}
}
