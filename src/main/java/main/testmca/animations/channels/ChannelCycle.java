package main.testmca.animations.channels;

import mca.library.common.animation.Channel;
import mca.library.common.animation.KeyFrame;
import mca.library.common.math.Vector3f;

public class ChannelCycle extends Channel
{
	public ChannelCycle(String _name, float _fps, int _totalFrames, byte _mode)
	{
		super(_name, _fps, _totalFrames, _mode);
	}

	@Override
	protected void initializeAllFrames()
	{
		final KeyFrame frame0 = new KeyFrame();
		frame0.modelRenderersTranslations.put("lbBox", new Vector3f(-8.0F, -28.0F, 7.0F));
		frame0.modelRenderersTranslations.put("rbBox", new Vector3f(7.0F, -28.0F, 7.0F));
		frame0.modelRenderersTranslations.put("rtBox", new Vector3f(7.0F, -28.0F, -8.0F));
		frame0.modelRenderersTranslations.put("ltBox", new Vector3f(-8.0F, -28.0F, -8.0F));
		keyFrames.put(0, frame0);

		final KeyFrame frame30 = new KeyFrame();
		frame30.modelRenderersTranslations.put("lbBox", new Vector3f(-8.0F, -28.0F, -8.0F));
		frame30.modelRenderersTranslations.put("rbBox", new Vector3f(-8.0F, -28.0F, 7.0F));
		frame30.modelRenderersTranslations.put("rtBox", new Vector3f(7.0F, -28.0F, 7.0F));
		frame30.modelRenderersTranslations.put("ltBox", new Vector3f(7.0F, -28.0F, -8.0F));
		keyFrames.put(30, frame30);
	}
}
