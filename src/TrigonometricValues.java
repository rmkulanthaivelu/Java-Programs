public class TrigonometricValues {

    public static void main(String[] args) {

        double degree = 30;

        // Convert degree to radians
        double radian = Math.toRadians(degree);

        double sin = Math.sin(radian);
        double cos = Math.cos(radian);
        double tan = Math.tan(radian);

        double sec = 1 / cos;
        double cosec = 1 / sin;
        double cot = 1 / tan;

        System.out.println("sin(" + degree + ") = " + sin);
        System.out.println("cos(" + degree + ") = " + cos);
        System.out.println("tan(" + degree + ") = " + tan);
        System.out.println("sec(" + degree + ") = " + sec);
        System.out.println("cosec(" + degree + ") = " + cosec);
        System.out.println("cot(" + degree + ") = " + cot);
    }
}