
package linkedlist;

import java.io.IOException;
import java.util.Scanner;
/**
 * @version 1.0
 * @since 10/20/16
 * @author gnguyen34
 */
public class LinkedList {

    public static void main(String[] args) {
        
        StudentNode head;
        StudentNode tail;
        Scanner scan = new Scanner(System.in);
        
        // Creating first student in StudentNode linked list
        head = new StudentNode("George Nguyen", 1234, null);
        tail = head;
        
        // Creating second student in StudentNode linked list
        head.addNodeAfter(head);
        StudentNode jas = head.link;
        
        // creating third student in StudentNode linked list
        jas.addNodeAfter(head);
        StudentNode jil = jas.link;
        jil.addNodeAfter(head);
        StudentNode tom = jil.link;
        
        // adding an existing student
        System.out.println("Trying to add an existing student: ");
        tom.addNodeAfter(head);
        
        // Adding 3 more students in StudentNode linked list
        for (int i=1; i<=3; i++){
            tail.addIterAfter("name", i+999);
            tail = tail.getLink();
        }
        // Displaying the number of students in StudentNode linked list
        System.out.println((char)27 + "[37;44mAfter adding students to the " 
                        + "Linked List, there are " + head.getLength(head) 
                        + " students.");
        // Displaying the entire roster of students with their ID and Name
        StudentNode.printStudents(head);
        

        // Removing a single student and then displaying length linked list
        jil.removeNodeAfter();
        System.out.println((char)27 + "[37;44mAfter removing one student, " 
                            + "Tom Marvolo Riddle, there are " 
                            + head.getLength(head) + " students.");
        // Displaying the  roster of students with one student removed
        StudentNode.printStudents(head);
        
        //  Adding a single course record for George Nguyen
        head.courses.setRecord("MATH10", 4, "B");
        // Adding more courses for George Nguyen
        head.courses.addCourseAfter("CS41", 4, "A");
        head.courses.addCourseAfter("CS131", 3, "B");
        
        // Adding student course records individually for Jasmine Pak
        jas.courses.setRecord("BIO69", 4, "A");
        jas.courses.addCourseAfter("CHEM180", 3, "B");
        jas.courses.addCourseAfter("ART27", 2, "C");
        CourseNode chem180 = jas.courses.link;
        jas.courses.link.addCourseAfter("BIO199", 4, "A");
        
        // Adding student course records individually for Jil Steinmore
        jil.courses.setRecord("BUS37", 1, "B");
        jil.courses.addCourseAfter("ECON101", 4, "A");
        jil.courses.addCourseAfter("BUS100", 3, "C");
       
        
        // Printing only Jasmine Pak's student record and GPA
        System.out.println((char)27 + "[37;44mPrinting Jasmine Pak's " 
                                    + "student record and GPA: ");
        StudentNode.printRecord(jas);
        
        // Removing a single course from Jasmin Pak's course record
        System.out.println((char)27 + "[37;44mRemoving a single course, ART27, "  
                        + "from Jasmine's course record.");
        jas.courses.removeNodeAfter();
        StudentNode.printRecord(jas);
        
        
        //  Printing every student's student record and GPA
        System.out.println((char)27 + "[37;44mPrinting every student's " 
                        + "record and GPA: ");
        StudentNode.printAll(head);
        
        
        
        
    }
    
}






















