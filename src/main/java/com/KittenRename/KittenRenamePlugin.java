package com.KittenRename;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.*;

@Slf4j
@PluginDescriptor(
	name = "Kitten Rename",
	description = "Rename the Kitten that is following the local player",
	tags = {"kitten", "rename", "npc", "pet"},
	loadWhenOutdated = true,
	enabledByDefault = false
)

public class KittenRenamePlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private KittenRenameConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Task Helper started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Task Helper stopped!");
	}

	@Subscribe
	public void onMenuOpened(MenuOpened event)
	{
		// Log a message when menu opened-------------
		log.info("Menu Opened!");

		// Get all menu entries
		MenuEntry[] entries = client.getMenuEntries();

		// Get the local player
		Player localPlayer = client.getLocalPlayer();

		// Iterate over all entries
        for (MenuEntry entry : entries) {

			// Log the target of each menu entry---------
			log.info("Menu entry target: " + entry.getTarget());

            // Check if the target is "Kitten"
			if (entry.getTarget().contains("Kitten")) {

                // Get the NPC that corresponds to this menu entry
                NPC npc = client.getCachedNPCs()[entry.getIdentifier()];

                // Check if this NPC is interacting with the local player
                if (npc != null && npc.getInteracting() == localPlayer) {

					// Log a message before changing the target-------------------
					log.info("Changing target from " + entry.getTarget() + " to " + config.customNameConfig());

					// Modify the existing MenuEntry object
					Color color = config.customColorConfig();
					String hexColor = String.format("%06x", color.getRGB() & 0xFFFFFF);
					String colorTag = "<col=" + hexColor + ">";
					entry.setTarget(colorTag + config.customNameConfig()); // Set the new target with color

					// Log a message after changing the target----------------------
					log.info("Changed target to " + entry.getTarget());
                }
            }
        }

		// Set the updated entries array back to the client
		client.setMenuEntries(entries);
	}

	@Provides
    KittenRenameConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(KittenRenameConfig.class);
	}
}