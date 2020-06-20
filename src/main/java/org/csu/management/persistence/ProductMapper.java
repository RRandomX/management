package org.csu.management.persistence;

import org.csu.management.domain.Category;
import org.csu.management.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    //这个适用于查询一个大类里的内容，用于点击图片后的展示
    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    //搜索用到
    List<Product> searchProductList(String keywords);

    void addProduct(Product product);//这是新增一个product
    void updateProduct(Product product);//这是修改一个product
    void deleteProduct(Product product);//这是删除一个product
}
