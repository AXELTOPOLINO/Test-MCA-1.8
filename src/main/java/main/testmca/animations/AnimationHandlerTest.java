package main.testmca.animations;

import java.util.HashMap;

import main.testmca.animations.channels.ChannelCycle;
import main.testmca.tiles.TileTestTile;
import mca.library.common.animation.AnimationHandler;
import mca.library.common.animation.Channel;

public class AnimationHandlerTest extends AnimationHandler
{
	public static HashMap<String, Channel> animChannels = new HashMap<String, Channel>();
	static
	{
		animChannels.put("Cycle", new ChannelCycle("Cycle", 30.0F, 60, Channel.LINEAR));
	}

	public AnimationHandlerTest(TileTestTile entity)
	{
		super(entity);
	}

	@Override
	public void activateAnimation(String name, float startingFrame)
	{
		super.activateAnimation(animChannels, name, startingFrame);
	}

	@Override
	public void stopAnimation(String name)
	{
		super.stopAnimation(animChannels, name);
	}

	@Override
	public void fireAnimationEventClientSide(Channel anim, float prevFrame, float frame)
	{}

	@Override
	public void fireAnimationEventServerSide(Channel anim, float prevFrame, float frame)
	{}
}