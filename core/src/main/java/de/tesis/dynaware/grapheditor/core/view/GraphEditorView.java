/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package de.tesis.dynaware.grapheditor.core.view;

import de.tesis.dynaware.grapheditor.GConnectionSkin;
import de.tesis.dynaware.grapheditor.GJointSkin;
import de.tesis.dynaware.grapheditor.GNodeSkin;
import de.tesis.dynaware.grapheditor.GTailSkin;
import de.tesis.dynaware.grapheditor.core.DefaultGraphEditor;
import de.tesis.dynaware.grapheditor.core.graphlayers.GraphEditorViewLayer;
import de.tesis.dynaware.grapheditor.utils.EventHandlersManager;
import de.tesis.dynaware.grapheditor.utils.GraphEditorProperties;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.util.Comparator;
import java.util.HashMap;

/**
 * The {@link Region} that all visual elements in the graph editor are added to.
 *
 * <p>
 * There is one instance of this class per {@link DefaultGraphEditor}. It is the outermost JavaFX node of the editor.
 * </p>
 *
 * <p>
 * The view currently has two layers - a <b>node</b> layer and a <b>connection</b> layer. The node layer is in front.
 * Graph nodes are added to the node layer, while connections, joints, and tails are added to the connection layer. This
 * means nodes will always be in front of connections.
 * </p>
 *
 * <p>
 * Calling toFront() or toBack() on the associated JavaFX nodes will just reposition them inside their layer. The layers
 * always have the same dimensions as the editor region itself.
 * </p>
 */
public class GraphEditorView extends Region {

    private static final String NODE_PROP_Z_INDEX = "CUSTOM_Z_INDEX";
    private static final String STYLESHEET_VIEW = "view.css";
    private static final String STYLESHEET_DEFAULTS = "defaults.css";

    private static final String STYLE_CLASS = "graph-editor";
    private static final String STYLE_CLASS_NODE_LAYER = "graph-editor-node-layer";
    private static final String STYLE_CLASS_CONNECTION_LAYER = "graph-editor-connection-layer";

    private static final String NODE_LAYER_ID = "nodeLayer";
    private static final String CONNECTION_LAYER_ID = "connectionLayer";

    private final GraphEditorViewLayer nodeLayer = new GraphEditorViewLayer();
    private final GraphEditorViewLayer connectionLayer = new GraphEditorViewLayer();

    private final GraphEditorGrid grid = new GraphEditorGrid();
    private ConnectionLayouter connectionLayouter;

    private final SelectionBox selectionBox = new SelectionBox();

    public EventHandlersManager eventHandlersManager = new EventHandlersManager(this);

    private GraphEditorProperties editorProperties;
    private Comparator<Node> comparator = (o1, o2) -> {
        Object o1Z = o1.getProperties().get(NODE_PROP_Z_INDEX);
        Object o2Z = o2.getProperties().get(NODE_PROP_Z_INDEX);
        int z1, z2;
        z1 = o1Z == null ? 0 : (int) o1Z;
        z2 = o2Z == null ? 0 : (int) o2Z;
        return z1 - z2;
    };

    /**
     * Creates a new {@link GraphEditorView} to which skin instances can be added and removed.
     */
    public GraphEditorView() {

        getStylesheets().add(GraphEditorView.class.getResource(STYLESHEET_VIEW).toExternalForm());
        getStylesheets().add(GraphEditorView.class.getResource(STYLESHEET_DEFAULTS).toExternalForm());

        getStyleClass().addAll(STYLE_CLASS);

        setMaxWidth(GraphEditorProperties.DEFAULT_MAX_WIDTH);
        setMaxHeight(GraphEditorProperties.DEFAULT_MAX_HEIGHT);

        initializeLayers();
        initializeGrid();

        getChildren().add(selectionBox);
    }

    public ConnectionLayouter getConnectionLayouter(){
        return connectionLayouter;
    }

