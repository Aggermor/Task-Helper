package com.TaskHelper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

import java.awt.Color;

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

	// Boolean Checkbox
	@ConfigItem(
			keyName = "configBoolean",
			name = "Boolean Config Item",
			description = "This is an example of a boolean config item"
	)
	default boolean exampleBooleanConfig() {
		return true;
	}

	// Integer Range
	@ConfigItem(
			keyName = "configInteger",
			name = "Integer Config Item",
			description = "This is an example of an integer config item"
	)
	@Range(
			min = 1,
			max = 10000
	)
	default int exampleIntegerConfig() {
		return 1;
	}

	// String Text Box
	@ConfigItem(
			keyName = "configString",
			name = "String Config Item",
			description = "This is an example of a string config item"
	)
	default String exampleStringConfig() {
		return "default";
	}

	// Color Picker
	@ConfigItem(
			keyName = "configColor",
			name = "Color Config Item",
			description = "This is an example of a color config item"
	)
	default Color exampleColorConfig() {
		return Color.WHITE;
	}

	// Enum  Drop-Down
	public enum ExampleEnum {
		VALUE1,
		VALUE2,
		VALUE3
	}
	@ConfigItem(
			keyName = "configEnum",
			name = "Enum Config Item",
			description = "This is an example of an enum config item"
	)
	default ExampleEnum exampleEnumConfig() {
		return ExampleEnum.VALUE1;
	}
}