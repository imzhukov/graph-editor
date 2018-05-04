package de.tesis.dynaware.grapheditor.zoom;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class FXRectangle extends Rectangle implements ResizeInterface {

    public FXRectangle() {
//        addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
//        addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());
//        addEventFilter( MouseEvent.MOUSE_MOVED, nodeGestures.getOnMouseMovedEventHandler());
//        addEventFilter( MouseEvent.MOUSE_RELEASED, nodeGestures.getOnMouseReleasedEventHandler());
    }

    @Override
    public void resizing(Node node, ResizeState resizeState, DragContext nodeDragContext, double sceneX, double sceneY, double scale) {
        Rectangle rectangle = (Rectangle) node;
        // Right Resize
        if (resizeState == ResizeState.E_RESIZE || resizeState == ResizeState.NE_RESIZE || resizeState == ResizeState.SE_RESIZE) {
            rectangle.setWidth(nodeDragContext.widthAnchorX + ((sceneX - nodeDragContext.mouseAnchorX) / scale));
        }
        // Left Resize
        if (resizeState == ResizeState.W_RESIZE || resizeState == ResizeState.NW_RESIZE || resizeState == ResizeState.SW_RESIZE) {
            rectangle.setWidth(nodeDragContext.widthAnchorX - ((sceneX - nodeDragContext.mouseAnchorX) / scale));
            rectangle.setTranslateX(nodeDragContext.translateAnchorX + ((sceneX - nodeDragContext.mouseAnchorX) / scale));
        }
        // Bottom Resize
        if (resizeState == ResizeState.S_RESIZE || resizeState == ResizeState.SE_RESIZE || resizeState == ResizeState.SW_RESIZE) {
            rectangle.setHeight(nodeDragContext.heightAnchorY + ((sceneY - nodeDragContext.mouseAnchorY) / scale));
        }
        // Top Resize
        if (resizeState == ResizeState.N_RESIZE || resizeState == ResizeState.NW_RESIZE || resizeState == ResizeState.NE_RESIZE) {
            rectangle.setHeight(nodeDragContext.heightAnchorY - ((sceneY - nodeDragContext.mouseAnchorY) / scale));
            rectangle.setTranslateY(nodeDragContext.translateAnchorY + ((sceneY - nodeDragContext.mouseAnchorY) / scale));
        }
    }

    @Override
    public void setAnchor(Node node, DragContext nodeDragContext) {

    }

    @Override
    public boolean isLeftResizeZone(MouseEvent event) {
        return intersect(0, event.getX());
    }

    @Override
    public boolean isRightResizeZone(MouseEvent event) {
        return false;
    }

    @Override
    public boolean isTopResizeZone(MouseEvent event) {
        return false;
    }

    @Override
    public boolean isBottomResizeZone(MouseEvent event) {
        return false;
    }

    @Override
    public double nodeW() {
        return 0;
    }

    @Override
    public double nodeH() {
        return 0;
    }
}
