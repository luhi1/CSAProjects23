public class Assignments {

    private String assignmentType;
    private String assignmentName;
    public Assignments(String assignmentType, String assignmentName) {
        this.assignmentType = assignmentType;
        this.assignmentName = assignmentName;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }
}
