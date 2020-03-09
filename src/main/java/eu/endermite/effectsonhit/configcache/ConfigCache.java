package eu.endermite.effectsonhit.configcache;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Set;

public class ConfigCache {

    private final HashMap<String, CustomEnchants> enchants = new HashMap<>();

    public ConfigCache(FileConfiguration yamlConfiguration) {
        Set<String> enchantList = yamlConfiguration.getConfigurationSection("enchant").getKeys(false);
        for (String s : enchantList) {
            this.enchants.put(s, new CustomEnchants(yamlConfiguration.getConfigurationSection("enchant." + s)));
        }
    }

    public CustomEnchants getEnchant(String enchName) {
        return enchants.get(enchName);
    }

    public boolean hasEnchant(String enchName) { return this.enchants.containsKey(enchName); }

    public static class CustomEnchants {

        private final String enchEffect;
        private final int enchAmplify;
        private final int enchDuration;

        CustomEnchants(ConfigurationSection configurationSection) {
            this.enchEffect = configurationSection.getString("effect");
            this.enchAmplify = configurationSection.getInt("level");
            this.enchDuration = configurationSection.getInt("duration");
        }

        public String getEnchEffect() {return enchEffect;}
        public int getEnchamplify() {return enchAmplify;}
        public int getEnchDuration() {return enchDuration;}

    }

}