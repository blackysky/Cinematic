package de.silke.cinematic;

import de.silke.cinematic.managers.CinematicManager;
import de.silke.cinematic.managers.ConfigurationManager;
import de.silke.cinematic.managers.VersionManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

@Getter
public final class Main extends JavaPlugin {
    public static Main plugin;
    public static Logger log = Logger.getLogger("Minecraft");
    public static VersionManager versionManager;
    public static CinematicManager cinematicManager;

    @Override
    public void onEnable() {
        plugin = this;

        // Проверка наличия папки плагина
        ConfigurationManager.createPluginFolder();

        // Проверка наличия файла конфигурации
        ConfigurationManager.createConfigFile();

        // Проверка наличия обновлений
        log.info(String.format("[%s] " + versionManager.isActualVersion(), getDescription().getName()));
    }

    @Override
    public void onDisable() {

    }
}
