package pl.polskipalacz.chat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.polskipalacz.chat.commands.ChatCommand;
import pl.polskipalacz.chat.listener.ChatListener;

public class PluginMain extends JavaPlugin {

    private static PluginMain inst;

    public void onLoad(){
        inst = this;
    }
    public void onEnable(){
        getCommand("chat").setExecutor(new ChatCommand());
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }
    public void onDisable(){

    }
    public static PluginMain getInst(){
        return inst;
    }


}
