import java.lang.String;
import java.util.ArrayList;

public class FileBody {

	ArrayList <String> myFileLines ;
	public FileBody() {
		
		// TODO Auto-generated constructor stub
		//this.myFileLines = new ArrayList <String>();
		
	}
	public void setString(ArrayList <String> string) {
		/**
		 * Returns the current string
		 */
	
			this.myFileLines=string;
	}

	public ArrayList <String> getString() {
		/**
		 * Returns a string that consists of all the consonants in the current string,
		 * in the same order and with the same case.
		 * ("y" is considered a consonant)
		 */
		return this.myFileLines;
	}
	
	
}
