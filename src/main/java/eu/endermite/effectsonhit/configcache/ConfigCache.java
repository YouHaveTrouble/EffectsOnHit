package eu.endermite.effectsonhit.configcache;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Set;

public class ConfigCache {

    private final HashMap<String, CustomEnchants> enchants = new HashMap<>();
    private final String noPermMessage;
    private final String wrongArgumentMessage;
    private final String configReloadedMessage;

    public ConfigCache(FileConfiguration yamlConfiguration) {
        Set<String> enchantList = yamlConfiguration.getConfigurationSection("enchant").getKeys(false);
        for (String s : enchantList) {
            this.enchants.put(s, new CustomEnchants(yamlConfiguration.getConfigurationSection("enchant." + s)));
        }
        this.noPermMessage = ChatColor.translateAlternateColorCodes('&', yamlConfiguration.getString("messages.no-permission"));
        this.wrongArgumentMessage = ChatColor.translateAlternateColorCodes('&', yamlConfiguration.getString("messages.wrong-argument"));
        this.configReloadedMessage = ChatColor.translateAlternateColorCodes('&', yamlConfiguration.getString("messages.config-reloaded"));
    }

    public CustomEnchants getEnchant(String enchName) {
        return enchants.get(enchName);
    }

    public String getNoPermMessage() {
        return noPermMessage;
    }

    public String getWrongArgumentMessage() {
        return wrongArgumentMessage;
    }

    public String getConfigReloadedMessage() {
        return configReloadedMessage;
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