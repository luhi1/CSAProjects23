import java.nio.file.Path;

public class Course {
    private String name;
    private String teacherName;
    private Path gradebook;

    public Course(String name, Path gradebook) {
        this.name = name;
        this.gradebook = gradebook;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Path getGradebook() {
        return gradebook;
    }

    public void setGradebook(Path gradebook) {
        this.gradebook = gradebook;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
