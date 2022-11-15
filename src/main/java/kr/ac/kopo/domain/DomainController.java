package kr.ac.kopo.domain;

import kr.ac.kopo.Vo.Domain;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.util.SysoutTester;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/domain")
public class DomainController {
    SysoutTester tester = new SysoutTester();
    final DomainService service;

    public DomainController(DomainService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public String list(Model model, Pager pager) {
        List<Domain> list = service.list(pager);
        model.addAttribute("list", list);

        return "domain/list";
    }

    @GetMapping("/add")
    public String add() {

        return "domain/add";
    }

    @PostMapping("/add")
    public String add(Domain domain) {
        service.add(domain);
        tester.test(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), domain.getName());
        return "redirect:/domain/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Domain item = service.item(id);
        model.addAttribute("item", item);

        tester.test(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), item.getName());
        return "domain/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, Domain domain) {
        domain.setId(id);
        service.update(domain);

        return "redirect:/domain/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);

        tester.test(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), id + "번 째 도메인");
        return "redirect:/domain/list";
    }
}
