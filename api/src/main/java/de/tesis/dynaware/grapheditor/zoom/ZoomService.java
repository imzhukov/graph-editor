package de.tesis.dynaware.grapheditor.zoom;

import de.tesis.dynaware.grapheditor.GraphEditor;
import de.tesis.dynaware.grapheditor.GraphEditorContainer;
import de.tesis.dynaware.grapheditor.window.WindowPosition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.transform.Scale;

public class ZoomService {
    private static final double MAX_SCALE = 10.0d;
    private double MIN_SCALE = 0.0;
    private double currentZoomFactor = 1.0D;

    /** Combination to restore view */
    private final KeyCombination keyComb1 = new KeyCodeCombination(
            KeyCode.NUMPAD0,
            KeyCombination.CONTROL_DOWN
    );
    private final KeyCombination keyComb2 = new KeyCodeCombination(
            KeyCode.DIGIT0,
            KeyCombination.CONTROL_DOWN
    );

    /** Inner links */
    private GraphEditor graphEditor;
    private GraphEditorContainer graphEditorContainer;
    private Scale scaleTransform;
    private Scene graphHolder = null;

    public ZoomService(GraphEditor graphEditor, GraphEditorContainer graphEditorContainer) {
        this.graphEditor = graphEditor;
        this.graphEditorContainer = graphEditorContainer;

        this.graphEditorContainer.addEventFilter(ScrollEvent.ANY, this.onScrollEventHandler);

        scaleTransform = new Scale(currentZoomFactor, currentZoomFactor, 0, 0);
        scaleTransform.yProperty().bind(scaleTransform.xProperty());

        this.graphEditor.getView().getTransforms().add(scaleTransform);
    }

    // Only works with javafx Scene
    public void addKeyCombinationListener(Scene scene) {
        this.graphHolder = scene;
        this.graphHolder.addEventFilter(KeyEvent.KEY_RELEASED, this.onCombinationEventHandler);
    }

    public void removeFilters() {
        graphEditorContainer.removeEventFilter(ScrollEvent.ANY, this.onScrollEventHandler);
        if (graphHolder != null) {
            graphHolder.removeEventFilter(KeyEvent.KEY_RELEASED, this.onCombinationEventHandler);
        }
    }

    public double getCurrentZoomFactor() {
        return currentZoomFactor;
    }

    /**
     * Mouse wheel handler: zoom to pivot point
     */
    private EventHandler<ScrollEvent> onScrollEventHandler = new EventHandler<ScrollEvent>() {
        public void handle(ScrollEvent event) {
            if (MIN_SCALE == 0.0) {
                MIN_SCALE = Math.min(
                        Math.ceil(graphEditorContainer.getWidth() / graphEditor.getView().getWidth() * 10)/10D,
                        Math.ceil(graphEditorContainer.getHeight() / graphEditor.getView().getHeight() * 10)/10D
                );
            }

            if (event.isControlDown()) {
                double delta = 1.2;

                double scale = currentZoomFactor; // currently we only use Y, same value is used for X
                double oldScale = scale;

                if (event.getDeltaY() < 0)
                    scale /= delta;
                else
                    scale *= delta;

                final double f = (scale / oldScale)-1;
                scale = clamp(scale, MIN_SCALE, MAX_SCALE);
                if (scale == MAX_SCALE) {
                    event.consume();
                    return;
                }

                final double mouseX = event.getSceneX() - graphEditor.getView().getBoundsInParent().getMinX();
                final double mouseY = event.getSceneY() - graphEditor.getView().getBoundsInParent().getMinY();

                final double startX = graphEditorContainer.windowXProperty().get();
                final double startY = graphEditorContainer.windowYProperty().get();

                final double dx = mouseX - startX;
                final double dy = mouseY - startY;

                scaleTransform.setX(scale);
                currentZoomFactor = scale;

                final double newStartX = startX + startX*f;
                final double newStartY = startY + startY*f;

                graphEditorContainer.panTo(newStartX + f*dx, newStartY + f*dy);
                event.consume();
            } else if (event.isShiftDown()) {
                double newPos = graphEditorContainer.windowXProperty().get() + event.getDeltaX() * currentZoomFactor;
                graphEditorContainer.panTo(newPos, graphEditorContainer.windowYProperty().get());
            } else {
                double newPos = graphEditorContainer.windowYProperty().get() - event.getDeltaY() * currentZoomFactor;
                graphEditorContainer.panTo(graphEditorContainer.windowXProperty().get(), newPos);
            }
        }
    };

    private static double clamp( double value, double min, double max) {

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
                scaleTransform.setX(1.0);
                currentZoomFactor = 1.0d;
                graphEditorContainer.panTo(WindowPosition.CENTER);
            }
        }
    };
}
