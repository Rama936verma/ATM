

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordcounter 
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text or provide a file path: ");
        String input = sc.nextLine();
        String text;
        if (input.endsWith(".txt")) 
        {
            try 
            {
                File file = new File(input);
                Scanner FileScanner = new Scanner(file);
                text = FileScanner.useDelimiter("\\Z").next();
                FileScanner.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("File not found.");
                return;
            }
        }
         else 
        {
            text = input;
        }
        String[] txtwords = text.split("[\\s\\p{Punct}]+");
        int Counter = 0;
        for (String words : txtwords) 
        {
            if (!words.isEmpty()) 
            {
                Counter++;
            }
        }
        System.out.println("Total word count: " +Counter);
    }
}
