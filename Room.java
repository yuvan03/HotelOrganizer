import java.util.*;
import java.io.*;
public class Room
{
    static private String data[][];//creating private data array
    Scanner sc=new Scanner(System.in);
    public Room() //default constructor to initialize values
    {
        data=new String[50][7];
        int k=1;
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(j==0)
                    data[i][j]=String.valueOf(i);
                else if(j<3)
                    data[i][j]="X";
                else
                    data[i][j]="empty";                    
            }
        }
    }

    int get(char gender, int grade) // input gender and grade
    {
        // each row is a gender-grade combination
        int i=0;
        for(;i<50;i++)
        {
            // if gender not empty
            if(data[i][1].equals("X")==false)
            {
                // if gender and grade are equal to input
                if(data[i][1].equals(String.valueOf(Character.toUpperCase(gender))) && data[i][2].equals(String.valueOf(grade)))
                {   
                    // if any empty slot exists
                    for(int j=3;j<7;j++)
                    {
                        if(data[i][j].equals("empty"))
                            return (i);
                    }
                }
                // if gender and grade are not equal to input
                else
                    continue;
            }
            // if gender empty
            else 
                return i;
        }
        return i;      
    }
    //method for user to input student details 
    public void store(String name,char gender,String email,int grade,int roomNo)
    {
        if(data[roomNo][1].equals("X")==true)
        {
            data[roomNo][3]=name;
            data[roomNo][2]=String.valueOf(grade);
            data[roomNo][1]=String.valueOf(gender);
        }
        else
        {
            for(int j=3;j<7;j++)
            {
                //if there are empty beds available
                if(data[roomNo][j].equals("empty")==true)
                {                    
                    data[roomNo][j]=name;
                    return;
                }
            }
        }
    }
    //method to display names of all students in a room by accepting one student's name
    public void otherStd(String SName)
    {
        boolean flag=false;
        for(int i=0;i<50;i++)
        {
            for(int j=3;j<7;j++)
            {
                if(data[i][j].equals(SName))
                {
                    for(int k=3;k<7;k++)
                        System.out.print(data[i][k]+"\t");                
                    return;
                }
            }
        }
        System.out.println("\n\nNo student with this name\n");                
    }
    //method printing room details
    public void roomDetails(int n)
    {
        System.out.println();
        for(int j=3;j<7;j++)
            System.out.print(data[n][j]+"\t");                
    }

    // print number of empty beds
    public void printEmpty()
    {
        int ct = 0;//ct variable to count the number of empty beds
        for(int i=0;i<50;i++)
        {
            for(int j=3;j<7;j++)
            {
                if(data[i][j]=="empty") //check for an empty bed
                ct++;//incrementing value of ct variable
            }
        }
        System.out.println("There are "+String.valueOf(ct)+" empty beds");//output message with number of empty beds
    }
    //method to output room (with available empty beds) number of matching grade and gender with user's entry
    public void inputGradeGender(char Gender, int grade)
    {

        // each row is a gender-grade combination

        int[] roomNos=new int[50];

        System.out.print("Here are the room numbers "+
            "with empty beds and matching grade and gender: ");
        for(int i=0;i<50;i++)
        {          

            if(data[i][1].equals(String.valueOf(Gender)) && data[i][2].equals(String.valueOf(grade)))
            {   
                // if any empty slot exists
                for(int j=3;j<7;j++)
                {   

                    if(data[i][j].equals("empty"))//checking if empty bed is present

                    {

                        System.out.print(" "+String.valueOf(i));

                        break;
                    }
                }
            }
            // if gender and grade are not equal to input
            else
                continue;

        }

    }
    //method to output hotel data 
    public void hotelData()
    {
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<7;j++)
                System.out.print(data[i][j]+"\t");                
            System.out.println();
            if((i+1)%10==0)
            {
                System.out.print("\nPress any key to show next ten rooms - "+ 
                    "Displaying ten at a time for convenience");//displaying ten rooms at a time for convenience
                char ch=sc.next().charAt(0);
            }
        }
    }
}



