package mca.library.common.animation;

import java.util.ArrayList;
import java.util.List;

import mca.library.common.IMCAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class AnimTickHandler
{
	private List<IMCAnimatedEntity> activeEntities = new ArrayList<IMCAnimatedEntity>();
	private List<IMCAnimatedEntity> removableEntities = new ArrayList<IMCAnimatedEntity>();

	public AnimTickHandler()
	{
		FMLCommonHandler.instance().bus().register(this);
	}

	public void addEntity(IMCAnimatedEntity entity)
	{
		activeEntities.add(entity);
	}

	//Called when the client ticks.
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event)
	{
		if (!activeEntities.isEmpty())
		{
			if (event.phase == Phase.START)
			{
				for (IMCAnimatedEntity entity : activeEntities)
				{
					entity.getAnimationHandler().animationsUpdate();

					if (entity.isEntity() && ((Entity) entity).isDead)
					{
						removableEntities.add(entity);
					}
					if (entity.isTile() && ((TileEntity) entity).isInvalid())
					{
						removableEntities.add(entity);
					}
				}

				for (IMCAnimatedEntity entity : removableEntities)
				{
					activeEntities.remove(entity);
				}
				removableEntities.clear();
			}
		}
	}

	//Called when the server ticks. Usually 20 ticks a second.
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event)
	{
		if (!activeEntities.isEmpty())
		{
			if (event.phase == Phase.START)
			{
				for (IMCAnimatedEntity entity : activeEntities)
				{
					entity.getAnimationHandler().animationsUpdate();

					if (entity.isEntity() && ((Entity) entity).isDead)
					{
						removableEntities.add(entity);
					}
					if (entity.isTile() && ((TileEntity) entity).isInvalid())
					{
						removableEntities.add(entity);
					}
				}

				for (IMCAnimatedEntity entity : removableEntities)
				{
					activeEntities.remove(entity);
				}
				removableEntities.clear();
			}
		}
	}

	//Called when a new frame is displayed (See fps)
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event)
	{
	}

	//Called when the world ticks
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event)
	{
	}
}
