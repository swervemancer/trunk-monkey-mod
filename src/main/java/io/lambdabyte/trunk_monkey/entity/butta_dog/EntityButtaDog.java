package io.lambdabyte.trunk_monkey.entity.butta_dog;

import java.util.Random;

import io.lambdabyte.trunk_monkey.init.TrunkMonkeyInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class EntityButtaDog extends TameableEntity implements IAnimatedEntity {

    private EntityAnimationManager manager = new EntityAnimationManager();
    private AnimationController walkController = new EntityAnimationController(this, "walkController", 20, this::walkPredicate);

    public EntityButtaDog(EntityType<? extends EntityButtaDog> type, World worldIn) {
        super(type, worldIn);
        registerAnimationControllers();
    }

    @Override
    public EntityAnimationManager getAnimationManager() {
        return manager;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.BEEF;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new SwimGoal(this));
      this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
      this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(4, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
      this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)).setCallsForHelp());
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractSkeletonEntity.class, false));
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        if (tamed) {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
            this.setHealth(20.0F);
         } else {
            this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
         }
   
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getHeldItem(hand);
      Item item = itemstack.getItem();
      if (itemstack.getItem() instanceof SpawnEggItem) {
         return super.processInteract(player, hand);
      } else if (this.world.isRemote) {
         return this.isOwner(player) || item == Items.BONE;
      } else {
         if (this.isTamed()) {
            if (item.isFood() && item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
               if (!player.abilities.isCreativeMode) {
                  itemstack.shrink(1);
               }

               this.heal((float)item.getFood().getHealing());
               return true;
            }

            if (this.isOwner(player) && !this.isBreedingItem(itemstack)) {
               this.sitGoal.setSitting(!this.isSitting());
               this.isJumping = false;
               this.navigator.clearPath();
               this.setAttackTarget((LivingEntity)null);
            }
         } else if (item == Items.BONE) {
            if (!player.abilities.isCreativeMode) {
               itemstack.shrink(1);
            }

            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
               this.setTamedBy(player);
               this.navigator.clearPath();
               this.setAttackTarget((LivingEntity)null);
               this.sitGoal.setSitting(true);
               this.world.setEntityState(this, (byte)7);
            } else {
               this.world.setEntityState(this, (byte)6);
            }

            return true;
         }

         return super.processInteract(player, hand);
      } 
    }

    @Override
    public int getMaxSpawnedInChunk() {
       return 8;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WOLF_AMBIENT;
    }

     @Override
      protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_WOLF_HURT;
     }
     
     @Override
     protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
     }
  
     @Override
     protected float getSoundVolume() {
        return 0.4F;
     }

    @Override
    protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
      this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		EntityButtaDog entity = new EntityButtaDog(TrunkMonkeyInit.BUTTA_DOG.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
    }
    
    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (otherAnimal == this) {
           return false;
        } else if (!(otherAnimal instanceof EntityButtaDog)) {
           return false;
        } else {
              EntityButtaDog wolfentity = (EntityButtaDog)otherAnimal;
              return this.isInLove() && wolfentity.isInLove();
           }
    }

    private void registerAnimationControllers(){
        manager.addAnimationController(walkController);
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        Random random = new Random();
        return 1 + random.nextInt(5);
    }
    
    private <E extends Entity> boolean walkPredicate(AnimationTestEvent<E> event)
	{
		if(event.isWalking()){
            walkController.setAnimation(new AnimationBuilder().addAnimation("animation.buttadog.walk", true));
            return true;
        }
        return false;
	}
}
