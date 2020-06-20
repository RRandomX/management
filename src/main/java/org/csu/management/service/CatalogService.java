package org.csu.management.service;

import org.csu.management.domain.Category;
import org.csu.management.domain.Item;
import org.csu.management.domain.Order;
import org.csu.management.domain.Product;
import org.csu.management.persistence.CategoryMapper;
import org.csu.management.persistence.ItemMapper;
import org.csu.management.persistence.OrderMapper;
import org.csu.management.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private OrderMapper orderMapper;

    public void addCategory(Category category){
        categoryMapper.addCategory(category);
    }
    public void addProduct(Product product){productMapper.addProduct(product);}
    public void addItem(Item item){itemMapper.addItem(item);}

    public Category getCategory(String categoryId) {
        return categoryMapper.getCategory(categoryId);
    }
    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }
    public Item getItem(String itemId){return itemMapper.getItem(itemId);}
    public Order getOrder(int orderId) {return orderMapper.getOrder(orderId); }

    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }
    public List<Item> getItemListByProduct(String productId) {
        return itemMapper.getItemListByProduct(productId);
    }
    public List<Order> getOrderList(){return orderMapper.getOrderList();}

    @Transactional
    public void updateCategory(Category category){
        categoryMapper.updateCategory(category);
    }
    @Transactional
    public void updateProduct(Product product){productMapper.updateProduct(product);}
    @Transactional
    public void updateItem(Item item){itemMapper.updateItem(item);}
    @Transactional
    public void updateOrder(Order order){orderMapper.updateOrder(order);}
    @Transactional
    public void deleteCategory(Category category){categoryMapper.deleteCategory(category);}
    @Transactional
    public void deleteProduct(Product product){productMapper.deleteProduct(product);}
    @Transactional
    public void deleteItem(Item item){itemMapper.deleteItem(item);}
    @Transactional
    public void deleteOrder(Order order) { orderMapper.deleteOrder(order);}



}
