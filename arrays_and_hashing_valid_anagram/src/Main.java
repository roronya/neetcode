public class Main {
    public static void main(String[] args) {
      Solution solution = new Solution();

      String s1 = "racecar", t1 = "carrace";
      boolean result = solution.isAnagram(s1, t1);
      System.out.println(result); // true
      String s2 = "jar", t2 = "jam";
      result = solution.isAnagram(s2, t2);
      System.out.println(result); // false
      String s3 = "bbcc", t3 = "ccbc";
      result = solution.isAnagram(s3, t3);
      System.out.println(result); // false
    }
}
