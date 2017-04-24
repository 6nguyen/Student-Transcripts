
package linkedlist;

import java.util.Scanner;

/**
 * @version 1.0
 * @since 10/20/16
 * @author gnguyen34
 */
public class StudentNode {
    
    private String studentName;       // name of student to store in node
    private int studentID;             // student ID to store in node
    protected CourseNode courses;    // linked list of course info
    protected StudentNode link;      // reference to next node in list
    
    Scanner scan = new Scanner(System.in);

//CONSTRUCTORS *********************************************************

    /**
    * constructor creates a StringNode with string and int nodes
    * @param newString initial string element
    * @param newInt initial int element
    * @param newLink reference to next node
    */
    public StudentNode(String newString, int newInt, StudentNode newLink){
        studentName = newString;
        studentID = newInt;
        courses = new CourseNode();
        link = newLink;    
    }
    /**
    * default constructor creates a Linked List with "", 0, null
    */
    public StudentNode(){
        studentName = "name";
        studentID = 0000;
        link = null;
    }


// ACCESSOR METHODS *****************************************************
    /**
    * Accessor method to get String data from node
    * @return studentName
    */
    public String getName(){
        return studentName;
    }

    /**
    * Accessor method to get int data from node
    * @return studentID
    */
    public int getID(){
        return studentID;
    }

    /**
    * Accessor method to get link to next node
    * @return reference to next node, or null if there is nothing after
    */
    public StudentNode getLink(){
        return link;
    }

    /**
    * Returns the number nodes in this Linked List
    * @param head The head node of this Linked List
    * @return The number of nodes in this Linked List
    */
    public static int getLength(StudentNode head){
        int length = 0;
        StudentNode counter;
        for(counter = head; counter != null; counter = counter.getLink()){
            length++;
        }
        return length;
    }

    /**
    * Searches the linked list for a student's ID
    * @param head The head of the Linked List to search
    * @param target The target element to search for
    * @return The node of the target element if found, otherwise null
    */
    public static StudentNode IDSearch(StudentNode head, int target){
        StudentNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link){
            if (target == cursor.studentID){
            return cursor;
            }
        }
        return null;
    }


    /**
    * Searches the linked list for a student's name
    * @param head The head of the Linked List to search
    * @param target The target element to search for
    * @return The node of the target element if found, otherwise null
    */
    public static StudentNode nameSearch(StudentNode head, String target){
        StudentNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link){
            if (cursor.studentName == target){
            return cursor;
            }
        }
        return null;
    }

    /**
    * Searches the Linked List for a node by its specified position
    * @param head The head of the Linked List to search
    * @param position The position of the node to search for
    * @return A reference to the node at the specified position
    */
    public static StudentNode posSearch(StudentNode head, int position){
        StudentNode cursor;
        int i;
        
        if (position <= 0){
            throw new IllegalArgumentException("Position is not positive.");
        }
        
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++){
            cursor = cursor.link;
        }
        return cursor;
    }




