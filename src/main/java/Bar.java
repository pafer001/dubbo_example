public class Bar {

    int a =1;
    static int b =2;

    public int Sum(int c) {
        return a + b +c;
    }

    public static void main(String[] args) {

        while (true) {
            new Bar().Sum(3);

            try {

                Thread.sleep(100);
            }catch (Exception e) {

            }
        }
    }

}
