package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateBoostTimeEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import net.dv8tion.jda.api.utils.data.DataObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

public class Boost extends ListenerAdapter {

    public void onGuildMemberUpdateBoostTime (GuildMemberUpdateBoostTimeEvent event)  {

        EmbedBuilder bauplan = new EmbedBuilder();

        bauplan.setTitle("\uD83E\uDD73 │ **VIELEN DANK FÜR DEINE UNTERSTÜTZUNG ** │ :sparkles: ");
        bauplan.setDescription("");
        bauplan.setThumbnail("https://cdn.discordapp.com/attachments/1007023755383537694/1017122672360046683/boost.png");


    }

    public void onMessageReceived (MessageReceivedEvent text) {

        if (text.getMessage().getContentStripped().equals("!boosttest")) {

            EmbedBuilder bauplan1 = new EmbedBuilder();

            bauplan1.setTitle(":sparkles: │ **_VIELEN DANK FÜR DEINE UNTERSTÜTZUNG_ │ :sparkles:**");
            bauplan1.setDescription("> Unser Server Team  dankt dir für dein/-e Boost/-st ! Er unterstützt uns! Jetzt kannst du deine Belohnungen in Anspruch nehmen :  \n \n **Was gibt es für Belohnungen? :**\n  <:pfeil:1017141213188608083> dein Eigenen Bot  \n" +
                    "<:pfeil:1017141213188608083> dein eigener Channel  \n" +
                    "<:pfeil:1017141213188608083> dein eigener Command \n <:pfeil:1017141213188608083> exklusiver Booster Rang\n \n**Wie bekomme ich meine Belohnungen? :**  \n > Du musst unter der Nachricht den Button drücken ! ");
            bauplan1.setThumbnail("https://cdn.discordapp.com/attachments/1007023755383537694/1017122672360046683/boost.png");
            bauplan1.setColor(0xf47fff);

            Button button = Button.success("Belohnungen", "Bekomme deine Behlonungen!").withEmoji(Emoji.fromFormatted("\uD83C\uDF81"));

            text.getChannel().sendTyping().queue();
            text.getChannel().sendMessageEmbeds(bauplan1.build()).setActionRow(button).queue();


        }

    }
    public void onButtonInteraction (ButtonInteractionEvent event) {

        EmbedBuilder bauplan2 = new EmbedBuilder();

        bauplan2.setColor(0x87cfbd);
        bauplan2.setTitle(":sparkles: │**WELCHE BELOHNUNG WILLST DU ?**");
        bauplan2.setDescription("> Klicke auf den Button unter der Nachricht!");

        Button button1 = Button.link("https://discord.gg/HpNrC3v8", "Hier!").withEmoji(Emoji.fromFormatted("\uD83C\uDF81"));

        if (event.getButton().getId().equals("Belohnungen")) {

            Guild guild = event.getGuild();
            ((TextChannel)guild.createTextChannel("[\uD83C\uDF81]" + event.getMember().getEffectiveName(), event.getGuild().getCategoryById("1017483975490543616")).addPermissionOverride(event.getMember(), EnumSet.of(Permission.VIEW_CHANNEL), (Collection)null).addPermissionOverride(guild.getRoleById("1002128386954625044"), EnumSet.of(Permission.VIEW_CHANNEL), (Collection)null).addPermissionOverride(guild.getPublicRole(), (Collection)null, EnumSet.of(Permission.VIEW_CHANNEL)).complete()).sendMessage("<@&1002128386954625044>").queue();
            event.replyEmbeds(bauplan2.build()).setEphemeral(true).queue();

        }

    }
}
