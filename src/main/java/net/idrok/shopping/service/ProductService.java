package net.idrok.shopping.service;

import net.idrok.shopping.entity.Product;

import java.util.List;

public interface ProductService extends CommonService<Product> {


   List<Product> getByCategoryId( Long categoryId);
}
