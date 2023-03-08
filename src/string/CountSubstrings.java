package string;

class CountSubstrings {
    public int countSubstrings(String s) {
        int retCount = 0;
        int start, end;
        for (start = 0; start < s.length(); start++) {
            for (end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    retCount++;
                }
            }
        }

        return retCount;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}