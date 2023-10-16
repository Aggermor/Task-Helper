package com.Logger;

import com.TaskHelper.TaskHelperConfig;
import com.google.inject.Provides;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.awt.*;

@PluginDescriptor(
		name = "Logger",
		description = "Logs the target of each menu entry",
		tags = {"log", "menu", "entry", "target"},
		enabledByDefault = false
)
public class LoggerPlugin extends Plugin {
	private static final Logger log = LoggerFactory.getLogger(LoggerPlugin.class);

	@Inject
	private Client client;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private LoggerConfig config;

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		// Log a message when menu opened
		log.info("Menu Opened!");

		// Get all menu entries
		MenuEntry[] entries = client.getMenuEntries();
		// Iterate over all entries
		for (MenuEntry entry : entries) {

			// Log the target of each menu entry
			log.info("getOption: " + entry.getOption() + ", getTarget: " + entry.getTarget());

			// Get the target of each entry
			String option = entry.getOption();
			String target = entry.getTarget();

			if (config.exampleBooleanConfig()) {
				Color messageColor = config.customColorConfig();

				final String message = new ChatMessageBuilder()
						.append(Color.BLACK, "Logger:")
						.append(Color.BLACK, " getOption = ")
						.append(messageColor, option)
						.append(Color.BLACK, ", getTarget = ")
						.append(messageColor, target) // value.toString() if not string
						.build();

				// Send the message
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, null);
			}
		}
	}

	@Provides
	LoggerConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(LoggerConfig.class);
	}
}
