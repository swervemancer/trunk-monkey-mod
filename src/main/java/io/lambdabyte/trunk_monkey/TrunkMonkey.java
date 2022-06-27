package io.lambdabyte.trunk_monkey;

import io.lambdabyte.trunk_monkey.entity.butta_dog.render.RenderButtaDog;
import io.lambdabyte.trunk_monkey.entity.car.render.MonkeyCarRenderer;
import io.lambdabyte.trunk_monkey.entity.render.TrunkMonkeyRenderer;
import io.lambdabyte.trunk_monkey.init.TrunkMonkeyInit;
import io.lambdabyte.trunk_monkey.init.TrunkMonkeyItemsInit;
import io.lambdabyte.trunk_monkey.item.ItemTrunkMonkeySpawnEgg;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Bus.MOD)
public class TrunkMonkey {
	
	public TrunkMonkey() 
	{
		register(FMLJavaModLoadingContext.get().getModEventBus());

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		TrunkMonkeyItemsInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ItemTrunkMonkeySpawnEgg.spawnEggInit();
	}
	
	private void register(IEventBus mod) {
		TrunkMonkeyInit.ENTITIES.register(mod);
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(TrunkMonkeyInit.TRUNK_MONKEY.get(), TrunkMonkeyRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TrunkMonkeyInit.MONKEY_CAR.get(), MonkeyCarRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(TrunkMonkeyInit.BUTTA_DOG.get(), RenderButtaDog::new);
	}

}