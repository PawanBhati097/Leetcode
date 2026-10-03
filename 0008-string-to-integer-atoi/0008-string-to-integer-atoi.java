class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Determine sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits (with overflow clamping)
        int result = 0;
        int MAX = Integer.MAX_VALUE;  // 2147483647
        int MIN = Integer.MIN_VALUE;  // -2147483648

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check overflow BEFORE multiplying
            if (result > (MAX - digit) / 10) {
                return (sign == 1) ? MAX : MIN;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }
}