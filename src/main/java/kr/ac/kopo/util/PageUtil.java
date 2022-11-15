package kr.ac.kopo.util;
import javax.servlet.http.HttpServletRequest;

public class PageUtil {
    final  SysoutTester tester = new SysoutTester();
     public String prevPage (HttpServletRequest request){
        String prevPage = request.getHeader("referer");
        return prevPage;
    }
}
