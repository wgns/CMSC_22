/*
 * A Test Driver for the Date class.
 */
public class TestDate {
   public static void main(String[] args) {
      // Test constructor and toString()
      Date d1 = new Date(2016, 12, 25);
      System.out.println(d1);  // toString()
 
      // Test Setters and Getters
      d1.setYear(2012);
      d1.setMonth(9);
      d1.setDay(30);
      System.out.println(d1);  // run toString() to inspect the modified instance
      System.out.println("Year is: " + d1.getYear());
      System.out.println("Month is: " + d1.getMonth());
      System.out.println("Day is: " + d1.getDay());
 
      // Test setDate()
      d1.setDate(2012, 2, 29);
      System.out.println(d1);  // toString()
   }
}