    /**
     * Sets the connection-layouter to be used by the view.
     *
     * @param connectionLayouter the graph editor's {@link ConnectionLayouter} instance
     */
    public void setConnectionLayouter(final ConnectionLayouter connectionLayouter) {
        this.connectionLayouter = connectionLayouter;
        getChildren().forEach(node -> {
            if (node instanceof GraphEditorViewLayer) {
                ((GraphEditorViewLayer) node).setConnectionLayouter(connectionLayouter);
            }
        });
    }

    /**
     * Clears all elements from the view.
     */
    public void clear() {
        getChildren().forEach(elem -> {
            if (elem instanceof GraphEditorViewLayer) {
                ((GraphEditorViewLayer) elem).getChildren().clear();
            }
        });
    }

    /**
     * Adds a node skin to the view.
     *
     * @param nodeSkin the {@link GNodeSkin} instance to be added
     */
    public void add(final GNodeSkin nodeSkin) {
        nodeLayer.getChildren().add(nodeSkin.getRoot());
    }

    /**
     * Adds a connection skin to the view.
     *
     * @param connectionSkin the {@link GConnectionSkin} instance to be added
     */
    public void add(final GConnectionSkin connectionSkin) {
        connectionLayer.getChildren().add(connectionSkin.getRoot());
    }

    /**
     * Adds a joint skin to the view.
     *
     * @param jointSkin the {@link GJointSkin} instance to be added
     */
    public void add(final GJointSkin jointSkin) {
        connectionLayer.getChildren().add(jointSkin.getRoot());
    }

    /**
     * Adds a tail skin to the view.
     *
     * @param tailSkin the {@link GTailSkin} instance to be added
     */
    public void add(final GTailSkin tailSkin) {
        connectionLayer.getChildren().add(tailSkin.getRoot());
    }

    /**
     * Removes a node skin from the view. Does nothing if the skin is not present.
     *
     * @param nodeSkin the {@link GNodeSkin} instance to remove
     */
    public void remove(final GNodeSkin nodeSkin) {
        nodeLayer.getChildren().remove(nodeSkin.getRoot());
    }

    /**
     * Removes a connection skin from the view. Does nothing if the skin is not present.
     *
     * @param connectionSkin the {@link GConnectionSkin} instance to remove
     */
    public void remove(final GConnectionSkin connectionSkin) {
        connectionLayer.getChildren().remove(connectionSkin.getRoot());
    }

    /**
     * Removes a joint skin from the view. Does nothing if the skin is not present.
     *
     * @param jointSkin the {@link GJointSkin} instance to remove
     */
    public void remove(final GJointSkin jointSkin) {
        connectionLayer.getChildren().remove(jointSkin.getRoot());
    }

    /**
     * Removes a tail skin from the view. Does nothing if the skin is not present.
     *
     * @param tailSkin the {@link GTailSkin} instance to remove
     */
    public void remove(final GTailSkin tailSkin) {
        connectionLayer.getChildren().remove(tailSkin.getRoot());
    }

    /**
     * Sets the layout properties of the view.
     *
     * <p>
     * This is used specify information like whether the grid should be shown and/or snapped to.
     * </p>
     *
     * @param editorProperties the {@link GraphEditorProperties} instance to be used by the view
     */
    public void setEditorProperties(final GraphEditorProperties editorProperties) {

        this.editorProperties = editorProperties;

        grid.setProperties(editorProperties);
        grid.setVisible(editorProperties.isGridVisible());

        editorProperties.gridVisibleProperty().addListener((v, o, n) -> grid.setVisible(n));
        editorProperties.XgridSpacingProperty().addListener((v, o, n) -> grid.draw(getWidth(), getHeight()));
        editorProperties.YgridSpacingProperty().addListener((v, o, n) -> grid.draw(getWidth(), getHeight()));
    }

    /**
     * Gets the editor properties instance used by the view.
     *
     * @return editorProperties the {@link GraphEditorProperties} instance used by the view
     */
    public GraphEditorProperties getEditorProperties() {
        return editorProperties;
    }

