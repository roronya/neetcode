package neetcode.arrays_and_hashing.encode_and_decode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            res.append(str).append("あ");
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == 'あ') {
                res.add(s.toString());
                s = new StringBuilder();
            } else {
                s.append(str.charAt(i));
            }
        }
        return res;
    }
}

