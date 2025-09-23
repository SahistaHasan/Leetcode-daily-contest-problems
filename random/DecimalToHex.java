class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder hex = new StringBuilder();
        long n = num & 0xFFFFFFFFL; // treat as unsigned 32-bit

        while (n > 0) {
            long rem = n % 16;
            char hexChar;
            if (rem < 10) hexChar = (char)('0' + rem);
            else hexChar = (char)('a' + (rem - 10));
            hex.insert(0, hexChar);
            n /= 16;
        }

        return hex.toString();
    }
}
