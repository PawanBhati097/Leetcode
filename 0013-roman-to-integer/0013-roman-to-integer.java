class Solution {
    public int romanToInt(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            
            if (i + 1 < s.length()) {
                int next = getValue(s.charAt(i + 1));
                if (current < next) {
                    result = result - current;
                } else {
                    result = result + current;
                }
            } else {
                result = result + current;
            }
        }
        
        return result;
    }
    
    public int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}