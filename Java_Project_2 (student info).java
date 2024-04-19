import java.util.Arrays;
import java.util.Scanner;

public class StudentInfo 
{
    // thetw //
    private int student_ID;
    private String student_Full_Name;
    private String student_Department;
    private int student_Age;
    private String[] student_Passed_Lessons;
    private double[] student_Grades;

    // default constructoras //
    public StudentInfo() 
    {
        //NULL//
    }

    // Construcoras gia parametrous //
    public StudentInfo(int student_ID, String student_Full_Name, String student_Department, int student_Age, String[] student_Passed_Lessons, double[] student_Grades) 
    {
        this.student_ID = student_ID;
        this.student_Full_Name = student_Full_Name;
        this.student_Department = student_Department;
        this.student_Age = student_Age;
        this.student_Passed_Lessons = student_Passed_Lessons;
        this.student_Grades = student_Grades;
    }

    // Get & Set //
    public int getstudent_ID() 
    {
         return student_ID; 
    }

    public void setstudent_ID(int student_ID) 
    { 
        this.student_ID = student_ID; 
    }

    public String getstudent_Full_Name() 
    { 
        return student_Full_Name; 
    }

    public void setstudent_Full_Name(String student_Full_Name) 
    { 
        this.student_Full_Name = student_Full_Name; 
    }

    public String getstudent_Department() 
    { 
        return student_Department; 
    }

    public void setstudent_Department(String student_Department) 
    { 
        this.student_Department = student_Department; 
    }

    public int getstudent_Age() 
    { 
        return student_Age; 
    }

    public void setstudent_Age(int student_Age) 
    { 
        this.student_Age = student_Age; 
    }

    public String[] getstudent_Passed_Lessons() 
    { 
        return student_Passed_Lessons; 
    }

    public void setstudent_Passed_Lessons(String[] student_Passed_Lessons) 
    { 
        this.student_Passed_Lessons = student_Passed_Lessons; 
    }

    public double[] getstudent_Grades() 
    { 
        return student_Grades; 
    }

    public void setstudent_Grades(double[] student_Grades) 
    {
         this.student_Grades = student_Grades; 
    }

