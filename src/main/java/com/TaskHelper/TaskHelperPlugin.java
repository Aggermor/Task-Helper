package com.TaskHelper;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import java.awt.*;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
		name = "Task Helper"
)
public class TaskHelperPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private TaskHelperConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MovementStatusOverlay movementStatusOverlay;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Task Helper started!");
		overlayManager.add(movementStatusOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Task Helper stopped!");
		overlayManager.remove(movementStatusOverlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			// Set color based on exampleBooleanConfig
			Color messageColor = config.exampleBooleanConfig() ? config.exampleColorConfig() : Color.DARK_GRAY;

			final String message = new ChatMessageBuilder()
					.append(Color.BLACK, "Task Helper: ")
					.append(messageColor, config.greeting())
					.build();

			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, null);
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event)
	{
		// Check if the animation is from the player
		if (event.getActor() != client.getLocalPlayer())
		{
			return;
		}

		// Get the current animation ID
		int animationID = event.getActor().getAnimation();

		// Ignore -1 animation ID
		if (animationID == -1) {
			return;
		}

		// Check if exampleBooleanConfig is true
		if (config.exampleBooleanConfig()) {
			// Get the color from the color config
			Color messageColor = config.exampleColorConfig();

			// Create a message with the animation ID and color
			final String message = new ChatMessageBuilder()
					.append(Color.BLACK, "Current animation ID: ")
					.append(messageColor, Integer.toString(animationID))
					.build();

			// Send the message
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", message, null);

			// Check if the animation ID matches the integer config
			if (animationID == config.exampleIntegerConfig()) {
				// Create a message
				String emoteMessage = "Nice emote!";

				// Send the message
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", emoteMessage, null);
			}
		}
	}


	@Provides
	TaskHelperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(TaskHelperConfig.class);
	}
}