    /**
     * Draws a selection box in the view.
     *
     * @param x the x position of the selection box
     * @param y the y position of the selection box
     * @param width the width of the selection box
     * @param height the height of the selection box
     */
    public void drawSelectionBox(final double x, final double y, final double width, final double height) {
        selectionBox.draw(x, y, width, height);
    }

    /**
     * Hides the selection box.
     */
    public void hideSelectionBox() {
        selectionBox.setVisible(false);
    }

    /**
     * Enables / disables caching of the view content (node and connection layers).
     *
     * <p>
     * This increases performance if the content does not need to be redrawn. It <b>decreases</b> performance when the
     * content is redrawn. Use with care.
     * </p>
     * 
     * <p>
     * <b>Note:</b> Currently leads to poor performance when scale transforms are used, or on retina displays.
     * </p>
     *
     * @param cache {@code true} to enable caching, {@code false} to disable it
     */
    public void setContentCache(final boolean cache) {
        getChildren().forEach(elem -> {
            if (elem instanceof GraphEditorViewLayer) {
                elem.setCache(cache);
            }
        });
    }

    @Override
    protected void layoutChildren() {
        getChildren().forEach(elem -> {
            if (elem instanceof GraphEditorViewLayer) {
//                if (elem.getId().equals(NODE_LAYER_ID)
//                    || elem.getId().equals(CONNECTION_LAYER_ID)
//                ) {
                    elem.resizeRelocate(0, 0, getWidth(), getHeight());
//                }
            }
        });
    }

    /**
     * Gets the EventHandlersManager that provide additional control of handlers
     * */
    public EventHandlersManager getEventHandlersManager(){ return this.eventHandlersManager; }

    /**
     * Adds a listener to the width and height properties of the view to tell the grid to redraw.
     */
    private void initializeGrid() {

        getChildren().add(grid);
        grid.toBack();

        widthProperty().addListener((v, o, n) -> grid.draw(getWidth(), getHeight()));
        heightProperty().addListener((v, o, n) -> grid.draw(getWidth(), getHeight()));
    }

    public void addLayer(String layerId, GraphEditorViewLayer layer, String cssClass, int zIndex) {
        layer.setPickOnBounds(false);
        layer.cacheHintProperty().set(CacheHint.SPEED);
        layer.getStyleClass().addAll(cssClass);
        layer.setId(layerId);
        layer.getProperties().put(NODE_PROP_Z_INDEX, zIndex);
        getChildren().add(layer);

        FXCollections.sort(getChildren(), comparator);
    }

    public GraphEditorViewLayer getLayer(String layerId) {
        for (Node node : getChildren()) {
            if (node.getId() != null && node.getId().equals(layerId)) {
                return (GraphEditorViewLayer) node;
            }
        }
        return null;
    }

    public void removeLayer(String layerId) {
        GraphEditorViewLayer layer = getLayer(layerId);
        if (layer != null) {
            getChildren().remove(layer);
        }
    }

    /**
     * Initializes the two layers (node and connection) that the view is composed of.
     */
    public void initializeLayers() {
        addLayer(NODE_LAYER_ID, nodeLayer, STYLE_CLASS_NODE_LAYER, 10001);
        addLayer(CONNECTION_LAYER_ID, connectionLayer, STYLE_CLASS_CONNECTION_LAYER, 10000);

        fitToView(NODE_LAYER_ID);
        fitToView(CONNECTION_LAYER_ID);
    }

    public void fitToView(String layerId) {
        getChildren().forEach(node -> {
            if (node.getId() != null && node.getId().equals(layerId)) {
                ((GraphEditorViewLayer) node).maxWidthProperty().bind(maxWidthProperty());
                ((GraphEditorViewLayer) node).maxHeightProperty().bind(maxHeightProperty());
                ((GraphEditorViewLayer) node).minWidthProperty().bind(minWidthProperty());
                ((GraphEditorViewLayer) node).minHeightProperty().bind(minHeightProperty());
            }
        });
    }
}