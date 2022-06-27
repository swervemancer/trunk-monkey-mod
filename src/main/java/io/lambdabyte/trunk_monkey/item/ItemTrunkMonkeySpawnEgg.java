package io.lambdabyte.trunk_monkey.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ItemTrunkMonkeySpawnEgg extends SpawnEggItem {
	
	private static final List<ItemTrunkMonkeySpawnEgg> MOD_SPAWN_EGGS = new ArrayList<ItemTrunkMonkeySpawnEgg>();
	private final Lazy<? extends EntityType<?>> entityTypeSupplier;
 	
	public ItemTrunkMonkeySpawnEgg(final NonNullSupplier<? extends EntityType<?>> entityTypeSupplier, final int primaryColor, final int secondaryColor, final Item.Properties properties) {
		super(null, primaryColor, secondaryColor, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		MOD_SPAWN_EGGS.add(this);
	}

	public ItemTrunkMonkeySpawnEgg(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColor, final int secondaryColor, final Item.Properties properties) {
		super(null, primaryColor, secondaryColor, properties);
		this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
		MOD_SPAWN_EGGS.add(this);
	}
	
	public static void spawnEggInit() {
		final Map<EntityType<?>, SpawnEggItem> SPAWN_EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
		
		DefaultDispenseItemBehavior itemBehavior = new DefaultDispenseItemBehavior() {
			@Override
			protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
				Direction direction = source.getBlockState().get(DispenserBlock.FACING);
				EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
				type.spawn(source.getWorld(), stack, null, source.getBlockPos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
				stack.shrink(1);
				return stack;
			}
		};
		
		for (final SpawnEggItem egg : MOD_SPAWN_EGGS) {
			SPAWN_EGGS.put(egg.getType(null), egg);
			DispenserBlock.registerDispenseBehavior(egg, itemBehavior);
		}
		MOD_SPAWN_EGGS.clear();
	}
	
	
	@Override
	public EntityType<?> getType(CompoundNBT nbt) {
		return this.entityTypeSupplier.get();
	}

}
