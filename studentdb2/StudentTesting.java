import java.util.*;
import java.io.*;

/**
 * Modified by Wina Gen Sotto on November 3, 2016.
 */

public class StudentTesting {

   private static final String FILE_NAME = "C:\\temp\\StudentDatabase.ser";

   public static void main(String[] args) {
      List<Student> studentList = new ArrayList<>();
      int choice;
      boolean hasSaved = false;

      FileOutputStream fos = null;
      ObjectOutputStream oos = null;
      FileInputStream fis = null;
      ObjectInputStream ois = null;

      try {
         // deserialize
         fis = new FileInputStream(FILE_NAME);
         ois = new ObjectInputStream(fis);

         if (ois.read() == -1) {
            studentList = (List<Student>) ois.readObject();
         }

         ois.close();
      } catch (IOException e) {
         // standard file handling exception
         e.printStackTrace();
      } catch (ClassNotFoundException ce) {
         // this might be thrown by ois.readObject()
         ce.printStackTrace();
      } finally {
         try {
            fis.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      do {
         boolean hasDeleted = false;
         boolean hasFound = false;

         System.out.println("Menu: \n" +
             " 1. Register information \n" +
             " 2. Retrieve information \n" +
             " 3. Delete information \n" +
             " 4. Save information profile \n" +
             " 5. Exit");
         Scanner sc = new Scanner(System.in);
         choice = sc.nextInt();
         sc.nextLine();

         switch (choice) {
            case 1: // Register information
               System.out.print("Student Number: ");
               String studentNumber = sc.nextLine();
               checker(studentNumber, studentList);
               System.out.print("First Name: ");
               String firstName = sc.nextLine();
               System.out.print("Middle Initial: ");
               char middleInitial = sc.nextLine().charAt(0);
               System.out.print("Last Name: ");
               String lastName = sc.nextLine();
               System.out.print("Course: ");
               String course = sc.nextLine();
               System.out.print("Year Level: ");
               int yearLevel = Integer.parseInt(sc.nextLine());
               System.out.print("Name of your crush: ");
               String crushName = sc.nextLine();
               System.out.print("Favorite Subject:\n\tCourse Code: ");
               String courseCode = sc.nextLine();
               System.out.print("\tCourse Description: ");
               String courseDescription = sc.nextLine();

               studentList.add(new Student(studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, new Course(courseCode, courseDescription)));
               System.out.println("Student added!\n");
               hasSaved = false;
               break;
            case 2: // Retrieve information
               System.out.print("Search Student Number: ");
               String toFind = sc.next();

               for(Student stud : studentList) {
                  if (stud.getStudentNumber().equals(toFind)) {
                     System.out.println(stud);
                     hasFound = true;
                     break;
                  }
               }

               if (!(hasFound)) {
                  System.out.println("Student " + toFind + " is not in the roster.\n");
               }

               break;
            case 3: // Delete information
               System.out.print("Delete Student Number: ");
               String tempStudentNumber = sc.next();

               for(Student stu : studentList){
                  if (stu.getStudentNumber().equals(tempStudentNumber)) {
                     studentList.remove(stu);
                     System.out.println("Student deleted!\n");
                     hasDeleted = true;
                     hasSaved = false;
                     break;
                  }
               }

               if (!(hasDeleted)) {
                  System.out.println("Error! " + tempStudentNumber + " is not in the database.\n");
               }
               break;
            case 4: // Save information profile
               try { // serialize
                  fos = new FileOutputStream(FILE_NAME);
                  oos = new ObjectOutputStream(fos);

                  oos.writeObject(studentList);
                  oos.close();
               } catch (IOException e) {
                  // standard file handling exception
                  e.printStackTrace();
               } finally {
                  try {
                     fos.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
               }

               System.out.println("Student profile saved!\n");
               hasSaved = true;
               break;
            case 5:
               int willSave = 1;

               if (!(hasSaved || studentList.isEmpty())) {
                  System.out.println("Warning! You have not saved your profile/s. Do you still wish to exit? \n" +
                      " 1. Yes \n" +
                      " 2. No");
                  willSave = sc.nextInt();
               }

               if (willSave == 2){
                  break;
               } else {
                  System.out.println("Thank you for using our software!");
               }
               break;
            default:
               throw new IllegalArgumentException("Invalid input!");
         }
      } while (choice != 5);
   }

   private static void checker(String studentNumber, List<Student> studentList) {
      for(Student s : studentList){
         if (s.getStudentNumber().equals(studentNumber)) {
            throw new IllegalArgumentException("Student Number already exists in list.");
         }
      }
   }
}
