package edu.mum.repositoryimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.repository.CategoryRepository;
import edu.mum.repository.ProductRepository;

@Repository
 public class ProductRepositoryImpl implements ProductRepository {
	
	CategoryRepository categoryRepository;
	
		private List<Product> listOfProducts ;

		/*
		 * NOTICE DI on Constructor
		 */
		@Autowired
	    public ProductRepositoryImpl(CategoryRepository categoryRepository) {
	    	this.categoryRepository =  categoryRepository;
	    	listOfProducts = new ArrayList<Product>();
	    	Category category= categoryRepository.getCategory(1);

	        Product bowTie = new Product(1, "Bow Tie", "Loud", (float) 22.0,  category);
 	        listOfProducts.add(bowTie);
 	    }

		@Override
		public List<Product> getAll() {
			return listOfProducts;
		}

		@Override
		public Product getById(int id){
			return listOfProducts.stream().filter(product -> product.getId() == id).findFirst().get();
		}
	
		@Override
		public void save(Product product) {
			product.setId(listOfProducts.size() + 1);
			listOfProducts.add(product);
		}
	
 
		   
}
 
