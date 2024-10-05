package com.vexalor.enderite.block;

import com.vexalor.enderite.Enderite;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(AbstractBlock.Settings.create().strength(0.5f, 8)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block ENDERITE_ORE = registerBlock("enderite_ore",               //COPY ALL OF THIS TO MAKE A NEW BLOCK, THEN ADD THE BLOCK STATE BLOCK MODEL, ITEM AND TEXTURE.
            new Block(AbstractBlock.Settings.create().strength(0.25f, 9)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return  Registry.register(Registries.BLOCK, Identifier.of(Enderite.MOD_ID, name), block);
    }

    private  static  void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Enderite.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Enderite.LOGGER.info("Registering Mod Blocks for " + Enderite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {  //ADD THE BLOCK HERE TOO
            entries.add(ENDERITE_BLOCK);
            entries.add(ENDERITE_ORE);
        });
    }
}
