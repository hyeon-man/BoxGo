package kr.ac.kopo.root;

import kr.ac.kopo.util.SysoutTester;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RootController {
	SysoutTester tester = new SysoutTester();

	@RequestMapping("/")
	public String home() {

		return "index";
	}
	
}
