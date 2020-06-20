package org.csu.management.controller;

import org.csu.management.domain.Category;
import org.csu.management.domain.Item;
import org.csu.management.domain.Order;
import org.csu.management.domain.Product;
import org.csu.management.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/catalog/")
@Controller
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("addCategoryForm")
    public String add(){return "/catalog/add_Category";};
    @GetMapping("addProductForm")
    public String addProductForm(){
        //model.addAttribute("category",category);
        return "/catalog/add_Product";
    };
    @GetMapping("addItemForm")
    public String addItemForm(){return "/catalog/add_Item";}
    @GetMapping("updateOrderForm")
    public String updateOrderForm(int orderId,Model model){
        Order order=catalogService.getOrder(orderId);
        model.addAttribute("order",order);
        return "/catalog/update_Order";
    }

    @PostMapping("addCategory")
    public String addCategory(Category category,Model model){
        catalogService.addCategory(category);
        return "/catalog/add_Category";
    }
    @PostMapping("addProduct")
    public String addProduct(Product product,Model model){
        catalogService.addProduct(product);
        model.addAttribute("product",product);
        model.addAttribute("msg","添加成功");
        return "/catalog/add_Product";
    }
    @PostMapping("addItem")
    public String addItem(Item item,Model model){
        catalogService.addItem(item);
        model.addAttribute("item",item);
        model.addAttribute("msg","添加成功");
        return "/catalog/add_Item";
    }


    @GetMapping("viewCategory")
    public String viewCategory(String categoryId,Model model){
        if(categoryId != null){
            Category category = catalogService.getCategory(categoryId);
            List<Product> productList = catalogService.getProductListByCategory(categoryId);
            model.addAttribute("category",category);
            model.addAttribute("productList",productList);
            return "";//返回的是一个地址
        }
        return "";
    }
    @GetMapping("/operateCategoryForm")
    public String operateCategoryForm(String categoryId,Model model){
//        if(categoryId != null){
        Category category =catalogService.getCategory(categoryId);
        List<Product> productList = catalogService.getProductListByCategory(categoryId);
        model.addAttribute("category",category);
        model.addAttribute("productList",productList);
        return "/catalog/operate_Category";
//        }
//        return "/catalog/main";
    }
    @GetMapping("/operateProductForm")
    public String operateProductForm(String productId,Model model){
        Product product=catalogService.getProduct(productId);
        List<Item> itemList=catalogService.getItemListByProduct(productId);
        model.addAttribute("product",product);
        model.addAttribute("itemList",itemList);
        return "/catalog/operate_Product";
    }
    @GetMapping("/operateItemForm")
    public String operateItemForm(String itemId,Model model){
        Item item=catalogService.getItem(itemId);
        Product product=item.getProduct();
        model.addAttribute("item",item);
        model.addAttribute("product",product);
        return "/catalog/operate_Item";
    }
    @GetMapping("/operateOrderForm")
    public String operateOrderForm(Model model){
        List<Order> orderList=catalogService.getOrderList();
        model.addAttribute("orderList",orderList);
        return "/catalog/operate_Order";
    }

    @PostMapping("updateCategory")
    public String updateCategory(Category category,Model model){
        catalogService.updateCategory(category);
        category=catalogService.getCategory(category.getCategoryId());
        List<Product> productList = catalogService.getProductListByCategory(category.getCategoryId());
        model.addAttribute("category",category);
        model.addAttribute("productList",productList);
        model.addAttribute("msg","修改成功");
        return "/catalog/operate_Category";
    }
    @PostMapping("updateProduct")
    public String updateProduct(Product product,Model model){
        catalogService.updateProduct(product);
        product=catalogService.getProduct(product.getProductId());
        model.addAttribute("product",product);
        model.addAttribute("msg","修改成功");
        return "/catalog/operate_Product";
    }
    @PostMapping("updateItem")
    public String updateItem(Item item,Model model){
        catalogService.updateItem(item);
        item=catalogService.getItem(item.getItemId());
        model.addAttribute("item",item);
        model.addAttribute("msg","修改成功");
        return "/catalog/operate_Item";
    }
    @PostMapping("updateOrder")
    public String updateOrder(Order order,Model model){
        catalogService.updateOrder(order);
        order=catalogService.getOrder(order.getOrderId());
        model.addAttribute("order",order);
        model.addAttribute("msg","修改成功");
        return "/catalog/update_Order";
    }

    @GetMapping("main")
    public String main(){
        return "catalog/main";
    }
    @GetMapping("deleteCategory")
    public String deleteCategory(String categoryId,Model model){
        Category category=catalogService.getCategory(categoryId);
        catalogService.deleteCategory(category);
        return "/catalog/main";
    }
    @GetMapping("deleteProduct")
    public String deleteProduct(String productId,Model model){
        Product product=catalogService.getProduct(productId);
        Category category=catalogService.getCategory(product.getCategoryId());
        catalogService.deleteProduct(product);
        List<Product> productList = catalogService.getProductListByCategory(category.getCategoryId());
        model.addAttribute("category",category);
        model.addAttribute("productList",productList);
        return "/catalog/operate_Category";
    }
    @GetMapping("deleteItem")
    public String deleteItem(String itemId,Model model){
        Item item=catalogService.getItem(itemId);
        Product product=catalogService.getProduct(item.getProductId());
        catalogService.deleteItem(item);
        model.addAttribute("item",item);
        model.addAttribute("product",product);
        return "/catalog/operate_Item";
    }
    @GetMapping("deleteOrder")
    public String deleteOrder(int orderId,Model model){
        Order order=catalogService.getOrder(orderId);
        catalogService.deleteOrder(order);
        List<Order> orderList=catalogService.getOrderList();
        model.addAttribute(orderList);
        return "/catalog/operate_Order";
    }
}
