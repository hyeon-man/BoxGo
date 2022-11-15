package kr.ac.kopo.util;

public class SysoutTester {


    /**
     * String형 테스트
     *
     * @param var
     * @param className
     */
    public void test(String className, String method, String var) {
        System.out.println("<!--              -->");
        System.out.println(className + " 클래스의 ");
        System.out.println(method + "메소드");
        System.out.println("변수 값 :" + var);
        System.out.println("<!--              -->");

    }

    /**
     * boolean형 테스트
     *
     * @param className
     * @param test
     */
    public void booleanTest(String className, Boolean test) {
        System.out.println("<-- " + "호출된 클래스명:" + className + "/ 변수 값 :" + test + "-->");
    }
}
