public class SendText 
{
    /**
     * 
     * @param PathToMessage The path to the bash script where the message is contained
     */
    public static void text(String PathToMessage)
    {
        try
		{
		    Process pro = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", PathToMessage});
		    System.out.printf("Process Executed Successfully\n");
        }
        catch (Exception e) {System.out.printf("Error in Executing Process\n");}
    }
}
