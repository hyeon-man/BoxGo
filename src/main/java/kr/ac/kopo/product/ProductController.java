package kr.ac.kopo.product;

import kr.ac.kopo.Vo.Keywords;
import kr.ac.kopo.Vo.Product;
import kr.ac.kopo.keywords.KeywordsService;
import kr.ac.kopo.util.Pager;
import kr.ac.kopo.util.SysoutTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    SysoutTester tester = new SysoutTester();
    final ProductService service;
    final KeywordsService keywordsService;

    public ProductController(ProductService service, KeywordsService keywordsService) {
        this.service = service;
        this.keywordsService = keywordsService;
    }

    @GetMapping("/list")
    public String list(Model model, Pager pager) {

        List<Product> list = service.list(pager);
        model.addAttribute("list", list);

        return "product/list";
    }

    @GetMapping("/add")
    public String add(Model model) {

        List<Keywords> categoryList = keywordsService.list(21);
        model.addAttribute("categorys", categoryList);

        List<Keywords> brandList = keywordsService.list(22);
        model.addAttribute("brands", brandList);

        List<Keywords> sizeList = keywordsService.list(23);
        model.addAttribute("sizes", sizeList);

        List<Keywords> colorList = keywordsService.list(24);
        model.addAttribute("color", colorList);

        return "product/add";
    }

    @PostMapping("/add")
    public String add(Product product) {
        service.add(product);

        return "redirect:/product/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Product product = service.item(id);
        model.addAttribute("item", product);

        return "product/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, Product product) {
        product.setId(id);

        service.update(product);

        return "redirect:/product/list";
    }
}
