package eu.endermite.effectsonhit.listeners;

import eu.endermite.effectsonhit.EffectsOnHit;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class EntityDamageByEntityEventLegacy implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onEntityDamageByEntity(org.bukkit.event.entity.EntityDamageByEntityEvent event) {
		if (!event.isCancelled()) {
			if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
				Player attacker = (Player) event.getDamager();
				LivingEntity victim = (LivingEntity) event.getEntity();
				try {
					attacker.getInventory().getItemInHand();
					if (attacker.getInventory().getItemInHand().hasItemMeta()) {
						for (String l : attacker.getInventory().getItemInHand().getItemMeta().getLore()) {
							if (EffectsOnHit.getPlugin().getCache().hasEnchant(l)) {
								String effect = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchEffect();
								int duration = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchDuration();
								int amplify = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchamplify() - 1;
								new PotionEffect(PotionEffectType.getByName(effect.toUpperCase()), duration, amplify).apply(victim);
							}
						}
					}
				} catch (Exception e) {
					System.out.println("Could not find specified effect. This is most likely caused by misconfiguring a plugin.");
				}
			}
		}
	}
}
