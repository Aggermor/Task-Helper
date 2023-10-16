package com.RenameKitten;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class KittenRenamePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(RenameKittenPlugin.class);
		RuneLite.main(args);
	}
}
