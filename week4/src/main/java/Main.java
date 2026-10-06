public class Main {
    static void myFun(String a, Object b) {
        System.out.println(a);
    }

    static void myFun(Object a, String b) {
        System.out.println(b);
    }

    static void myFunB(Integer a) {
        System.out.println(a);
    }

    static void myFunB(String b) {
        System.out.println(b);
    }

    public static void main(String[] args) {
        myFun((String)"hello", (Object)"goodbye");
        myFunB((Integer)null);
        myFunB(2);
    }


}
