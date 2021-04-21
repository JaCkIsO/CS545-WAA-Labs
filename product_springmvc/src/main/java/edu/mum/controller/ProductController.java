package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;


	@RequestMapping(method = RequestMethod.GET)
	public String getProductForm(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "ProductForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveProduct(Product product) {
		Category category = categoryService.getCategory(product.getCategory().getId());
		product.setCategory(category);
		productService.save(product);
		return "ProductDetails";
	}

	@RequestMapping(value = "/listproducts", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAll());
		return "ListProducts";
	}


	@RequestMapping(value = "/productfind", method = RequestMethod.GET)
	public String findProduct() {
		return "Find";
	}

	@RequestMapping(value = "/product")
	public String getProduct(Model model, @RequestParam("id") int id){
		model.addAttribute("product", productService.getById(id));
		return "SingleProduct";
	}
}
