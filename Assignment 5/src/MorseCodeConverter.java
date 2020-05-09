import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter 
{

	static MorseCodeTree morseCode=new MorseCodeTree();
	String data;
	public MorseCodeConverter() 
	{
		morseCode=new MorseCodeTree();
	}
	/**
	 * printTree

public static java.lang.String printTree()
returns a string with all the data in the tree in LNR order with an space in between them.
 Uses the toArrayList method in MorseCodeTree It should return the data in this order: 
"h s v i f u e l r a p w j b d x n c k y t z g q m o" 
Note the extra space between j and b - that is because there is an empty string that is the root,
 and in the LNR traversal, the root would come between the right most child of the left tree (j) and 
 the left most child of the right tree (b). This is used for testing purposes to make sure the 
 MorseCodeTree has been built properly
Returns:
@return the data in the tree in LNR order separated by a space.

	 */

	public static String printTree()
	{
		//String printTree;
		//	System.out.println(morseCode.toArrayList());
		StringBuffer sb = new StringBuffer();

		for(String printTree:morseCode.toArrayList()) 
		{
			sb.append(printTree);
			sb.append(" ");
		}
		String appended=sb.toString();
		System.out.println(appended);
		return appended;
	}

	/**
	 * convertToEnglish

public static java.lang.String convertToEnglish(java.lang.String code)
Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
Example: 
code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
string returned = "Hello World"
Parameters:
code - the morse code
Returns:
the English translation

	 */
	public static String convertToEnglish(String code) 
	{
		Scanner sc=new Scanner(code);
		String translated="";

		while(sc.hasNext()) 
		{
			//to separate letter
			String letter=sc.next();

			if(letter.equals("/"))
			{
				translated+=" ";
			}
			else
			{
				translated+=morseCode.fetch(letter);
			}
		}
		System.out.println(morseCode.toArrayList());

		return translated;
	}



	/**
	 * convertToEnglish

public static java.lang.String convertToEnglish(java.io.File codeFile)
                                         throws java.io.FileNotFoundException
Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
Example: 
a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
string returned = "Hello World"
Parameters:
@param codeFile - name of the File that contains Morse Code
Returns:
@return the English translation of the file
Throws:
java.io.FileNotFoundException
	 * @throws FileNotFoundException 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String toBeTranslated="";

		if(codeFile.exists()) 
		{
			Scanner sc=new Scanner(codeFile);

			while(sc.hasNext()) 
			{
				toBeTranslated+=sc.next();
				toBeTranslated+="";
			}
			return convertToEnglish(toBeTranslated);

		}
		else
			throw new FileNotFoundException();

	}



}


