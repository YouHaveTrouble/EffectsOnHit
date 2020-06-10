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


public class EntityDamageByEntityEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDamageByEntity(org.bukkit.event.entity.EntityDamageByEntityEvent event) {
        if (!event.isCancelled()) {
            if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
                Player attacker = (Player) event.getDamager();
                LivingEntity victim = (LivingEntity) event.getEntity();
                if (Bukkit.getVersion().contains("1.8")) {
                    if (attacker.getInventory().getItemInHand() != null) {
                        if (attacker.getInventory().getItemInHand().hasItemMeta()) {
                            for (String l : attacker.getInventory().getItemInHand().getItemMeta().getLore()) {
                                if (EffectsOnHit.getPlugin().getCache().hasEnchant(l)) {
                                    String effect = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchEffect();
                                    int duration = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchDuration();
                                    int amplify = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchamplify()-1;
                                    new PotionEffect(PotionEffectType.getByName(effect.toUpperCase()), duration, amplify).apply(victim);
                                }
                            }
                        }
                    }
                } else {
                    if (attacker.getInventory().getItemInMainHand() != null) {
                        if (attacker.getInventory().getItemInMainHand().hasItemMeta()) {
                            for (String l : attacker.getInventory().getItemInMainHand().getItemMeta().getLore()) {
                                if (EffectsOnHit.getPlugin().getCache().hasEnchant(l)) {
                                    String effect = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchEffect();
                                    int duration = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchDuration();
                                    int amplify = EffectsOnHit.getPlugin().getCache().getEnchant(l).getEnchamplify()-1;
                                    new PotionEffect(PotionEffectType.getByName(effect.toUpperCase()), duration, amplify).apply(victim);
                                }
                            }

                        }
                    }
                }
            }
        }

    }

}
