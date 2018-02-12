package pl.polskipalacz.chat.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.polskipalacz.chat.PluginMain;
import pl.polskipalacz.chat.managers.ChatManager;
import pl.polskipalacz.chat.utils.ChatUtil;

public class ChatCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        if(!cs.hasPermission("chat.admin")&&!cs.isOp()){
            cs.sendMessage(ChatUtil.fixColor(PluginMain.getInst().getConfig().getString("messages.no-perm")));
            return true;
        }
        if(args.length != 1){
            cs.sendMessage(ChatUtil.fixColor(PluginMain.getInst().getConfig().getString("messages.usage")));
            return true;
        }
        if(args[0].toLowerCase().equalsIgnoreCase("clear")){
            for(int i = 0; i < 60; ++i){
                Bukkit.broadcastMessage("");
            }
            Bukkit.broadcastMessage(ChatUtil.fixColor(PluginMain.getInst().getConfig().getString("messages.chat-clear")));
        }if(args[0].toLowerCase().equalsIgnoreCase("on")){
            for(int i = 0; i < 60; ++i){
                Bukkit.broadcastMessage("");
            }
            ChatManager.setChat(true);
            Bukkit.broadcastMessage(ChatUtil.fixColor(PluginMain.getInst().getConfig().getString("messages.chat-on")));
        }if(args[0].toLowerCase().equalsIgnoreCase("off")){
            for(int i = 0; i < 60; ++i){
                Bukkit.broadcastMessage("");
            }
            ChatManager.setChat(false);
            Bukkit.broadcastMessage(ChatUtil.fixColor(PluginMain.getInst().getConfig().getString("messages.chat-off")));
        }
        return false;
    }
}
