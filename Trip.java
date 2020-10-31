import java.io.*;
import java.util.Arrays;
public class Trip
{
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    static int count=-1;//initializing count variable as -1
    Student std[]=new Student[40];//initializing 1 dimensional Student array of size 40
    //default constructor
    public Trip()
    {
        for(int i=0;i<40;i++)
            std[i]=new Student();
    }
    //method to display all student details
    void displayAll()
    {
        System.out.println("\nRoom No\tGender\tGrade\tName\t\tEmail");
        for(int i=0;i<=count;i++)
        {
            if(std[i].getGender()!=' ')
                System.out.println(std[i].getroomNo()+"\t"+std[i].getGender()+"\t"+std[i].getGrade()+"\t"+std[i].getName()+"\t\t"+std[i].getEmail());
        }
    }
    //method to print details of room after user enters room number
    void inputRoom() throws IOException
    {
        System.out.println("\nEnter Room No : ");
        int rno=Integer.parseInt(br.readLine());
        std[count].roomDetails(rno);
    }

    //method to display names of all students in a room by accepting one student's name
    void otherStds() throws IOException
    {
        System.out.println("\nEnter Name of the other student : ");
        String SName=br.readLine();
        std[count].otherStd(SName);

    }
    //method to input name from user and remove student
    void removeStd() throws IOException
    {
        System.out.println("\nEnter Name of the student to be removed: ");
        String rstd = br.readLine();
        for (int i = 0; i <=count; i++)
        {
            if (std [i].getName().equals(rstd))
            {    
                std[i].setName(" ");
                std[i].setGender(' ');
                std[i].setEmail(" ");
                std[i].setGrade(12);
                break;
            }

        }

    }
    //method to save data into disk file
    public static void write (String filename, Student []std) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < std.length; i++) {
            
            if(std[i].getGender()!=' ')
                outputWriter.write(std[i].getroomNo()+"\t"+std[i].getGender()+"\t"+std[i].getGrade()+"\t"+std[i].getName()+"\t\t"+std[i].getEmail());
            outputWriter.newLine();
        }
        outputWriter.flush();  
        outputWriter.close();  
    }
    //input method to allow user to enter details of students with validation checks
    void input() throws IOException
    {
        count++;
        System.out.print(" \nEnter name of a student : ");
        String name=br.readLine();
        char Gender;
        while(true)
        {
            System.out.print("Enter Gender M/F: ");
            //To make program more user-friendly, either upper or lower case are accepted and converted to upper case ('m' = 'M')
            Gender=Character.toUpperCase((br.readLine().charAt(0)));
            if(Gender=='M'||Gender=='F')
                break;//breaks loop if correctly entered
            else //outputs error message and asks user to re-enter value when any invalid character is entered
                System.out.println("Gender entered incorrectly.Please re-enter..... ");    
        }
        String email = "";
        boolean pcheck = false;
        while (pcheck == false)
        {
            System.out.print("Enter email address of a student : ");
            email=br.readLine();
            int n = email.length();
            for (int i = 0; i<n-1; i++)
            {
                if(email.charAt(i) =='@')//presence check of '@' to validate entry
                    pcheck = true;
            }
            if (pcheck==false) //outputs error message and allows user to reenter when invalid entry of email address is made
                System.out.println("Invalid email address - you must have an @ in"+ 
                    "the address before the email website. Please try again");
        }
        int grade;
        while(true)
        {
            System.out.print("Enter Grade of a student (6-12): ");
            grade=Integer.parseInt(br.readLine());
            //System.out.println(String.valueOf(grade));
            if(grade>=6 && grade<=12)//range check to check if grade is between 6 and 12
                break;
            else//outputs error message and allows user to reenter when invalid entry of grade is made
                System.out.println("Grade entered incorrectly. Please re-enter..... ");
        }
        std[count].setName(name);
        std[count].setGender(Gender);
        std[count].setGrade(grade);
        std[count].setEmail(email);
        std[count].setRoom();
        std[count].store(name,Gender,email,grade,std[count].getroomNo());

        write("output.txt", std);
    }
    //method to show a report/query based on user's preference
    void report() throws IOException
    {
        int choice=1;
        //Displaying options to users
        while(choice!=0)
        {
            System.out.println(" \n\t\tMenu");
            System.out.println("1. Display Student Details");
            System.out.println("2. Input Room No. and display all students in that room");
            System.out.println("3. Input Grade and Gender and print room numbers with empty beds");
            System.out.println("4. Input name of a student and display all students in that room");
            System.out.println("5. Remove a student from his/her room");
            System.out.println("6. Display Hotel Data");
            System.out.println("7. Print total number of empty beds");
            System.out.println("0. Back");            
            //Inputting user's choice
            System.out.print("Enter your choice : ");            
            choice=Integer.parseInt(br.readLine());
            switch(choice)
            {
                case 1:
                displayAll();
                break;
                case 2:
                inputRoom();
                break;
                case 3:
                char Gender;
                //validation check to make sure valid gender is entered
                while(true)
                {
                    System.out.print("Enter Gender M/F: ");
                    Gender=Character.toUpperCase((br.readLine().charAt(0)));
                    if(Gender=='M'||Gender=='F')
                        break;
                    else
                        System.out.println("Gender entered incorrectly......ReEnter..... ");
                }

                int grade;
                //validation check to make sure valid grade is entered
                while(true)
                {
                    System.out.print("Enter Grade of the student (6-12): ");
                    grade=Integer.parseInt(br.readLine());
                    //System.out.println(String.valueOf(grade));
                    if(grade>=6 && grade<=12)
                        break;
                    else
                        System.out.println("Grade entered incorrectly......ReEnter..... ");
                }

                std[count].inputGradeGender(Gender, grade);//calling method
                break;      
                case 4:
                otherStds();//calling method 
                break;
                case 5:
                removeStd();//calling method 
                break;
                case 6:
                std[count].hotelData();//calling method 
                break;
                case 7:
                std[count].printEmpty();//calling method 
                break;
                case 0:
                System.out.println("\f");//calling method 
                return;
                default://outputs error message if any character besides those above are entered
                System.out.println("\fIncorrect choice. Please Re-Enter...");
                break;
            }
        }
    }
}

