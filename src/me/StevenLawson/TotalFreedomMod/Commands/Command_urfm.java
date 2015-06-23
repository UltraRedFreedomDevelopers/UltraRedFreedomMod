package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "Information about UltraRedFreedomMod", usage = "/<command>")
public class Command_urfm extends TFM_Command {

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {

        playerMsg(ChatColor.GOLD + "URFM:Remastered Is A TFM, But Edited As Per &cRedEastWood's &eConcern");
        playerMsg(ChatColor.GOLD + "The Mod Was Made By PacksGamingHD!");
        playerMsg(ChatColor.RED + "Enjoy Your Stay At UltraRedFreedom");
        return true;

    }
}