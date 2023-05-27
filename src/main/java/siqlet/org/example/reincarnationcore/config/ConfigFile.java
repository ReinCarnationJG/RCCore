package siqlet.org.example.reincarnationcore.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigFile {

    public static void save(JavaPlugin plugin, String yml, YamlConfiguration yamlConfig) {

        try {
            yamlConfig.save(new File(plugin.getDataFolder(), yml));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void create(JavaPlugin plugin, String yml) {

        File file = new File(plugin.getDataFolder(), yml);

        if ( !file.exists() ) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static YamlConfiguration load(JavaPlugin plugin, String yml) {

        File file = new File(plugin.getDataFolder(), yml);
        YamlConfiguration fileYml = YamlConfiguration.loadConfiguration(file);

        return fileYml;
    }

}
