package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.SYSTEM;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    DEVELOPER("a " + ChatColor.AQUA + "Developer", ChatColor.AQUA + "[Red Developer]"),
    LEADDEV("a " + ChatColor.DARK_PURPLE + "Lead Developer and a Red System", ChatColor.DARK_PURPLE + "[Lead Dev & Red System]"),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.GOLD + "OP", ChatColor.GOLD + "[OP]"),
    SUPER("a " + ChatColor.GOLD + "Red Super", ChatColor.GOLD + "[Red Admin]"),
    TELNET("a " + ChatColor.DARK_GREEN + "Red Telnet", ChatColor.DARK_GREEN + "[Red Telnet]"),
    SENIOR("a " + ChatColor.GOLD + "Red Senior", ChatColor.GOLD + "[Red Senior]"),
    OWNER("the " + ChatColor.DARK_RED + "Red Owner", ChatColor.DARK_RED + "[Red Owner]"),
    CONSOLE("The " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]"),
    EXECUTIVE("a " + ChatColor.DARK_RED + "Red Executive", ChatColor.DARK_RED + "[Red Exec]"),
    SYS("a " + ChatColor.AQUA + "Red System", ChatColor.AQUA + "[Red System] "),
    NOOB("a " + ChatColor.AQUA + "Noob", ChatColor.AQUA + "[Noob]"),
    COOWNER("the " + ChatColor.DARK_RED + "Red Co-Owner", ChatColor.DARK_RED + "[Red Co-Owner]");
    private final String loginMessage;
    private final String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }
           if (sender.getName().equals("kadman"))
            {
                return NOOB;
            }
            if (sender.getName().equals("TaahThePenguin"))
            {
                return COOWNER;
            }
            if (sender.getName().equals("PacksGamingHD"))
            {
                return LEADDEV;
            }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }

        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }
        if (SYSTEM.contains(sender.getName()))
        {
            return SYS;
        }

        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }

            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
