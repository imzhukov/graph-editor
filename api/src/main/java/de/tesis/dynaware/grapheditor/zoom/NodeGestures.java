package de.tesis.dynaware.grapheditor.zoom;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * Listeners for making the nodes draggable via left mouse button. Considers if parent is zoomed.
 */

public class NodeGestures {

    private DragContext nodeDragContext = new DragContext();

    private static final int MARGIN = 8;
    private Node node;
    private ResizeState resizeState = ResizeState.DEFAULT;

    private PannableCanvas canvas;

    public NodeGestures( PannableCanvas canvas) {
        this.canvas = canvas;
    }

    public EventHandler<MouseEvent> getOnMousePressedEventHandler() {
        return onMousePressedEventHandler;
    }

    public EventHandler<MouseEvent> getOnMouseDraggedEventHandler() {
        return onMouseDraggedEventHandler;
    }

    public EventHandler<MouseEvent> getOnMouseMovedEventHandler() { return onMouseMovedEventHandler; }

    public EventHandler<MouseEvent> getOnMouseReleasedEventHandler() { return onMouseReleasedEventHandler; }

    private EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {

            // left mouse button => dragging
            if( !event.isPrimaryButtonDown())
                return;

            node = (Node) event.getSource();

            nodeDragContext.mouseAnchorX = event.getSceneX();
            nodeDragContext.mouseAnchorY = event.getSceneY();

            nodeDragContext.translateAnchorX = node.getTranslateX();
            nodeDragContext.translateAnchorY = node.getTranslateY();

            ResizeShape.setAnchor(node, nodeDragContext);
        }

    };

    private EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {

            // left mouse button => dragging
            if( !event.isPrimaryButtonDown())
                return;

            node = (Node) event.getSource();
            double scale = canvas.getScale();

            if(resizeState == ResizeState.DEFAULT) {
                node.setTranslateX(nodeDragContext.translateAnchorX + ((event.getSceneX() - nodeDragContext.mouseAnchorX) / scale));
                node.setTranslateY(nodeDragContext.translateAnchorY + ((event.getSceneY() - nodeDragContext.mouseAnchorY) / scale));
            } else {
                //resizing
                ResizeShape.resizing(node, resizeState, nodeDragContext, event.getSceneX(), event.getSceneY(), scale);
            }

            event.consume();
        }
    };

    private EventHandler<MouseEvent> onMouseMovedEventHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            node = (Node) event.getSource();
            resizeState = currentMouseState(event);
            Cursor cursor = getCursorForState(resizeState);
            node.setCursor(cursor);
        }
    };

    private EventHandler<MouseEvent> onMouseReleasedEventHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
            node = (Node) event.getSource();
            node.setCursor(Cursor.DEFAULT);
            resizeState = ResizeState.DEFAULT;
        }
    };

    private boolean isInResizeZone(MouseEvent event) {
        return isLeftResizeZone(event) || isRightResizeZone(event)
                || isBottomResizeZone(event) || isTopResizeZone(event);
    }

    private boolean isLeftResizeZone(MouseEvent event) {
        return intersect(0, event.getX());
    }

    private boolean isRightResizeZone(MouseEvent event) {
        return intersect(nodeW(), event.getX());
    }

    private boolean isTopResizeZone(MouseEvent event) {
        return intersect(0, event.getY());
    }

    private boolean isBottomResizeZone(MouseEvent event) {
        return intersect(nodeH(), event.getY());
    }

    private boolean intersect(double side, double point) {
        return side + MARGIN > point && side - MARGIN < point;
    }

    private double nodeW() {
        return node.getBoundsInParent().getWidth();
    }

    private double nodeH() {
        return node.getBoundsInParent().getHeight();
    }

    private ResizeState currentMouseState(MouseEvent event) {
        ResizeState state;
        boolean left = isLeftResizeZone(event);
        boolean right = isRightResizeZone(event);
        boolean top = isTopResizeZone(event);
        boolean bottom = isBottomResizeZone(event);

        if (left && top) state = ResizeState.NW_RESIZE;
        else if (left && bottom) state = ResizeState.SW_RESIZE;
        else if (right && top) state = ResizeState.NE_RESIZE;
        else if (right && bottom) state = ResizeState.SE_RESIZE;
        else if (right) state = ResizeState.E_RESIZE;
        else if (left) state = ResizeState.W_RESIZE;
        else if (top) state = ResizeState.N_RESIZE;
        else if (bottom) state = ResizeState.S_RESIZE;
        else state = ResizeState.DEFAULT;

        return state;
    }

    private static Cursor getCursorForState(ResizeState state) {
        switch (state) {
            case NW_RESIZE:
                return Cursor.NW_RESIZE;
            case SW_RESIZE:
                return Cursor.SW_RESIZE;
            case NE_RESIZE:
                return Cursor.NE_RESIZE;
            case SE_RESIZE:
                return Cursor.SE_RESIZE;
            case E_RESIZE:
                return Cursor.E_RESIZE;
            case W_RESIZE:
                return Cursor.W_RESIZE;
            case N_RESIZE:
                return Cursor.N_RESIZE;
            case S_RESIZE:
                return Cursor.S_RESIZE;
            default:
                return Cursor.DEFAULT;
        }
    }
}