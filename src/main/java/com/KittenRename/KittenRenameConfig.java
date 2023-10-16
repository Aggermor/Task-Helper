package com.KittenRename;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("Kitten Rename")
public interface KittenRenameConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "customName",
			name = "Custom Name",
			description = "Custom name to rename a Kitten that follows the local player"
	)
	default String customNameConfig() {
		return "Kitten";
	}

	@ConfigItem(
			position = 2,
			keyName = "customColor",
			name = "Custom Color",
			description = "Pick a color to for the text your custom name will have"
	)
	default Color customColorConfig() {
		return Color.YELLOW;
	}
}