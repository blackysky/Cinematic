package de.silke.cinematic.managers;

import de.silke.cinematic.Main;
import lombok.Data;

import java.io.File;

@Data
public class ConfigurationManager {
    /**
     * Создание файла конфигурации
     */
    public static void createConfigFile() {
        if (!isConfigFileExists()) {
            Main.plugin.getLogger().info(String.format("[%s] Файл конфигурации не найден, создаю новый", Main.plugin.getDescription().getName()));
            Main.plugin.saveDefaultConfig();
        }
    }

    /**
     * Создание папки для плагина
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void createPluginFolder() {
        File folder = Main.plugin.getDataFolder();

        if (!isPluginFolderExists()) {
            Main.plugin.getLogger().info(String.format("[%s] Папка плагина не найдена, создаю новую", Main.plugin.getDescription().getName()));
            folder.mkdirs();
        }
    }

    /**
     * Перезагрузка файла конфигурации
     */
    public static void reloadConfigFile() {
        Main.plugin.reloadConfig();
    }

    /**
     * Сохранение файла конфигурации
     */
    public static void saveConfigFile() {
        Main.plugin.saveConfig();
    }

    /**
     * Проверка наличия файла конфигурации
     *
     * @return true если файл конфигурации существует, иначе false
     */
    public static boolean isConfigFileExists() {
        File file = new File(Main.plugin.getDataFolder(), "config.yml");
        return file.exists();
    }

    /**
     * Проверка наличия папки плагина
     *
     * @return true если папка плагина существует, иначе false
     */
    public static boolean isPluginFolderExists() {
        File folder = Main.plugin.getDataFolder();
        return folder.exists();
    }
}
