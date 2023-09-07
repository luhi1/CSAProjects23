import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static final String gradebookPath = System.getenv("GRADEBOOKLOCATION");
    public static void main(String[] args) throws Exception
    {
        Gradebook myGradebook = new Gradebook();
        Scanner in = new Scanner(System.in);
        String teacherInput = "";
        do {
            Main.clearScreen();
            System.out.println(myGradebook);
            System.out.print("Do you want to add a [s]tudent, [r]emove a student, or change a [g]rade? Maybe you want to [q]uit? ");
            teacherInput = in.nextLine();
            try{
                if (teacherInput.equals("s")) {
                    System.out.print("What's the student's student number? ");
                    int sNumber = Integer.parseInt(in.nextLine());
                    System.out.print("What's the name of the student? ");
                    String sName = in.nextLine();
                    System.out.print("What's the grade level of the student? ");
                    int sGradeLevel = in.nextInt();
                    System.out.print("What's the grade you want to give them? ");
                    double sGradePercentage = in.nextDouble();
                    System.out.println(myGradebook.createStudent(sNumber, sName, sGradeLevel, sGradePercentage));
                } else if (teacherInput.equals("g")) {
                    System.out.print("What's the name of the student? ");
                    String sName = in.nextLine();
                    System.out.print("What's the grade you want to give them? ");
                    double sGradePercentage = in.nextDouble();
                    System.out.println(myGradebook.changeStudentGrade(sName, sGradePercentage));
                } else if (teacherInput.equals("r")) {
                    System.out.print("What's the name of the student? ");
                    String sName = in.nextLine();
                    System.out.println(myGradebook.deleteStudent(sName));
                } else if (teacherInput.equals("q")) {
                    return;
                }
            } catch (Exception e) {
                for (int i = 0; i < 1000000; i++) {
                    System.out.println("Invalid input of some kind.");
                }
            }
        } while (!teacherInput.equals("q"));
        in.close();

    }

    public static void clearScreen(){
        //System.out.print("\033[H\033[2J");
        //The above code is efficient and simple, but the IDE doesn't display it!
        for (int i = 0; i < 1000; i++){
            System.out.println("\n");
        }
        System.out.flush();
    }
}  