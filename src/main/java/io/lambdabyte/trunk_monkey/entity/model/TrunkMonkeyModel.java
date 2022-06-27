package io.lambdabyte.trunk_monkey.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import io.lambdabyte.trunk_monkey.entity.EntityTrunkMonkey;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class TrunkMonkeyModel extends EntityModel<EntityTrunkMonkey> {
	private final ModelRenderer leftFoot;
	private final ModelRenderer rightFoot;
	private final ModelRenderer leftLeg1;
	private final ModelRenderer rightLeg1;
	private final ModelRenderer leftLeg2;
	private final ModelRenderer rightLeg2;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer head;

	public TrunkMonkeyModel() {
		textureWidth = 64;
		textureHeight = 64;

		leftFoot = new ModelRenderer(this);
		leftFoot.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftFoot.setTextureOffset(22, 22).addBox(-4.0F, -1.0F, 3.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		rightFoot = new ModelRenderer(this);
		rightFoot.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightFoot.setTextureOffset(16, 10).addBox(1.0F, -1.0F, 3.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		leftLeg1 = new ModelRenderer(this);
		leftLeg1.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftLeg1.setTextureOffset(20, 27).addBox(1.0F, -4.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rightLeg1 = new ModelRenderer(this);
		rightLeg1.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightLeg1.setTextureOffset(26, 6).addBox(-4.0F, -4.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		leftLeg2 = new ModelRenderer(this);
		leftLeg2.setRotationPoint(0.0F, 24.0F, 3.0F);
		setRotationAngle(leftLeg2, 0.6545F, 0.0F, 0.0F);
		leftLeg2.setTextureOffset(24, 0).addBox(-4.0F, -4.6311F, 4.1408F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		rightLeg2 = new ModelRenderer(this);
		rightLeg2.setRotationPoint(0.0F, 25.0F, 5.0F);
		setRotationAngle(rightLeg2, 0.6545F, 0.0F, 0.0F);
		rightLeg2.setTextureOffset(22, 15).addBox(1.0F, -6.6311F, 3.1408F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 8.0F);
		setRotationAngle(body, 0.6981F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -13.7019F, -0.9284F, 8.0F, 6.0F, 4.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(0.0F, 26.0F, -3.0F);
		leftArm.setTextureOffset(0, 18).addBox(4.0F, -11.8705F, 2.9326F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-24.0F, 26.0F, -3.0F);
		rightArm.setTextureOffset(14, 16).addBox(18.0F, -11.8705F, 2.9326F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(0, 10).addBox(-2.0F, -15.0F, -3.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(8, 18).addBox(-3.0F, -15.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(8, 22).addBox(-1.0F, -13.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(12, 10).addBox(2.0F, -15.0F, -2.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityTrunkMonkey entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		leftFoot.render(matrixStack, buffer, packedLight, packedOverlay);
		rightFoot.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}