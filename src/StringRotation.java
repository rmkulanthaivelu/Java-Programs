public class StringRotation {

    public static void main(String[] args) {
        String s1 = "JavaJ2eeStrutsHibernate";
        String s2 = "StrutsHibernateJavaJ2ee";
        if (s1.length() != s2.length()) {
            System.out.println(false);
            return;
        }
        String temp = s1 + s1;
        boolean isRotation = temp.contains(s2);
        System.out.println(isRotation);
    }
}