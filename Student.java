public class Student extends Room
{
    private String name;//variable storing student's name
    private char gender;//variable storing student's gender
    private String email;//variable storing student's email
    private int grade;//variable storing student's grade
    private int roomNo;//variable storing student's roomNo
    public Student()//default constructor to initialize all variables with default values
    {
        name="";
        gender=' ';
        email="";
        grade=12;
        roomNo=0;
    }
    //mutator methods for each private variable
    public void setName(String name)
    {
        this.name=name;
    }

    public void setGender(char Gender)
    {
        this.gender=Gender;
    }

    public void setEmail(String Email)
    {
        this.email=Email;
    }

    public void setGrade(int Grade)
    {
        this.grade=Grade;
    }

    public void setRoom()
    {
        this.roomNo=get(this.gender,this.grade);
        //System.out.println(this.roomNo);
    }
    //accessor methods for each private variable
    public String getName()
    {
        return this.name;
    }    

    public char getGender()
    {
        return this.gender;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getGrade()
    {
        return this.grade;
    }

    public int getroomNo()
    {
        return this.roomNo;
    }
}






