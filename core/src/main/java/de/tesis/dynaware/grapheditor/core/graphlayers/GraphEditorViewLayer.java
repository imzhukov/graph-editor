package de.tesis.dynaware.grapheditor.core.graphlayers;

import de.tesis.dynaware.grapheditor.core.view.ConnectionLayouter;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 * A layer inside the graph editor view. Used for grouping elements together in the z-direction.
 *
 * <p>
 * All connections are redrawn when the children of a view layer are layed out.
 * </p>
 */
public class GraphEditorViewLayer extends Region {
    private ConnectionLayouter connectionLayouter;

    @Override
    public ObservableList<Node> getChildren() {
        return super.getChildren();
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        if (connectionLayouter != null) {
            connectionLayouter.redraw(true);
        }
    }

    public ConnectionLayouter getConnectionLayouter() {
        return connectionLayouter;
    }

    public void setConnectionLayouter(ConnectionLayouter connectionLayouter) {
        this.connectionLayouter = connectionLayouter;
    }
}

