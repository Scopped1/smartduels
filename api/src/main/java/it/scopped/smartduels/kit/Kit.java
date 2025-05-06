package it.scopped.smartduels.kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Kit {

    String identifier();

    ItemStack[] contents();

    ItemStack[] armors();

    ItemStack displayItem();

    void setDisplayItem(ItemStack displayItem);

    void give(Player player);

}
