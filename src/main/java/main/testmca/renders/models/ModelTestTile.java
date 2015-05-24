package main.testmca.renders.models;

import java.util.HashMap;

import mca.library.client.MCAModelRenderer;
import mca.library.common.IMCAnimatedEntity;
import mca.library.common.MCAVersionChecker;
import mca.library.common.animation.AnimationHandler;
import mca.library.common.math.Matrix4f;
import mca.library.common.math.Quaternion;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelTestTile extends ModelBase
{
	public final int MCA_MIN_REQUESTED_VERSION = 3;
	public HashMap<String, MCAModelRenderer> parts = new HashMap<String, MCAModelRenderer>();

	MCAModelRenderer bottom;
	MCAModelRenderer top;
	MCAModelRenderer lbBox;
	MCAModelRenderer rbBox;
	MCAModelRenderer rtBox;
	MCAModelRenderer ltBox;
	MCAModelRenderer middle;
	MCAModelRenderer middle2;
	
	public ModelTestTile(boolean stuff)
	{
		MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

		textureWidth = 256;
		textureHeight = 128;

		middle = new MCAModelRenderer(this, "middle", 32, 0);
		middle.mirror = false;
		middle.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
		middle.setInitialRotationPoint(0.0F, -24.0F, 0.0F);
		middle.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		middle.setTextureSize(256, 128);
		parts.put(middle.boxName, middle);
	}

	public ModelTestTile()
	{
		MCAVersionChecker.checkForLibraryVersion(getClass(), MCA_MIN_REQUESTED_VERSION);

		textureWidth = 256;
		textureHeight = 128;

		bottom = new MCAModelRenderer(this, "bottom", 32, 0);
		bottom.mirror = false;
		bottom.addBox(0.0F, 0.0F, 0.0F, 16, 4, 16);
		bottom.setInitialRotationPoint(-8.0F, -32.0F, -8.0F);
		bottom.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		bottom.setTextureSize(256, 128);
		parts.put(bottom.boxName, bottom);

		top = new MCAModelRenderer(this, "top", 32, 0);
		top.mirror = false;
		top.addBox(0.0F, 0.0F, 0.0F, 16, 4, 16);
		top.setInitialRotationPoint(-8.0F, -20.0F, -8.0F);
		top.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		top.setTextureSize(256, 128);
		parts.put(top.boxName, top);

		lbBox = new MCAModelRenderer(this, "lbBox", 0, 1);
		lbBox.mirror = false;
		lbBox.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		lbBox.setInitialRotationPoint(-8.0F, -28.0F, 7.0F);
		lbBox.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		lbBox.setTextureSize(256, 128);
		parts.put(lbBox.boxName, lbBox);

		rbBox = new MCAModelRenderer(this, "rbBox", 0, 1);
		rbBox.mirror = false;
		rbBox.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		rbBox.setInitialRotationPoint(7.0F, -28.0F, 7.0F);
		rbBox.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		rbBox.setTextureSize(256, 128);
		parts.put(rbBox.boxName, rbBox);

		rtBox = new MCAModelRenderer(this, "rtBox", 0, 1);
		rtBox.mirror = false;
		rtBox.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		rtBox.setInitialRotationPoint(7.0F, -28.0F, -8.0F);
		rtBox.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		rtBox.setTextureSize(256, 128);
		parts.put(rtBox.boxName, rtBox);

		ltBox = new MCAModelRenderer(this, "ltBox", 0, 1);
		ltBox.mirror = false;
		ltBox.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		ltBox.setInitialRotationPoint(-8.0F, -28.0F, -8.0F);
		ltBox.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		ltBox.setTextureSize(256, 128);
		parts.put(ltBox.boxName, ltBox);

		middle = new MCAModelRenderer(this, "middle", 32, 0);
		middle.mirror = false;
		middle.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
		middle.setInitialRotationPoint(0.0F, -24.0F, 0.0F);
		middle.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.0F, 0.0F, 1.0F)).transpose());
		middle.setTextureSize(256, 128);
		parts.put(middle.boxName, middle);

		middle2 = new MCAModelRenderer(this, "middle2", 32, 0);
		middle2.mirror = false;
		middle2.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
		middle2.setInitialRotationPoint(0.0F, -24.0F, 0.0F);
		middle2.setInitialRotationMatrix(new Matrix4f().set(new Quaternion(0.0F, 0.38268346F, 0.0F, 0.9238795F)).transpose());
		middle2.setTextureSize(256, 128);
		parts.put(middle.boxName, middle);

	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		//Render every non-child part
		bottom.render(par7);
		top.render(par7);
		lbBox.render(par7);
		rbBox.render(par7);
		rtBox.render(par7);
		ltBox.render(par7);
		middle.render(par7);
		middle2.render(par7);
	}

	public void render(IMCAnimatedEntity entity, float par7)
	{
		bottom.resetRotationMatrix();
		bottom.resetRotationPoint();
		top.resetRotationMatrix();
		top.resetRotationPoint();
		rtBox.resetRotationMatrix();
		rtBox.resetRotationPoint();
		ltBox.resetRotationMatrix();
		ltBox.resetRotationPoint();
		rbBox.resetRotationMatrix();
		rbBox.resetRotationPoint();
		lbBox.resetRotationMatrix();
		lbBox.resetRotationPoint();
		middle.resetRotationMatrix();
		middle.resetRotationPoint();
		middle2.resetRotationMatrix();
		middle2.resetRotationPoint();
		AnimationHandler.performAnimationInModel(parts, entity);
		bottom.render(par7);
		top.render(par7);
		lbBox.render(par7);
		rbBox.render(par7);
		rtBox.render(par7);
		ltBox.render(par7);
		middle.render(par7);
		middle2.render(par7);
	}

	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{}

	public MCAModelRenderer getModelRendererFromName(String name)
	{
		return parts.get(name);
	}
}