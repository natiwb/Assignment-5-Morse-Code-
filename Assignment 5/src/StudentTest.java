import java.io.File;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StudentTest 
{

	/*File inputFile;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	 */
	public static void main(String[]args) throws FileNotFoundException 
	{
		System.out.print(MorseCodeConverter.convertToEnglish(new File("/Users/Nati/git/Assignment-5-Morse-Code-/Assignment 5/src/Daisy.txt")));

	}
}

