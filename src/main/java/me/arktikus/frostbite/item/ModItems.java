/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.item;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.entity.ModEntities;
import me.arktikus.frostbite.item.custom.ModHammer;
import me.arktikus.frostbite.item.custom.ModScythe;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ARKTIRIUM = registerItem("arktirium",
            new Item(new FabricItemSettings()));
    public static final Item RAW_ARKTIRIUM = registerItem("raw_arktirium",
            new Item(new FabricItemSettings()));
    public static final Item BLUE_ARCTIC_STICK = registerItem("blue_arctic_stick",
            new Item(new FabricItemSettings()));

    public static final Item ARKTIRIUM_HAMMER = registerItem("arktirium_hammer",
            new ModHammer(ModToolMaterial.ARKTIRIUM, 1, 1f,
                    new FabricItemSettings()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new ModHammer(ModToolMaterial.IRON, 1, 1f,
                    new FabricItemSettings()));

    public static final Item ARKTIRIUM_SCYTHE = registerItem("arktirium_wand",
            new ModScythe(ModToolMaterial.ARKTIRIUM, 1, 0.1f,
                    new FabricItemSettings()));

    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00,
                    new FabricItemSettings()));

    public static final Item PINGUIN_SPAWN_EGG = registerItem("pinguin_spawn_egg",
            new SpawnEggItem(ModEntities.PINGUIN, 0x091238, 0x000000,
                    new FabricItemSettings()));

        public static final Item SHARK_SPAWN_EGG = registerItem("shark_spawn_egg",
            new SpawnEggItem(ModEntities.SHARK, 0x096238, 0x000532,
                    new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FrostBite.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, ARKTIRIUM);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_ARKTIRIUM);
        addToItemGroup(ItemGroups.INGREDIENTS, BLUE_ARCTIC_STICK);

        addToItemGroup(ItemGroups.SPAWN_EGGS, TIGER_SPAWN_EGG);
        addToItemGroup(ItemGroups.SPAWN_EGGS, PINGUIN_SPAWN_EGG);
        addToItemGroup(ItemGroups.SPAWN_EGGS, SHARK_SPAWN_EGG);

        addToItemGroup(ModItemGroup.ARKTIRIUM, ARKTIRIUM);
        addToItemGroup(ModItemGroup.ARKTIRIUM, RAW_ARKTIRIUM);
        addToItemGroup(ModItemGroup.ARKTIRIUM, BLUE_ARCTIC_STICK);

        addToItemGroup(ModItemGroup.ARKTIRIUM, ARKTIRIUM_HAMMER);
        addToItemGroup(ModItemGroup.ARKTIRIUM, IRON_HAMMER);
        addToItemGroup(ModItemGroup.ARKTIRIUM, ARKTIRIUM_SCYTHE);

        addToItemGroup(ModItemGroup.ARKTIRIUM, TIGER_SPAWN_EGG);
        addToItemGroup(ModItemGroup.ARKTIRIUM, PINGUIN_SPAWN_EGG);
        addToItemGroup(ModItemGroup.ARKTIRIUM, SHARK_SPAWN_EGG);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        FrostBite.LOGGER.info("Registering Mod Items for " + FrostBite.MOD_ID);

        addItemsToItemGroup();
    }
}
