public class Main {
    public static void main(String[] args) {
        Loan loan = new Loan("loan");
        loan.show();
        Loan.info();
        // สามารถเรียก static method จากชื่อ class ได้เลย
        System.out.println();

        Main main = new Main();
        main.infoMain();
        // static method จะไม่สามารถเรียก non-static method ลอยๆได้ ต้อง new class ก่อน
        System.out.println();

        infoMainStatic();
        // static method เรียกใน static method ได้เลย
    }

    public void infoMain() {
        System.out.println("Main:: info()");
    }

    public static void infoMainStatic() {
        System.out.println("Main:: static info()");
    }
}
