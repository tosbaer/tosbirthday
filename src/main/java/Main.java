import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    private static final String DISCORD_TOKEN = "NjA5MDcxNzc3ODM0MDc0MTMy.XU0Kzw.45qcLimIK_OHQz4xL6iW1ITE4Oo";
    private static final String PERMISSION = "515136";

    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(DISCORD_TOKEN);
        builder.addEventListener(new Main());
        try {
            builder.buildAsync();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if( event.getAuthor().isBot()) {
            return;
        }
        System.err.println("Received " + event.getAuthor());
        event.getChannel().sendMessage("Test");
        if( event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("Pong!");
        }
    }
}
