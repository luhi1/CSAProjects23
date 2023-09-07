import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gradebook {
    private ArrayList<String[]> gradebook = new ArrayList<String[]>();

    public Gradebook() throws FileNotFoundException {
        acquireGradebook();
    }

    public void acquireGradebook() throws FileNotFoundException {
        //Get Gradebook from CSV and populate it into an ArrayList
        this.gradebook = new ArrayList<String[]>();
        Scanner in = new Scanner(new File(Main.gradebookPath));
        while (in.hasNextLine()){
            String[] student = new String[4];
            in.useDelimiter(",");
            for (int i = 0; i < 4; i++) {
                String nextStat = in.next();
                if (nextStat.isEmpty()){
                    break;
                }
                student[i] = nextStat;
            }
            gradebook.add(student);
            in.nextLine();
        }
        in.close();
        System.out.println("TEACHER ACQUIRED THE GRADEBOOOOK!!!!!!!!!!!!!!!!!!!");
    }

    public String update() throws IOException {
        String newGradebook = "";
        for (String[] currentStudent: gradebook){
            for (int i = 0; i < currentStudent.length; i++){
                newGradebook += currentStudent[i]+",";
            }
            newGradebook+="\r\n";
        }

        FileWriter myWriter = new FileWriter(Main.gradebookPath, false);
        myWriter.write(newGradebook);
        myWriter.close();
        return this.toString();
    }

    public String toString(){
        String gradebookString = "";
        for (String[] currentStudent: gradebook){
            gradebookString += Arrays.toString(currentStudent) +"\n";
        }
        return gradebookString;
    }

    public String createStudent(int studentNumber, String studentName, int studentGradeLevel, double studentGradePercentage) throws IOException {
        if (findStudentIndex(studentName) != -1){
            return "A student with this name already exists.\n"+toString();
        }
        FileWriter myWriter = new FileWriter(Main.gradebookPath, true);
        myWriter.write(studentNumber+","+studentName+","+studentGradeLevel+","+studentGradePercentage+",\r\n");
        myWriter.close();
        this.acquireGradebook();
        return this.toString();
    }

    public String deleteStudent(String studentName) throws IOException {
        int studentIndex = findStudentIndex(studentName);
        if (findStudentIndex(studentName) == -1){
            return "Student not found.\n"+toString();
        }
        gradebook.remove(studentIndex);
        this.update();
        this.acquireGradebook();
        return "Student deleted";
    }

    public String changeStudentGrade(String studentName, double newGradePercentage) throws IOException {
        int index = findStudentIndex(studentName);
        if (index == -1){
            return "Student not found; no changes made.";
        }

        gradebook.get(index)[3] = Double.toString(newGradePercentage);
        this.update();
        this.acquireGradebook();
        return "Student found and grade changed.";

    }

    //Yes, I know that student number is a better primary key. I'm sorry Mr. Davisson.
    public int findStudentIndex(String studentName){
        for (int i = 0; i < gradebook.size(); i++){
            if (gradebook.get(i)[1].equals(studentName)){
                return i;
            }
        }
        return -1;
    }

}
