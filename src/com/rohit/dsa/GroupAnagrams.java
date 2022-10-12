package com.rohit.dsa;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class GroupAnagrams {
    public static void main(String[] s) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("For Input String -> " + Arrays.toString(strs));
        System.out.println("Group Anagrams -> " + groupAnagrams(strs));
    }

    // Time Complexity - O(m*n)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();

        Map<String, List<String>> groupMap = new HashMap<>();
        for (String s : strs) {
            char[] charArr = new char[26];
            for (char c : s.toCharArray()) {
                charArr[c-'a']++;
            }
            String key = String.valueOf(charArr);
            groupMap.computeIfAbsent(key, k -> new ArrayList<>());
            groupMap.get(key).add(s);
        }
        groupedAnagrams.addAll(groupMap.values());

        return groupedAnagrams;
    }
}
