package com.TaskHelper;

import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import javax.inject.Inject;
import java.awt.*;

public class MovementStatusOverlay extends Overlay
{
    private final Client client;
    private WorldPoint lastWorldPoint;
    private long lastMoveTime;

    @Inject
    public MovementStatusOverlay(Client client)
    {
        this.client = client;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setMovable(true); // Make the overlay movable, redundant?
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        Player localPlayer = client.getLocalPlayer();
        if (localPlayer != null)
        {
            WorldPoint currentWorldPoint = localPlayer.getWorldLocation();
            String movementStatus = "Standing";
            Color textColor = Color.YELLOW;

            if (lastWorldPoint != null && !lastWorldPoint.equals(currentWorldPoint))
            {
                lastMoveTime = System.currentTimeMillis();
            }

            if (System.currentTimeMillis() - lastMoveTime < 1000) // 1000 milliseconds = 1 second
            {
                movementStatus = "Moving";
                textColor = Color.RED; // Change text color to red when moving
            }

            lastWorldPoint = currentWorldPoint;

            final String text = "Movement Status: " + movementStatus;
            final int textPadding = 4;
            final int textX = (int) (client.getCanvas().getWidth() / 2.5);
            final int textY = 20;

            final Color backgroundColor = new Color(0, 0, 0, 128);

            final int textHeight = 14;
            final int textWidth = graphics.getFontMetrics().stringWidth(text);

            graphics.setColor(backgroundColor);
            graphics.fillRect(textX - textPadding, textY - textHeight, textWidth + textPadding * 2, textHeight + textPadding * 2);

            graphics.setColor(textColor);
            graphics.drawString(text, textX, textY + textPadding);
        }

        return null;
    }
}
