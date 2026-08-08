class Solution {
    // Map digits to corresponding letters on a phone keypad
    private static final String[] key = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> ll = new ArrayList<>();
        // Edge case: if digits is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return ll;
        }
        KeyPaid(digits, "", ll);
        return ll;
    }
    
    public void KeyPaid(String ques, String ans, List<String> ll) {
        if (ques.length() == 0) {
            ll.add(ans);
            return;
        }
        char ch = ques.charAt(0); // '2'
        String press = key[ch - '0'];
        for (int i = 0; i < press.length(); i++) {
            KeyPaid(ques.substring(1), ans + press.charAt(i), ll);
        }
    }
}