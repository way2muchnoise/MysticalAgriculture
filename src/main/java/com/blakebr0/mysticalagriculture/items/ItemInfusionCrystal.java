package com.blakebr0.mysticalagriculture.items;

import java.util.List;

import javax.annotation.Nullable;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.config.ModConfig;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInfusionCrystal extends Item {
	
	public ItemInfusionCrystal(String name){
		super();
		this.setUnlocalizedName("ma." + name);
		this.setRegistryName(name);
		this.setCreativeTab(MysticalAgriculture.tabMysticalAgriculture);
		this.setMaxStackSize(1);
		this.setMaxDamage(ModConfig.crystal_durability - 1);
		this.setNoRepair();
	}
	
    @Override
    public ItemStack getContainerItem(ItemStack itemstack){
        ItemStack stack = itemstack.copy();

        stack.setItemDamage(stack.getItemDamage() + 1);
        stack.stackSize = 1;

        return stack;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack){
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced){
    	int damage = stack.getMaxDamage() - stack.getItemDamage() + 1;
    	tooltip.add("Uses Left: \u00A7c" + damage);
        super.addInformation(stack, player, tooltip, advanced);
    }
}