// MODIFIER METHODS *****************************************************
    /**
    * Modification method to set the String data in this node
    * @param newString New string to place in this node
    * @postcondition
    *      The data in this node has been set to newString
    */
    public void setName(String newString){
        studentName = newString;
    }

    /**
    * Modification method to set the int data in this node
    * @param newInt New int to place in this node
    * @postcondition
    *      The data in this node has been set to newInt
    */
    public void setID(int newInt){
        studentID = newInt;
    }

    /**
    * Modification method to set the reference to the next node after this node
    * @param newLink a reference to the next node, or null if none
    * @postcondition
    *      The link to the node after this has been set to newLink.
    *      Any other node (that used to be in this link) is no longer connected
    *      to this node.
    */
    public void setLink(StudentNode newLink){
        link = newLink;
    }

    /**
    * adds node after this node
    * @param sData String data to add into new node
    * @param iData int Data to add into new node
    * @postcondition
    *      A new node has been created after this node.  Any other nodes that
    *      used to be after this node are now after the new node.
    */
    public void addNodeAfter(StudentNode head){
        System.out.println("Enter the student's name:");
        String sData = scan.nextLine();
        System.out.println("Enter the student's ID:");
        int iData = scan.nextInt();
        boolean unique = true;
        StudentNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link){
            if (cursor.studentID == iData){
                System.out.println((char)27+ "[37;44mThis student ID already exists."
                                + (char)27 + "[0m\n");
                unique = false;
            }
        }
        if (unique){
            link = new StudentNode(sData, iData, link); 
            System.out.println("\nThe following student has been added."
                            + "\n\tStudent Name: " + sData
                            + "\n\tStudent ID: " + iData);
            System.out.println();
        }
    }
    /**
     * Adds nodes after this node when using iteration
     * @param name  New name
     * @param ID New studentID
     */
    public void addIterAfter(String name, int ID){
        link = new StudentNode(name, ID, link);
    }
    
    /**
     * adds a default constructor StudentNode after this node
     */
    public void addNodeAfter(){
        link = new StudentNode();
    }

    /**
    * removes node after this node
    */
    public void removeNodeAfter(){
        link = link.link;
    }


    /**]
     * Makes a complete copy of this Linked List
     * @param source Linked List to make copy of
     * @return A new Linked List with the same elements as this list
     */
    public static StudentNode copyList(StudentNode source){
        if (source == null)
            return null;

        StudentNode copyHead = 
                new StudentNode(source.studentName, source.studentID, null);
        StudentNode copyTail = copyHead;

        while(source.link != null){
            source = source.link;
            copyTail.addIterAfter(source.studentName, source.studentID);
            copyTail = copyTail.link;
        }
        return copyHead;
    }



// OTHER METHODS ************************************************************
    /**
     * @return Function returns a student's ID and name in string format
     */
    public String toString(){
        return "StudentID: " + studentID 
                + "\nStudent Name: " + studentName;
    }

    /**
     * Prints entire list of Students, displaying studentID and student name
     * @param head The head node of the linked list to print
     */
    public static void printStudents(StudentNode head){
        StudentNode cursor;
        
        for(cursor = head; cursor != null; cursor = cursor.link){
            System.out.println(cursor.toString() + "\n");
        }
    }    
    
    /**
     * Prints a student's record
     * Displays studentID, name, and all course names, course units, and 
     *      course grades
     * @param source Student node to print
     */
    public static void printRecord(StudentNode source){
        System.out.println(source.toString());
        if (CourseNode.getGPA(source.courses) == -1) {
            System.out.println("\tGPA: N/A");
        } else {
            System.out.printf("\tGPA: %.2f\n", CourseNode.getGPA(source.courses)); 
        }
        CourseNode.printCourse(source.courses);
        System.out.println();
    }
    
    
    /**
     * Print every student's record
     * Displays studentID, name, and all course names, units, and grades 
     *      for every student
     * @param head Head node of list to print
     */
    public static void printAll(StudentNode head){
        StudentNode cursor;
        
        for (cursor = head; cursor != null; cursor = cursor.link){
            printRecord(cursor);
        }
    }    

// EXPERIMENTAL ************************************************************
    
    public boolean equals(Object obj){
        if (obj instanceof StudentNode){
            StudentNode candidate = (StudentNode)obj;
            return (candidate.studentID == studentID) 
                    && (candidate.studentName == studentName);
        }
        else return false;
    }
    
    public boolean isUnique(StudentNode head){
        StudentNode cursor1 = null, cursor2, duplicate;
        cursor2 = cursor1;
        duplicate = cursor1;
        
        for (cursor1 = head; cursor1 != null; cursor1 = cursor1.link){
            cursor2 = cursor1;
            
            while (cursor2 != null){
                if (cursor1.studentID == cursor2.studentID
                        && cursor1.studentName == cursor2.studentName) {
                    return false;
                }
            }
        }
        return true;
    }

    
}






























