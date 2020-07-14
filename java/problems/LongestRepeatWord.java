package problems;
//3

import java.util.ArrayList;
import java.util.List;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestRepeatWord {
    public static void main(String[] args) {
        String inpStr = "abadc";
        int len = inpStr.length();
        if (len == 0) {
//            return 0;
        }
        int prvStPos = 0;
        int prvEndPos = 0;

        int stPos = -1;
        int endPos = 0;
        List<Character> uniqChars = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            endPos = i;
            char c = inpStr.charAt(i);
            if (uniqChars.contains(c)) {
                uniqChars.clear();
                if ((prvEndPos - prvStPos) < (endPos - stPos)) {
                    prvStPos = stPos;
                    prvEndPos = endPos - 1;
                }
                i = stPos;
                stPos = -1;
            } else {
                if (stPos == -1) {
                    stPos = i;
                }
                uniqChars.add(c);
            }
        }

        if ((prvEndPos - prvStPos) < (endPos - stPos)) {
            prvStPos = stPos;
            prvEndPos = endPos;
        }


        System.out.println("start : " + prvStPos + " end Pos : " + prvEndPos + "  res : " + inpStr.substring(prvStPos, prvEndPos + 1));
    }
}
