import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.Source;

class Solution {
  public static char mostFrequentChar(String s) {

    HashMap<Character, Integer> letterCount = new HashMap<>();

    int max = 0;

    for (Character letter : s.toCharArray()) {
      if (letterCount.containsKey(letter)) {
        letterCount.put(letter, letterCount.get(letter) + 1);
      }
      letterCount.putIfAbsent(letter, 1);

      max = letterCount.get(letter) > max ? max = letterCount.get(letter) : max;
    }

    ArrayList<Character> letterTie = new ArrayList<Character>();
    int trueMax = max;

    // Check for ties
    letterCount.forEach((key, value) -> {
      // if multiple letters occur same num of times
      if (value == trueMax) {
        letterTie.add(key);
      }
    });

    int smallestIndex = s.length();

    for (Character character : letterTie) {

      int currentLetterIndex = s.indexOf(character.toString());

      smallestIndex = (currentLetterIndex < smallestIndex) ? smallestIndex = currentLetterIndex : smallestIndex;
    }

    return s.toCharArray()[smallestIndex];
  }

  public static void main(String[] args) {
    // Try out your test cases:
    System.out.println(Solution.mostFrequentChar("bookeeper")); // -> 'e'
    System.out.println(Solution.mostFrequentChar("david")); // -> 'd'
    System.out.println(Solution.mostFrequentChar("mississippi")); // -> 'i'
    System.out.println(Solution.mostFrequentChar("eleventennine")); // -> 'e'
  }

}
