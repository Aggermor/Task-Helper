package com.Logger;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("Logger")
public interface LoggerConfig extends Config
{

	@ConfigItem(
			position = -1,
			keyName = "valueColor",
			name = "Log Value Color",
			description = "Pick a color to for the chat to color the value"
	)
	default Color customColorConfig() {
		return Color.RED;
	}

	@ConfigItem(
			keyName = "getTarget",
			name = "getTarget",
			description = "Log getTarget()"
	)
	default boolean exampleBooleanConfig() {
		return true;
	}
}