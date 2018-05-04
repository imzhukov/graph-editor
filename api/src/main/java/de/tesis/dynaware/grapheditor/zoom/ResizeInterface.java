package de.tesis.dynaware.grapheditor.zoom;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public interface ResizeInterface {
    public void resizing(Node node, ResizeState resizeState,
                                DragContext nodeDragContext, double sceneX, double sceneY, double scale);

    public void setAnchor(Node node, DragContext nodeDragContext);

    public boolean isLeftResizeZone(MouseEvent event);

    public boolean isRightResizeZone(MouseEvent event);

    public boolean isTopResizeZone(MouseEvent event);

    public boolean isBottomResizeZone(MouseEvent event);

    public double nodeW();

    public double nodeH();

    public default boolean intersect(double side, double point) {
        return side + MARGIN > point && side - MARGIN < point;
    }

    public static final int MARGIN = 8;
}
