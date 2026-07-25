public class StringPermutations {

    public static void main(String[] args) {
        String str = "JSP";
        permuation(str,"");
    }
    public static void permuation(String str,String ans){
        if(str.length() ==0) {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char chr = str.charAt(i);
           String remaining = str.substring(0,i)+str.substring(i+1);
            //System.out.println(remaining);
            permuation(remaining,ans+chr);
        }
    }

}