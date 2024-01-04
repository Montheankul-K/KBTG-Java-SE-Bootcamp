public class Scope {

    public static void main(String[] args) {
        float global = 7.5f;

        {
            float local = 7.5f;
            System.out.println("local: " + local);
            System.out.println("inside global: " + global);
        }

        System.out.println("global: " + global);
    }
}
