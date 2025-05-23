package it.scopped.smartduels.kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitImpl implements Kit {

    private final String identifier;

    private final ItemStack[] contents;
    private final ItemStack[] armors;

    private ItemStack displayItem;

    public KitImpl(String identifier, ItemStack[] contents, ItemStack[] armors, ItemStack displayItem) {
        this.identifier = identifier;
        this.contents = contents;
        this.armors = armors;
        this.displayItem = displayItem;
    }

    @Override
    public String identifier() {
        return identifier;
    }

    @Override
    public ItemStack[] contents() {
        return contents;
    }

    @Override
    public ItemStack[] armors() {
        return armors;
    }

    @Override
    public ItemStack displayItem() {
        return displayItem;
    }

    @Override
    public void setDisplayItem(ItemStack displayItem) {
        this.displayItem = displayItem;
    }

    @Override
    public void give(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);

        player.getInventory().setContents(contents);
        player.getInventory().setArmorContents(armors);
    }
}
