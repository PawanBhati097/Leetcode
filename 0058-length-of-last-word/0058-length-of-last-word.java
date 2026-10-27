class Solution {
    public int lengthOfLastWord(String s) {
        // Split the string by one or more whitespace characters
        String[] words = s.split("\\s+");
        
        // The last word will be at the last index of the array
        return words[words.length - 1].length();
    }
}