package kr.ac.kopo.keywords;

import kr.ac.kopo.Vo.Domain;
import kr.ac.kopo.Vo.Keywords;
import kr.ac.kopo.domain.DomainService;
import kr.ac.kopo.util.KeywordsPager;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.util.SysoutTester;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/keywords/{domainId}")
@Controller
public class KeywordsController {
    SysoutTester tester = new SysoutTester();
    final KeywordsService service;
    final DomainService domainService;

    public KeywordsController(KeywordsService service, DomainService domainService) {
        this.service = service;
        this.domainService = domainService;
    }


    @RequestMapping("/list")
    public String list(@PathVariable int domainId, Model model, @ModelAttribute("pager") KeywordsPager pager) {
        pager.setDomainId(domainId);

        List<Keywords> list = service.list(pager);
        model.addAttribute("list", list);

        Domain domain = domainService.item(domainId);
        model.addAttribute("domain", domain);

        return "keywords/list";
    }

    @GetMapping("/add")
    public String add() {

        return "/keywords/add";
    }

    @PostMapping("/add")
    public String add(@PathVariable int domainId, Keywords keywords) {
        keywords.setDomainId(domainId);
        service.add(keywords);

        tester.test(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), keywords.getName());

        return "redirect:/keywords/" + domainId + "/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model, @PathVariable int domainId) {
        Keywords keywords = service.item(id);
        model.addAttribute("item", keywords);

        tester.test(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), keywords.getName());
        return "domain/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @PathVariable int domainId, Keywords keywords) {
        keywords.setId(id);
        keywords.setDomainId(domainId);
        service.update(keywords);

        return "redirect:/keywords/" + domainId + "/list";

    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, @PathVariable int domainId) {
        Keywords keywords = new Keywords();
        keywords.setId(id);
        keywords.setDomainId(domainId);
        service.delete(keywords);

        tester.test(getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName(), id + "번 째 키워드");
        return "redirect:/keywords/" + domainId + "/list";
    }
}
