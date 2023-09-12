package de.silke.cinematic.commands;

import de.silke.cinematic.Main;
import de.silke.cinematic.point.PointChecker;
import de.silke.cinematic.point.CameraPoint;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CinematicCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch();
        String world = player.getLocation().getWorld().getName();

        if (args.length == 0) {
            sendHelp(player);
        } else {
            switch (args[0].toLowerCase()) {
                case "setpoint":
                    if (args.length == 2 && PointChecker.isInt(args[1]) && PointChecker.isBetween(Integer.parseInt(args[1]), 1, 5)) {
                        CameraPoint point = new CameraPoint(Integer.parseInt(args[1]), x, y, z, yaw, pitch, world);
                        Main.cinematicManager.setPoint(player, point);
                    } else {
                        player.sendMessage(ChatColor.RED + "Используйте: /cinematic setpoint [1-5]");
                    }
                    break;
                case "delpoint":
                    if (args.length == 2 && PointChecker.isInt(args[1]) && PointChecker.isBetween(Integer.parseInt(args[1]), 1, 5)) {
                        CameraPoint point = new CameraPoint(Integer.parseInt(args[1]), x, y, z, yaw, pitch, world);
                        Main.cinematicManager.delPoint(player, point);
                    } else {
                        player.sendMessage(ChatColor.RED + "Используйте: /cinematic delpoint [1-5]");
                    }
                    break;
                case "play":
                    Main.cinematicManager.play(player);
                    break;
                case "stop":
                    Main.cinematicManager.stop(player);
                    break;
                case "help":
                    sendHelp(player);
                    break;
                case "reload":
                    Main.cinematicManager.reload(player);
                    break;
                case "version":
                    player.sendMessage(ChatColor.GOLD + "Cinematic v" +  Main.versionManager.getCurrentVersion());
                    player.sendMessage(ChatColor.GRAY + Main.versionManager.isActualVersion());
                    break;
                default:
                    player.sendMessage(ChatColor.RED + "Неизвестная команда. Используйте /cinematic help для получения списка команд.");
                    break;
            }
        }

        return true;
    }

    public void sendHelp(Player player) {
        player.sendMessage(ChatColor.GOLD + "Cinematic v" +  Main.versionManager.getCurrentVersion());
        player.sendMessage(ChatColor.GREEN + "Доступные команды:");
        player.sendMessage(ChatColor.GOLD + "/cinematic setpoint [1-5]" + ChatColor.WHITE + " - Установить точку");
        player.sendMessage(ChatColor.GOLD + "/cinematic delpoint [1-5]" + ChatColor.WHITE + " - Удалить точку");
        player.sendMessage(ChatColor.GOLD + "/cinematic play" + ChatColor.WHITE + " - Воспроизвести кинематограф");
        player.sendMessage(ChatColor.GOLD + "/cinematic stop" + ChatColor.WHITE + " - Остановить кинематограф");
        player.sendMessage(ChatColor.GREEN + "Дополнительные команды:");
        player.sendMessage(ChatColor.GOLD + "/cinematic help" + ChatColor.WHITE + " - Показать список команд");
        player.sendMessage(ChatColor.GOLD + "/cinematic reload" + ChatColor.WHITE + " - Перезагрузить плагин");
        player.sendMessage(ChatColor.GOLD + "/cinematic version" + ChatColor.WHITE + " - Проверить обновления");
    }
}
