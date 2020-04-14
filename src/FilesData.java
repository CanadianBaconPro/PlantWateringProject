//package PlantWateringProject.src;

/**
 *
 * @author @author Harper Kelly, Comp Sci 10. ID #803225004
 */
import java.io.*;
import java.util.Scanner;
 
/**
 *
 * @author Harper Kelly USERID # 803225004
 */
public class FilesData
{
   public static long fileSize(String filePath)
   {
       File f = null;
       try
        {
            f = new File(filePath);
        }
        catch (Exception e)
        {
            System.out.printf("Error : %s\n", e);
        }
       
        return f.length();
    }
   
    public static int fileSizeInt(String filePath)
    {
        File f = null;
        try
        {
            f = new File(filePath);
        }
        catch (Exception e)
        {
            System.out.printf("Error : %s\n", e);
        }
        return Math.toIntExact(f.length());
    }
   
    public static String[] reader(String filePath, int SizeToRead)
    {
        File f = null;
        Scanner sc = null;
       
        int i = 0;
        String[] input = new String[SizeToRead];
        
        try
        {
            f = new File(filePath);
            sc = new Scanner(f);
        }
        catch (FileNotFoundException e)
        {
             System.out.printf("Error : %s\n", e);
        }
        while (sc.hasNextLine())
        {
            input[i++] = sc.nextLine();
        }
        
        sc.close();
       
        return input;
    }
   
    public static void writer(String filepath, String[] data)
    {
        File f = null;
        PrintWriter pw = null;
        try 
        {
            f = new File(filepath);
            pw = new PrintWriter(f);
        }
        catch (FileNotFoundException e)
        {
            System.out.printf("Error | %s\n", e.getMessage());
        }
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != null) pw.println(data[i]);
        }
        
        pw.close();
    }
    /**
     * 
     * @param filepath Set path for file
     * @param data Data to be printed, in an array
     */
    public static void append(String filepath, String[] data)
    {
        FileWriter fw = null;
        PrintWriter pw = null;
        try 
        {
            fw = new FileWriter(filepath, true);
            pw = new PrintWriter(fw);
        }
        catch (IOException e)
        {
            System.out.printf("Error | %s\n", e.getMessage());
        }
        pw.println();
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != null) pw.println(data[i]);
        }
        
        pw.close();
    }

    static void append(String FilePath, String string) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 

//import java.util.Arrays;

 
 
/**
 *
 * @author Harper Kelly USERID # 803225004
 */
/*
public class FileReading
{
    public static void main(String[] args)
    {
 
        long a = ReadWrite.fileSize("src/CrackMes/FuckingHateFiles.txt");        
       
        int i = 0;
        int b = Math.toIntExact(a);
       
        String[] input = new String[b];
       
        input = ReadWrite.reader("src/CrackMes/FuckingHateFiles.txt", b);
       
        for (i = 0; i < input.length; i++)
        {
            while (input[i] != null)
            {
                System.out.printf("%s\n", input[i]);
                break;
            }
        }
        double total = 0;
        i = 0;
       
        // Get average
        int temp = 0;
 
        for (char ch : Arrays.toString(input).toCharArray())
        {
            if (Character.isDigit(ch))
            {
                System.out.printf("%s\n", ch);
                temp = (ch + (ch));
                System.out.printf("%s\n", temp);
                total += temp;
            }
        }
        System.out.printf("%s\n", temp);
       
        total = (total / (0.5 * total));
        System.out.printf("Grade Average = %s\n", total);
 
       
    }
}


/* Screen Dump

*/