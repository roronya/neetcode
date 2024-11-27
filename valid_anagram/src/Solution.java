public class Solution {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
    for (Character ch: s.toCharArray()) {
      map.merge(ch, 1, Integer::sum);
    }
    // System.out.println(map.toString());
    for (Character ch: t.toCharArray()) {
      Integer count = map.get(ch);
      if (count == null || count == 0) {
        return false;
      }
      map.put(ch, count - 1);
    }
    return true;
  }
}
