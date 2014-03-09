package spark1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Stack;

/**
 * Spark is the container for our web browser, activating the Parser and performing Client functionality
 * @author Emma (eherold) and Mark (mstlouis)
 *
 */
public class Spark {

	Stack<HTMLPage> oldPages;

	//CURRENTLY TAKES LOCALHOST, TO BE OVERWRITTEN BY FETCHED HOST
	private static final String host = "localhost";
	private static final int port = 8080;
	Socket socket;


	public Spark() throws UnknownHostException, IOException{
		this.socket = new Socket(host, port);
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void get() throws IOException{

		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		//output = output from the server
		int output = reader.read();
		while(output != -1){
			System.out.print((char)output);
			output = reader.read();
		}

		socket.shutdownInput();
		reader.close();
	}

	
	/**
	 * Sends information to the server
	 * @param toGive - the information to be sent, already checked for validity
	 * @throws IOException
	 */
	public void give(String toGive) throws IOException{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		writer.write(toGive)

		writer.flush();
		reader.close();
		socket.shutdownOutput();

	}

	/**
	 * Checks for valid user input
	 * @param input - the user's input in String form
	 * @throws IOException
	 */
	public boolean checkValidInput(String input){
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Sorry, that's not a valid input. Please enter a number.");
		}
	}
	
	/**
	 * Controls user interation
	 * @return a String, the user's input, checked for validity
	 */
	public String talkToUser() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			boolean validInput = true;
			
			while (validInput) {
				System.out.println("What would you like to do?");
				int rawInput = reader.read();
				
				//Should this be the int equivalent of \n instead of -1?
				while(rawInput != -1) {
					userInput = userInput + (char) rawInput;
					input = reader.read();
				}
				
				//Enables re-prompting of user if invalid input
				if(!checkValidInput(userInput)) {
					validInput = false;
				}
			}
			
			reader.close();
	}
	
	// Need to decide where I'm going to take talkToUser output and transfer to give()


	public static void main(String[] args) throws IOException {
		Client test1 = new Client();
		test1.give();
		test1.get();

	}

}
