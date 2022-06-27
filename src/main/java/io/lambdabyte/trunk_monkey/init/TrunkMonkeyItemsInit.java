package io.lambdabyte.trunk_monkey.init;

import io.lambdabyte.trunk_monkey.Constants;
import io.lambdabyte.trunk_monkey.item.ItemTrunkMonkeySpawnEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TrunkMonkeyItemsInit {
	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			Constants.MOD_ID);
	
	public static final RegistryObject<ItemTrunkMonkeySpawnEgg> TRUNK_MONKEY_EGG = ITEMS.register("trunk_spawn_egg", 
			() -> new ItemTrunkMonkeySpawnEgg(TrunkMonkeyInit.TRUNK_MONKEY, 0x53000D, 0x000000, 
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)));
	
	public static final RegistryObject<ItemTrunkMonkeySpawnEgg> MONKEY_CAR_EGG = ITEMS.register("car_spawn_egg", 
			() -> new ItemTrunkMonkeySpawnEgg(TrunkMonkeyInit.MONKEY_CAR, 0x2F329F, 0x2B322B, 
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)));

	public static final RegistryObject<ItemTrunkMonkeySpawnEgg> BUTTA_DOG_EGG = ITEMS.register("butta_dog_egg", 
			() -> new ItemTrunkMonkeySpawnEgg(TrunkMonkeyInit.BUTTA_DOG, 0x4C3428, 0xFFD400, 
	    		    new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)));
}
