package pl.polskipalacz.chat.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import pl.polskipalacz.chat.PluginMain;
import pl.polskipalacz.chat.managers.ChatManager;
import pl.polskipalacz.chat.utils.ChatUtil;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent chat){
        Player p = chat.getPlayer();
        if(p.hasPermission("chat.vip")||p.isOp()){
            return;
        }
        if(!ChatManager.isChat()){
            p.sendMessage(ChatUtil.fixColor(PluginMain.getInst().getConfig().getString("messages.chat-is-off")));
            chat.setCancelled(true);
        }
    }

}
