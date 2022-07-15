package net.albhon.starbound.block;

import net.albhon.starbound.StarboundMod;
import net.albhon.starbound.block.custom.*;
import net.albhon.starbound.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StarboundMod.MOD_ID);

    public  static final RegistryObject<Block> TAR_BLOCK = registerBlock("tar_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY)
                    .strength(2f, 3f).sound(SoundType.SLIME_BLOCK).jumpFactor(0.8f)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public  static final RegistryObject<Block> WET_SANDSTONE = registerBlock("wet_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.3f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public  static final RegistryObject<Block> LEAKING_WET_SANDSTONE = registerBlock("leaking_wet_sandstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);



    public  static final RegistryObject<Block> BRAINS_BLOCK = registerBlock("brains_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(2f).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops()),
                    CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BRAINS = registerBlock("brains",
            () -> new BrainsBlock(BlockBehaviour.Properties.of(Material.TOP_SNOW)
                    .strength(2f).sound(SoundType.CORAL_BLOCK).requiresCorrectToolForDrops().dynamicShape()),
                    CreativeModeTab.TAB_BUILDING_BLOCKS);

    public  static final RegistryObject<Block> FLESH_BLOCK = registerBlock("flesh_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(3f).sound(SoundType.WART_BLOCK)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> NERVE = registerBlock("nerve",
            () -> new NerveBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .strength(0.2f).sound(SoundType.NETHER_WART).noCollission().noOcclusion()
                    .lightLevel((state) -> state.getValue(NerveBlock.WRITHING) ? 6 : 4)),
                    CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CELL_HELIX = registerBlock("cell_helix",
            () -> new CellHelixBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.NETHER_WART)
                    .noCollission().noOcclusion()),
                    CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> TALL_CELL_HELIX = registerBlock("tall_cell_helix",
            () -> new TallCellHelixBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.NETHER_WART)
                    .noCollission().noOcclusion()),
                    CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> EYE_STALK_HEAD = registerBlock("eye_stalk_head",
            () -> new EyeStalkHeadBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.NETHER_WART)
                    .noCollission().noOcclusion()),
                    CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> EYE_STALK = BLOCKS.register("eye_stalk",
            () -> new EyeStalkBlock(BlockBehaviour.Properties.copy(Blocks.WEEPING_VINES_PLANT)
                    .noCollission().noOcclusion()));
    public static final RegistryObject<Block> PUSSPLUM_CROP = BLOCKS.register("pussplum_crop",
            () -> new PussplumCropBlock(BlockBehaviour.Properties.copy(Blocks.BEETROOTS)
                    .noCollission().noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
