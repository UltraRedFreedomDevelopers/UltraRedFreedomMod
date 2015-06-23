package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Shows you how to become a admin.", usage = "/<command>", aliases = "ai")
public class Command_admininfo extends TFM_Command {

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {

        playerMsg(ChatColor.GOLD + "Oh, so you want to be a admin eh?");
        playerMsg(ChatColor.GOLD + "Go to UltraRedForums.tk and click");
        playerMsg(ChatColor.GOLD + "Admin Applications");
        playerMsg(ChatColor.GOLD + "Copy the template");
        playerMsg(ChatColor.GOLD + "Make a new thread");
        playerMsg(ChatColor.GOLD + "Paste the template");
        playerMsg(ChatColor.GOLD + "Answer the questions");
        playerMsg(ChatColor.GREEN + "Done");
        playerMsg(ChatColor.RED + "Remember, Never ask admins to view your application!");
        return true;

    }
}