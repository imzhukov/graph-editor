package de.tesis.dynaware.grapheditor.zoom;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class ResizeShape {
    public static void resizing(Node node, ResizeState resizeState,
                                DragContext nodeDragContext, double sceneX, double sceneY, double scale) {
        if(node instanceof Rectangle) {
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
    }

    public static void setAnchor(Node node, DragContext nodeDragContext) {
        if(node instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) node;
            nodeDragContext.widthAnchorX = rectangle.getWidth();
            nodeDragContext.heightAnchorY = rectangle.getHeight();
        }
    }
}
