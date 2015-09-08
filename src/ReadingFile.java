import java.lang.String;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFile {

	
	/**
	 * @param args
	 */
	static String helpLine = "Please include in quotation marks file path and delimeters that needed";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String delim = ".:!?";
		int wrdlng = 3;
		String filePath = null;
		try {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("-d")) {
					i++;
					delim = args[i];
					System.out.println("Delimeters are " + delim);
				} else if (args[i].equals("-l")) {
					i++;
					wrdlng = Integer.parseInt(args[i]);
					System.out.println("Word Lenght is " + String.valueOf(wrdlng));
				}

				else if (args[i].equals("-h")) {
					i++;
					System.out.println(helpLine);
				} else {
					filePath = args[i];
					System.out.println(filePath);
				}
			
			}
			if (!filePath.isEmpty())
			{
				readingFile(filePath, "["+delim+"]+");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static ArrayList <String> readingFile(String filePath, String delim)
	{
		        // Use this for reading the data.
	     BufferedReader reader = null;
	        ArrayList <String> myFileLines = new ArrayList <String>();
	        try {
	            String sCurrentLine;
	            boolean endSent = true;
	            reader = new BufferedReader(new FileReader(filePath));
	            while ((sCurrentLine = reader.readLine()) != null) {
	                //System.out.println(sCurrentLine);
	            	
	            	if (sCurrentLine.length()>0) {
						String[] tokens = sCurrentLine.split(delim);
						for (int i = 0; i < tokens.length; i++) {
							if (endSent && tokens[i].length()>0) {
								myFileLines.add(tokens[i]);
							} else {
								myFileLines.set(myFileLines.size() - 1,
										myFileLines.get(myFileLines.size() - 1)
												+ tokens[i]);
							}
						}
						String lastPosition = sCurrentLine
								.substring(sCurrentLine.length() - 1);
						if (!delim.contains(lastPosition)) {
							endSent = false;
						}
						else endSent = true;
						//  myFileLines.add(sCurrentLine);
					}
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.print(e.getMessage());
	        } finally {
	            try {
	                if (reader != null)reader.close();
	            } catch (IOException ex) {
	                System.out.println(ex.getMessage());
	                ex.printStackTrace();
	            }
	        }
	        int numElements = myFileLines.size();
	        System.out.println ("there are n lines in the file:" + numElements);

	        for (int counter = numElements-1; counter >= 0; counter--) {
	            String mylineout = myFileLines.get(counter);
	            System.out.println (mylineout);
	        }
		return myFileLines;
		
	}
}
