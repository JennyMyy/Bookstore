package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@Controller
public class CategoryController {

    
    @Autowired
    private CategoryRepository carepository;

  
    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String ShowCategory(Model model) {
       model.addAttribute("categories", carepository.findAll());
        return "categorylist";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String addCategory(Model model) {
       model.addAttribute("category", new Category());
        return "addcategory";
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category){
        carepository.save(category);
        return "redirect:categorylist";
    } 

}
