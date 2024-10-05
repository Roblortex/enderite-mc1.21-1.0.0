package com.vexalor.enderite.item;

import com.vexalor.enderite.Enderite;
import com.vexalor.enderite.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public  static final ItemGroup ENDERITE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Enderite.MOD_ID, "enderite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENDERITE_INGOT))
                    .displayName(Text.translatable("itemgroup.enderite.enderite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDERITE_SCRAPS);
                        entries.add(ModItems.ENDERITE_INGOT);
                        entries.add(ModBlocks.ENDERITE_BLOCK);
                        entries.add(ModBlocks.ENDERITE_ORE);
                    }).build());

    public static void registerItemGroups(){
        Enderite.LOGGER.info("Registering Mod Groups for " + Enderite.MOD_ID);
    }
}
