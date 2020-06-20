package org.csu.management.persistence;

import org.csu.management.domain.Item;
import org.csu.management.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper {
    List<Item> getItemListByProduct(String productId);
    Item getItem(String itemId);

    void addItem(Item item);//这是新增一个item
    void updateItem(Item item);//这是修改一个item
    void deleteItem(Item item);//这是删除一个item
}
