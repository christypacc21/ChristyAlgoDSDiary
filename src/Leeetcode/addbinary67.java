package Leeetcode;

//https://leetcode.com/problems/add-binary/

public class addbinary67 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int remainder = 0; //wht means by remainder->the 進位的數. eg this digit is 1+1 = 2, then sb.append(0), remainder is 1.
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            i--;
            j--;
            sb.append(sum % 2);
            remainder = sum / 2;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("10", "1011"));
    }
}

//time o(n)
//space o(n)