    // Methodos gia max grade //
    public double getMaxGrade() 
    {
        double maxGrade = Double.MIN_VALUE;
        for (double grade : student_Grades) 
        {
            if (grade > maxGrade) 
            {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    // Methodos gia average grade //
    public double getAverageGrade() 
    {   
        double total_Grades = 0;
        double total = 0;
        for (double grade : student_Grades) 
        {
            total += grade;
        }
        total_Grades = total / student_Grades.length;
        return total_Grades;
    }

    // Methdos gia stoixeia foititi //
    public void show_Student_Info() 
    {
        System.out.println("Student ID: " + student_ID);
        System.out.println("Student Full Name: " + student_Full_Name);
        System.out.println("Student Department: " + student_Department);
        System.out.println("Student Age: " + student_Age);
        System.out.println("Student Passed Lessons: " + Arrays.toString(student_Passed_Lessons));
        System.out.println("Student Grades: " + Arrays.toString(student_Grades));
    }

    // Methodos gia fthinousa seira twn grade
    public void show_Passed_Lessons_Descenting() 
    {
        //Arxika ftaixnw mia temp gia na antigraosw ta arxeia twn bathmwn kai na ta xrisimopoiisw//
        double[] gradesCopy = Arrays.copyOf(student_Grades, student_Grades.length);
        Arrays.sort(gradesCopy);
        for (int i = gradesCopy.length - 1; i >= 0; i--) 
        {
            for (int j = 0; j < student_Grades.length; j++) 
            {
                if (student_Grades[j] == gradesCopy[i]) 
                {
                    System.out.println(student_Passed_Lessons[j] + " - " + student_Grades[j]);
                }
            }
        }
    }

    // Methodos gia toString
    public String toString() 
    {
        return "StudentInfo{" +
                "student_ID=" + student_ID +
                " student_Full_Name='" + student_Full_Name + '\'' +
                " student_Department='" + student_Department + '\'' +
                " student_Age=" + student_Age +
                " student_Passed_Lessons=" + Arrays.toString(student_Passed_Lessons) +
                " student_Grades=" + Arrays.toString(student_Grades) +
                '}';
    }

    public static void main(String[] args) 
    {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int num_Students = scanner.nextInt();
        StudentInfo[] students = new StudentInfo[num_Students];

        for (int i = 0; i < num_Students; i++) 
        {
            System.out.println("------------------------------------------");
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Student ID: ");
            int student_ID = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Number of passed lessons: ");
            int numLessons = scanner.nextInt();
            scanner.nextLine(); 
            String[] passedLessons = new String[numLessons];
            double[] grades = new double[numLessons];
            for (int j = 0; j < numLessons; j++) 
            {
                System.out.print("Lesson " + (j + 1) + ": ");
                passedLessons[j] = scanner.nextLine();
                System.out.print("Grade: ");
                grades[j] = scanner.nextDouble();
                scanner.nextLine(); 
            }

            students[i] = new StudentInfo(student_ID, fullName, department, age, passedLessons, grades);
        }

        //EDW YPARXOUN OI PROYPOTHESEIS KAI TAZ ZHTHMATA TWN METHODWN//
        while (true)
        {
            System.out.println("\n--------------------------------------------------\nTo see the:\nBiggest Grade of a student press 1.\nAverage Grade of a student ID press 2.\nAverage Grade of a student NAME press 3.\nAll the Passed Lessons Descending 4.\nAll Information for a student 5.\nTo Exit and Delete everything -1");
            count = scanner.nextInt();
            if (count == -1)
            {
                break;
            }
            
            else if (count == 1)
            { 
                System.out.print("\n--------------------------------------------------\nEnter the student ID: ");
                int studentID = scanner.nextInt();
                boolean found = false;
                for (int i = 0; i < num_Students; i++) 
                {
                    if (students[i].getstudent_ID() == studentID) 
                    {
                        System.out.println("Maximum Grade for Student with ID " + studentID + ": " + students[i].getMaxGrade());
                        found = true;
                        break;
                    }   
                }
                if (!found) 
                    {
                        System.out.println("Student with ID " + studentID + " not found.");
                    }
            }

            else if (count == 2)
            {    
                System.out.print("\n--------------------------------------------------\nEnterEnter student ID: ");
                int studentID = scanner.nextInt();
                boolean found = false;
                for (int i = 0; i < num_Students; i++) 
                {
                    if (students[i].getstudent_ID() == studentID) 
                    {
                        System.out.println("Average Grade for student with ID " + studentID + ": " + students[i].getAverageGrade());
                        found = true;
                        break;
                    }
                }
                if (!found) 
                {
                    System.out.println("Student with ID " + studentID + " not found.");
                }

            }

            else if(count == 3)
            {
                System.out.print("\n--------------------------------------------------\nEnter student Full Name: ");
                scanner.nextLine(); 
                String studentFullName = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < num_Students; i++) 
                {
                    if (students[i].getstudent_Full_Name().equalsIgnoreCase(studentFullName)) 
                    {
                        System.out.println("Average Grade for student with Full Name " + studentFullName + ": " + students[i].getAverageGrade());
                        found = true;
                        break;
                    }
                }
                if (!found) 
                {
                    System.out.println("Student with Full Name " + studentFullName + " not found.");
                }
            }
            

            else if (count == 4)
            {
                System.out.print("\n--------------------------------------------------\nEnter student ID: ");
                int studentID = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter student Full Name: ");
                String studentFullName = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < num_Students; i++) 
                {
                    if (students[i].getstudent_ID() == studentID && students[i].getstudent_Full_Name().equals(studentFullName)) 
                    {
                        System.out.println("Passed Lessons Descending for student with ID " + studentID + " and Full Name " + studentFullName + ":");
                        students[i].show_Passed_Lessons_Descenting();
                        found = true;
                        break;
                    }
                }
                    if (!found) 
                    {
                        System.out.println("Student with ID " + studentID + " and Full Name " + studentFullName + " not found.");
                    }
            }

            else if (count == 5)
            {
                System.out.print("\n--------------------------------------------------\nEnter student ID: ");
                int studentID = scanner.nextInt();
                scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < num_Students; i++) 
                {
                    if (students[i].getstudent_ID() == studentID) 
                    {
                        System.out.println("Student Information for ID " + studentID + ":");
                        students[i].show_Student_Info();
                        found = true;
                        break;
                    }
                }
                if (!found) 
                {
                    System.out.println("Student with ID " + studentID + " not found.");
                }
            }  

            else
            {
                System.out.println("There is not such an option");
            }   

        }
        scanner.close();
    }
}