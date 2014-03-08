package spark1;

import java.util.LinkedList;

public class Parser implements HTMLConstants {
	
	HTMLTokenizer Tokens;
	
	
	Parser(HTMLTokenizer tokens){
		this.Tokens = tokens;
	}
	
	/**
	 * 
	 * @param Token
	 * @return true if Token kind matches current, false otherwise
	 */
	public boolean expect(int Token) {
		return Tokens.current().getKind() == Token;
	}
	
	/** If token matches, advances, otherwise throws exception
	 * 
	 * @param Token
	 * @throws ParseException
	 */
	public void orElse(int Token) throws ParseException {
		if (Tokens.current().getKind()==Token){
			Tokens.advance();
		} else {
			throw new ParseException();
		}
	}
	
	/** Parses token stream, builds an HTMLPage
	 * 
	 * @return HTMLPage 
	 * @throws ParseException
	 */
	public HTMLPage parseHTML() throws ParseException {
		orElse(OPENHTML);
		orElse(OPENBODY);
		LinkedList<Htmlstuff> toBuild = new LinkedList<Htmlstuff>();
		while (!expect(CLOSEBODY)){
			if (expect(OPENPARAGRAPH)){
				Tokens.advance();
				toBuild.addLast(parseParagraph());
			} if (expect(OPENFORM)){
				Tokens.advance();
				toBuild.addLast(parseForm());
			} else {
				throw new ParseException();
			}
		}
		
		orElse(CLOSEHTML);
		orElse(EOF);
		return new HTMLPage(toBuild);
	}
	
	/**Parses token stream, builds a paragraph
	 * 
	 * @return Paragraph
	 * @throws ParseException
	 */
	public Paragraph parseParagraph() throws ParseException {
		LinkedList<Paragraphstuff> toBuild = new LinkedList<Paragraphstuff>();
		while (!expect(CLOSEPARAGRAPH)){
			if (expect(TEXT)) {
				toBuild.addLast(new Text(Tokens.current().getAttr()));
				Tokens.advance();
			} else if (expect(OPENLINK)) {
				toBuild.addLast(parseLink());						
			} else {
				throw new ParseException();
			}
		}
		Tokens.advance();
		return new Paragraph(toBuild);
	}
	
	/** Parses token stream, builds a Link
	 * 
	 * @return Link
	 * @throws ParseException
	 */
	public Link parseLink() throws ParseException {
		String url = Tokens.current().getAttr();
		Tokens.advance();
		if (expect(TEXT)){
			String text = Tokens.current().getAttr();
			Tokens.advance();
			orElse(CLOSELINK);
			return new Link(url, text);
		} else{
			throw new ParseException();
		}
	}
	
	/** Parses token stream, builds a Form
	 * 
	 * @return Form
	 * @throws ParseException
	 */
	public Form parseForm() throws ParseException {
		LinkedList<Formstuff> toBuild = new LinkedList<Formstuff>();
		while (!expect(CLOSEFORM)){
			if (expect(OPENPARAGRAPH)){
				Tokens.advance();
				toBuild.addLast(parseParagraph());
			} else if (expect(INPUT)) {
				String attr = Tokens.current().getAttr();
				toBuild.addLast(new Input(attr));
			} else if (expect(SUBMIT)) {
				toBuild.addLast(new Submit());
			} else {
				throw new ParseException();
			}
		}
		Tokens.advance();
		return new Form(toBuild);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
