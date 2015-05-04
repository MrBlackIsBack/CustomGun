package com.gmail.jamesbehan198.customguns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gun implements CommandExecutor {

	CustomGuns main;

	public Gun(CustomGuns main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(main.colors("&cNope!"));
			return true;
		}

		Player p = (Player) sender;

		if (p.hasPermission("customguns.spawn")) {
			if (cmd.getName().equalsIgnoreCase("gun")) {
				if (args.length == 0) {
					p.sendMessage(main.colors("&c/gun spawn"));
					return true;
				}

				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("spawn")) {
						ItemStack gun = new ItemStack(main.mat, main.amount);
						ItemMeta gunMeta = gun.getItemMeta();

						gunMeta.setDisplayName(main.name);
						gunMeta.setLore(main.lore);

						gun.setItemMeta(gunMeta);
						
						main.getGun.add(gun);
						main.check.add(gunMeta.getDisplayName());

						if (p.getInventory().firstEmpty() == -1 && !main.check.contains(p.getName())) {
							p.sendMessage(main.colors("&cError; Inventory full!"));
							return true;
						}

						if (!main.check.contains(p.getName())) {
							p.getInventory().addItem(gun);
							p.sendMessage(main.colors("&aYou have been given the " + main.name));
							return true;
						}

						p.sendMessage(main.colors("&cRemoving " + main.name));
						p.getInventory().removeItem(gun);

						return true;
					}
				}
			}
		}

		return true;
	}

}
