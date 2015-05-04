package com.gmail.jamesbehan198.customguns;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGuns extends JavaPlugin {
	
	public Material mat;
	
	public List<String> lore;
	public List<String> check;
	public List<ItemStack> getGun;
	
	public boolean tnt;
	public boolean cats;
	public boolean cows;
	public boolean pigs;
	public boolean chickens;
	
	public String name;
	
	public int amount;
	
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
	
		mat = Material.getMaterial(getConfig().getString("guns.material"));
		
		name = getConfig().getString("guns.name");
		amount = getConfig().getInt("guns.amount");
		lore = getConfig().getStringList("guns.lore");
		
		check = new ArrayList<String>();
		getGun = new ArrayList<ItemStack>();
		
		tnt = getConfig().getBoolean("guns.tnt");
		cats = getConfig().getBoolean("guns.cats");
		cows = getConfig().getBoolean("guns.cows");
		pigs = getConfig().getBoolean("guns.pigs");
		chickens = getConfig().getBoolean("guns.chickens");
		
		registry();
	}
	
	@Override
	public void onDisable() {
		saveDefaultConfig();
	}
	
	public void registry() {
		this.getServer().getPluginManager().registerEvents(new GunListener(this), this);
		
		getCommand("gun").setExecutor(new Gun(this));;
	}
	
	public String colors(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
}
