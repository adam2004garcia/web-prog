package p1;


public class Course {
   private int id;
   private int userId;
   private String courseCode;
   private String courseTitle;
   private String semester;
   private String description;

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCourseCode() {
        return courseCode;
    }
    
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
    
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
