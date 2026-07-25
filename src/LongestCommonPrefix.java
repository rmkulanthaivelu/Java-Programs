public class LongestCommonPrefix {
    /**
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    public static void main(String args[]){
        String[] strs = {"flower","flow","fligh"};
        System.out.println(commonPrefix(strs));
        String[] strs1 = {"dog","racecar","car"};
        System.out.println(commonPrefix(strs1));
    }
    public static String commonPrefix(String[] strs){
        String strResult = "";
            boolean occuring = false;
            for (int j = 0; j < strs[0].length(); j++) {
                char c = strs[0].charAt(j);
                occuring = false;
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].indexOf(c) != -1) {
                        occuring = true;
                    }else{
                        occuring = false;
                    }
                }
                if(occuring)
                    strResult = strResult + c;
            }
       return strResult;
    }
}
