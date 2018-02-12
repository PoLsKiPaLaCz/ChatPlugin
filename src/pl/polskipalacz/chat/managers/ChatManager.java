package pl.polskipalacz.chat.managers;

public class ChatManager {

    private static boolean chat = true;

    public static boolean isChat(){
        return chat;
    }

    public static void setChat(boolean c){
        chat = c;
    }

}
