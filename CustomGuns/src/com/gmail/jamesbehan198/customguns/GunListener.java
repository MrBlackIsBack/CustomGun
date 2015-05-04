package com.gmail.jamesbehan198.customguns;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class GunListener implements Listener {

	CustomGuns main;

	public GunListener(CustomGuns main) {
		this.main = main;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(main.name)) {

				if (main.tnt) { // Always returning true...

					Entity tnt = p.getWorld().spawn(p.getEyeLocation(), TNTPrimed.class);

					((TNTPrimed) tnt).setFuseTicks(20);

					tnt.setVelocity(p.getLocation().getDirection().multiply(5.0));
					return;
				}

				if (main.cats) {

					Entity cat = p.getWorld().spawn(p.getEyeLocation(), Ocelot.class);

					cat.setVelocity(p.getLocation().getDirection().multiply(5.0));
					return;
				}
				if (main.chickens) {

					Entity chicken = p.getWorld().spawn(p.getEyeLocation(), Chicken.class);

					chicken.setVelocity(p.getLocation().getDirection().multiply(5.0));
					return;
				}
				if (main.cows) {

					System.out.println("COWS");

					Entity cow = p.getWorld().spawn(p.getEyeLocation(), Cow.class);

					cow.setVelocity(p.getLocation().getDirection().multiply(5.0));
					return;
				}

				if (main.pigs) {

					Entity pig = p.getWorld().spawn(p.getEyeLocation(), Pig.class);

					pig.setVelocity(p.getLocation().getDirection().multiply(5.0));
					return;
				}

			}
		}
	}

}
