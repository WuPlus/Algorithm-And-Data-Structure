/*
 * leetcode 28 原题
 */
package Company.PocketGems;

/**
 *
 * @author Wu
 */
public class StrStr {
    
    static int strStr(String haystack, String needle){
        int h_length = haystack.length();
        for(int i = 0;;i++){
            for(int j = 0;;j++){
                if(j == needle.length()) return i;
                if(i + j == h_length) return -1;
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }
    }
    
    static int strStrWithEquals(String haystack, String needle){
        int h_length = haystack.length();
        int n_length = needle.length();
        for (int i = 0; i <= h_length - n_length; i++) {
            if(haystack.substring(i,i+n_length).equals(needle))
                return i;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int i = StrStr.strStr("henull", "null");
        int j = StrStr.strStrWithEquals("henull", "null");
        System.out.println("hello".substring(1,2));
        System.out.println(i + "" + j);
    }
}
