package main.testmca.tiles;

import main.testmca.animations.AnimationHandlerTest;
import mca.library.common.IMCAnimatedEntity;
import mca.library.common.animation.AnimationHandler;
import net.minecraft.tileentity.TileEntity;

public class TileTestTile extends TileEntity implements IMCAnimatedEntity
{
	public AnimationHandlerTest animationHandler = new AnimationHandlerTest(this);

	@Override
	public AnimationHandler getAnimationHandler()
	{
		return animationHandler;
	}

	@Override
	public boolean isTile() 
	{
		return true;
	}

	@Override
	public boolean isEntity() 
	{
		return false;
	}
}
