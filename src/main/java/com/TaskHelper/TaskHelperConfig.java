package com.TaskHelper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Task Helper")
public interface TaskHelperConfig extends Config
{
	@ConfigItem(
		position = 1,
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The message to show to the user when they login"
	)
	default String greeting()
	{
		return "Hello";
	}

	// This is how you create a new config panel. I'm nto sure how to implement it into the plugin yet
	@ConfigItem(
			position = 2,
			keyName = "config2",
			name = "example of another config item checkbox", // how does it know it's a checkbox?
			description = "Configures whether or not this config is true or false"
	)
	default boolean config2()
	{
		return true;
	}
}