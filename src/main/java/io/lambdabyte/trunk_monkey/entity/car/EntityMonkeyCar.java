package io.lambdabyte.trunk_monkey.entity.car;

import java.util.Random;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class EntityMonkeyCar extends CreatureEntity implements IAnimatedEntity {

	private static final DataParameter<Boolean> IS_ATTACKED = EntityDataManager.createKey(EntityMonkeyCar.class, DataSerializers.BOOLEAN);

	private EntityAnimationManager manager = new EntityAnimationManager();
	private AnimationController controller = new EntityAnimationController(this, "trunkController", 20, this::animationPredicate);

	public EntityMonkeyCar(EntityType<? extends EntityMonkeyCar> type, World worldIn) {
		super(type, worldIn);
		registerControllers();
	}
	
	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		Random random = new Random();
		return 2 + random.nextInt(19);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if(source.getTrueSource() instanceof PlayerEntity) {
			setIsAttacked(true);
		}
		return super.attackEntityFrom(source, amount);
	}


	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}

	private void registerControllers(){
		if (world.isRemote) {
			manager.addAnimationController(controller);
		}
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(IS_ATTACKED, false);
	}

	public boolean getIsAttacked()
	{
		return this.dataManager.get(IS_ATTACKED);
	}

	public void setIsAttacked(boolean isAttacked){
		this.dataManager.set(IS_ATTACKED, false);
	}

	private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event)
	{
		boolean isAttacked = getIsAttacked();
		if (isAttacked == true){
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.monkey_car.open", false));
			return true;
 		}
		return false;
	}
}
