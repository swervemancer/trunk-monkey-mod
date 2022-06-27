package io.lambdabyte.trunk_monkey.init;

import io.lambdabyte.trunk_monkey.Constants;
import io.lambdabyte.trunk_monkey.entity.EntityTrunkMonkey;
import io.lambdabyte.trunk_monkey.entity.butta_dog.EntityButtaDog;
import io.lambdabyte.trunk_monkey.entity.car.EntityMonkeyCar;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TrunkMonkeyInit {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Constants.MOD_ID);

	public static final RegistryObject<EntityType<EntityButtaDog>> BUTTA_DOG = ENTITIES.register("butta_dog",
			() -> EntityType.Builder.create(EntityButtaDog::new, EntityClassification.CREATURE).size(1.0f, 1.0f).build("butta_dog"));
	
	public static final RegistryObject<EntityType<EntityTrunkMonkey>> TRUNK_MONKEY = ENTITIES.register("trunk_monkey", 
			() -> EntityType.Builder.create(EntityTrunkMonkey::new, EntityClassification.CREATURE).size(1.0f, 1.0f).build("trunk_monkey"));
	
	public static final RegistryObject<EntityType<EntityMonkeyCar>> MONKEY_CAR = ENTITIES.register("monkey_car", 
			() -> EntityType.Builder.create(EntityMonkeyCar::new, EntityClassification.CREATURE).size(2.0f, 2.0f).build("monkey_car"));
}
