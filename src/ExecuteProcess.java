public class ExecuteProcess 
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
		    System.out.printf("\n\nProcess Executed Successfully\n\n");
        }
        catch (Exception e) {System.out.printf("\n\nError in Executing Process\n\n");}
    }
}
