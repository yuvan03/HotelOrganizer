import java.io.*;
public class OHS
{
    public static void main()throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Trip obj = new Trip();//creating object of Trip class        
        int attemptno=1;//creating variable attemptno to log number of attempts
        while(attemptno<=3)
        //3 attempts for logging in using correct username
        {
            System.out.print("Enter the user name : ");
            String name = br.readLine();
            
            if(name.equals("OHSadmin")==true)//user can only use the program if userame is correct
            {
                System.out.println("\nWelcome");
                break;
            }
            attemptno++;
            if(attemptno==4) //error message to show that there have been 3 failed attempts at logging in
            {
                System.out.println("Invalid credentials");
                System.exit(0);//user must try to log in again
            }
        }
        int choice=0;
        //menu for user to choose whether to input student details, generate a query or exit the program
        while(choice!=3)
        {
            System.out.println("\nMenu ");
            System.out.println("1. Input Student Details");
            System.out.println("2. Generate Query");
            System.out.println("3. Exit");            
            System.out.print("Enter your choice : ");            
            choice=Integer.parseInt(br.readLine());
            switch(choice)//to 
            {
                case 1:
                obj.input();//calling method
                break;
                case 2:
                obj.report();//calling method
                break;
                case 3:
                System.out.println("Thank you... ");//calling method
                break;
                default:
                System.out.println("\fBad choice... Re-Enter");//displaying error message if invalid option enterred
                break;
            }
        }
    }
}
