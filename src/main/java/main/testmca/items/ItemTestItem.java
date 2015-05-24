package main.testmca.items;

import main.testmca.TestMCA;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTestItem extends Item
{
	public ItemTestItem()
	{
		setUnlocalizedName(TestMCA.MODID + "_" + getName());
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public String getName()
	{
		return "test_item";
	}
}
