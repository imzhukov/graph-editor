package de.tesis.dynaware.grapheditor.zoom;

import javafx.event.EventHandler;
import javafx.scene.input.*;

/**
 * Listeners for making the scene's canvas draggable and zoomable
 */
public class SceneGestures {

    private static final double MAX_SCALE = 10.0d;
    private static final double MIN_SCALE = .1d;

    private final KeyCombination keyComb1 = new KeyCodeCombination(
            KeyCode.NUMPAD0,
            KeyCombination.CONTROL_DOWN
    );

    private final KeyCombination keyComb2 = new KeyCodeCombination(
            KeyCode.DIGIT0,
            KeyCombination.CONTROL_DOWN
    );

    private DragContext sceneDragContext = new DragContext();

    PannableCanvas canvas;

    public SceneGestures( PannableCanvas canvas) {
        this.canvas = canvas;
    }

    public EventHandler<MouseEvent> getOnMousePressedEventHandler() {
        return onMousePressedEventHandler;
    }

    public EventHandler<MouseEvent> getOnMouseDraggedEventHandler() {
        return onMouseDraggedEventHandler;
    }

    public EventHandler<ScrollEvent> getOnScrollEventHandler() {
        return onScrollEventHandler;
    }

    public EventHandler<KeyEvent> getOnCombinationEventHandler() {
        return onCombinationEventHandler;
    }

    private EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {

            // right mouse button => panning
            if( !event.isSecondaryButtonDown())
                return;

            sceneDragContext.mouseAnchorX = event.getSceneX();
            sceneDragContext.mouseAnchorY = event.getSceneY();

            sceneDragContext.translateAnchorX = canvas.getTranslateX();
            sceneDragContext.translateAnchorY = canvas.getTranslateY();

        }

    };

    private EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {

            // right mouse button => panning
            if( !event.isSecondaryButtonDown())
                return;

            canvas.setTranslateX(sceneDragContext.translateAnchorX + event.getSceneX() - sceneDragContext.mouseAnchorX);
            canvas.setTranslateY(sceneDragContext.translateAnchorY + event.getSceneY() - sceneDragContext.mouseAnchorY);

            event.consume();
        }
    };

    /**
     * Mouse wheel handler: zoom to pivot point
     */
    private EventHandler<ScrollEvent> onScrollEventHandler = new EventHandler<ScrollEvent>() {

        @Override
        public void handle(ScrollEvent event) {
            if (event.isControlDown()) {
                double delta = 1.2;

                double scale = canvas.getScale(); // currently we only use Y, same value is used for X
                double oldScale = scale;

                if (event.getDeltaY() < 0)
                    scale /= delta;
                else
                    scale *= delta;

                scale = clamp( scale, MIN_SCALE, MAX_SCALE);

                double f = (scale / oldScale)-1;

                double dx = (event.getSceneX() - (canvas.getBoundsInParent().getWidth()/2 + canvas.getBoundsInParent().getMinX()));
                double dy = (event.getSceneY() - (canvas.getBoundsInParent().getHeight()/2 + canvas.getBoundsInParent().getMinY()));

                canvas.setScale( scale);

                // note: pivot value must be untransformed, i. e. without scaling
                canvas.setPivot(f*dx, f*dy);

                event.consume();
            } else if (event.isShiftDown()) {
                double newPos = canvas.getTranslateX() + event.getDeltaX()*canvas.getScale();
                canvas.setTranslateX(newPos);
            } else {
                double newPos = canvas.getTranslateY() + event.getDeltaY()*canvas.getScale();
                canvas.setTranslateY(newPos);
            }
        }

    };

    public static double clamp( double value, double min, double max) {

        if( Double.compare(value, min) < 0)
            return min;

        if( Double.compare(value, max) > 0)
            return max;

        return value;
    }

    private EventHandler<KeyEvent> onCombinationEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (keyComb1.match(event)
                || keyComb2.match(event)) {
                canvas.setScale(1.0);
                canvas.setTranslateX(0.0);
                canvas.setTranslateY(0.0);
            }
        }
    };
}