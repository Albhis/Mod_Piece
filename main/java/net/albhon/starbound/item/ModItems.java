package net.albhon.starbound.item;

import net.albhon.starbound.StarboundMod;
import net.albhon.starbound.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StarboundMod.MOD_ID);

    public static final RegistryObject<Item> TAR_BALL = ITEMS.register( "tar_ball",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> PUSSPLUM = ITEMS.register( "pussplum",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(ModFoods.PUSSPLUM)));
    public static final RegistryObject<Item> PUSSPLUM_SEED = ITEMS.register( "pussplum_seed",
            () -> new ItemNameBlockItem(ModBlocks.PUSSPLUM_CROP.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
