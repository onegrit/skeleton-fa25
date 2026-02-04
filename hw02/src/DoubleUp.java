public class DoubleUp {
   /**
    * Returns a new string where each character of the given string is repeated
    * twice.
    * Example: doubleUp("hello") -> "hheelllloo"
    */
   public static String doubleUp(String s) {
      // TODO: Fill in this function
      int len = s.length();
      String newString = "";
      for (int i = 0; i < len; ++i) {
         for (int j = 0; j < 2; ++j) {
            newString += s.charAt(i);
         }
      }
      return newString;
   }

   public static void main(String[] args) {
      String s = doubleUp("hello");
      System.out.println(s);

      System.out.println(doubleUp("cat"));
   }
}