
package linkedlist;


/**
 * version 1.0
 * since 10/20/16
 * @author gnguyen34
 */
public class CourseNode {
    
    protected String courseName;      // name of course
    protected int courseUnit;         // number of course units
    protected String courseGrade;     // grade earned in course
    protected CourseNode link;        // link to the next node
    
    
// CONSTRUCTORS **************************************************************
    
    /**
     * Creates a new CourseNode containing course name, unit, grade, 
     *      and link to next node
     * @param newName This node's courseName
     * @param newUnit This node's courseUnits
     * @param newGrade This node's courseGrade
     * @param newLink The link to the next CourseNode after this node
     */
    public CourseNode(String newName, int newUnit, 
                        String newGrade, CourseNode newLink){
        courseName = newName;
        courseUnit = newUnit;
        courseGrade = newGrade;
        link = newLink;
    }
    
    /**
     * default constructor for course node
     */
    public CourseNode(){
        courseName = "Course Name";
        courseUnit = 0;
        courseGrade = "N/A";
        link = null;
    }
    
    
// ACCESSOR METHODS **********************************************************
    /**
     * @return Course name
     */
    public String getName(){
        return courseName;
    }
    /**
     * @return Course units
     */
    public int getUnit(){
        return courseUnit;
    }
    /**
     * @return Course grade
     */
    public String getGrade(){
        return courseGrade;
    }
    /**
     * @return Link to node after this node
     */
    public CourseNode getLink(){
        return link;
    }




    
// MODIFIER METHODS *********************************************************
    /**
     * Sets the courseName to name
     * @param name Value of new courseName
     * postcondition courseName is set to name
     */
    public void setName(String name){
        courseName = name;
    }
    /**
     * Sets the courseUnit to unit
     * @param unit Value of new courseUnit
     * @postcondition courseUnit is set to unit
     */    
    public void setUnit(int unit){
        courseUnit = unit;
    }
    /**
     * Sets the courseGrade to grade
     * @param grade Value of new courseGrade
     * @postcondition courseGrade is set to grade
     */    
    public void setGrade(String grade){
        courseGrade = grade;
    }
    /**
     * Sets the link to newLink
     * @param newLink Value of new link
     * @postcondition link is set to newLink
     */
    public void setLink(CourseNode newLink){
        link = newLink;
    }
    /**
     * Sets a single course record
     * @param name New courseName
     * @param unit New courseUnit
     * @param grade New courseGrade
     * @postcondition 
     *      courseName is set to name, courseUnit is set to unit,
     *      courseGrade is set to grade
     */
    public void setRecord(String name, int unit, String grade){
        courseName = name;
        courseUnit = unit;
        courseGrade = grade;   
    }
    /**
     * Adds a CourseNode after this node
     * @param newName courseName of new node
     * @param newUnit courseUnit of new node
     * @param newGrade courseGrade of new node
     * @postcondition 
     *      A new CourseNode is created after this node with
     *      courseName of newName, courseUnit of newUnit, and courseGrade
     *      of newGrade if an identical course doesn't already exist.
     */
    public void addCourseAfter(String newName, int newUnit, String newGrade){
        CourseNode cursor;
        for (cursor = new CourseNode(); cursor != null; cursor = cursor.link){
            if (newName != this.courseName){
                link = new CourseNode(newName, newUnit, newGrade, link);
                break;
            }
            else System.out.println((char)27 
                    + "[37;44m This course already exists" + (char)27 + "[0m");
        }
        
    }
    /**
     * Removes the node after this node
     * @postcondition 
     *      The node after this node is removed and all nodes after the removed
     *      node are now after this node
     */
    public void removeNodeAfter(){
        link = link.link;
    }
    
    
// OTHER METHODS ***********************************************************
    /**
     * @return This node's courseName, courseUnit, and courseGrade as string 
     */
    public String toString(){
        return "\n\tCourse Name: " + courseName
                + "\n\tUnits: " + courseUnit
                + "\n\tGrade: " + courseGrade;
    }
    /**
     * Displays all courses in this CourseNode linked list
     * Displays all nodes' courseName, courseUnit, and courseGrade
     * @param head First node of CourseNode Linked List to print
     */
    public static void printCourse(CourseNode head){
        CourseNode cursor;
        
        for(cursor = head; cursor != null; cursor = cursor.link){
            System.out.println(cursor.toString());
        }
    }   
    
    /**
     * Converts a courseGrade to an int value for GPA calculation
     * @param grade courseGrade to convert
     * @return Corresponding int value of grade if grade received, otherwise -1
     */
    public static int intGrade(String grade){
        switch(grade){
            case "A": return 4;
            case "B": return 3;
            case "C": return 2;
            case "D": return 1;
            case "F": return 0;
        }
        return -1;
    }
    
    /**
     * Calculates a given student's GPA based off their grades
     * @param head First node of CourseNode linked list to calculate
     * @return A GPA from 0-4 if student has taken courses, otherwise -1
     */
    public static float getGPA(CourseNode head){
        CourseNode cursor;
        int totalUnits = 0;
        int qualityPoints = 0;
        
        for(cursor = head; cursor != null; cursor = cursor.link){
            qualityPoints += intGrade(cursor.courseGrade) * (cursor.courseUnit);
            totalUnits += cursor.courseUnit;
        }
        
        if (totalUnits == 0){totalUnits = 1;}
        if (qualityPoints == 0){qualityPoints = -1;}
        return (float)qualityPoints/(float)totalUnits;
    }
    
    
}
















