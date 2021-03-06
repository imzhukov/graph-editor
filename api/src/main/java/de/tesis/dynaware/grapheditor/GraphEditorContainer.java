/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package de.tesis.dynaware.grapheditor;

import de.tesis.dynaware.grapheditor.zoom.ZoomService;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.window.AutoScrollingWindow;
import de.tesis.dynaware.grapheditor.window.GraphEditorMinimap;

/**
 * A container for the graph editor.
 *
 * <p>
 * This is intended for graphs that can be larger than the space available in the scene. The user can pan around by
 * right-clicking and dragging. A minimap can be shown to help with navigation.
 * </p>
 *
 * <p>
 * Example:
 *
 * <pre>
 * <code>GraphEditorContainer graphEditorContainer = new GraphEditorContainer();
 * GraphEditor graphEditor = new DefaultGraphEditor();
 * 
 * graphEditorContainer.setGraphEditor(graphEditor);
 * graphEditorContainer.getMinimap().setVisible(true);</code>
 * </pre>
 *
 * The graph editor container is a {@link Region} and can be added to the JavaFX scene graph in the usual way.
 * </p>
 *
 * <p>
 * When a {@link GraphEditor} is set inside this container, its view becomes <b>unmanaged</b> and its width and height
 * values are set to those in the {@link GModel} instance.
 * </p>
 */
public class GraphEditorContainer extends AutoScrollingWindow {

    // Minimap height is not specified here, the minimap's aspect ratio is fixed by the aspect ratio of the content.
    private static final double MINIMAP_WIDTH = 250;
    private static final double MINIMAP_RIGHT_INDENT = 10;
    private static final double MINIMAP_TOP_INDENT = 10;

    private GraphEditorMinimap minimap;

    private GraphEditor graphEditor;
    private ChangeListener<GModel> modelChangeListener;
    private Region content = new Region();

    /**
     * Creates a new {@link GraphEditorContainer}.
     */
    protected static final int NODE_INITIAL_X = 19;
    protected static final int NODE_INITIAL_Y = 19;

    public GraphEditorContainer() {
        initializeMinimap();
        createModelChangeListener();
        this.setStyle("-fx-background-color: lightgrey");
//        minimap = new GraphEditorMinimap(MINIMAP_WIDTH);
    }

    /**
     * Sets the graph editor to be displayed in this container.
     *
     * @param graphEditor a {@link GraphEditor} instance
     */
    public void setGraphEditor(final GraphEditor graphEditor) {

        if (this.graphEditor != null) {
            this.graphEditor.modelProperty().removeListener(modelChangeListener);
            //this.graphEditor.getView().setOnScroll(null);
        }

        this.graphEditor = graphEditor;

        if (graphEditor != null) {

            //graphEditor.modelProperty().addListener(modelChangeListener);

            final Region view = graphEditor.getView();
            final GModel model = graphEditor.getModel();
            final SkinLookup skinLookup = graphEditor.getSkinLookup();

            if (model != null) {
                view.resize(model.getContentWidth(), model.getContentHeight());
            }

            setContent(view);
//            minimap.setContent(view);
//            minimap.setModel(model);
//            minimap.setSkinLookup(skinLookup);

            view.toBack();
            //view.setOnScroll(event -> panBy(-event.getDeltaX(), -event.getDeltaY()));

        } else {
//            minimap.setContent(null);
//            minimap.setModel(null);
        }
    }

    /**
     * Gets the {@link Pane} representing the graph editor minimap.
     * 
     * <p>
     * <b>Note:</b> customisation of the minimap's content and layout has not been extensively tested.
     * </p>
     *
     * @return the graph editor minimap
     */
    public Pane getMinimap() {
        return minimap;
    }

    @Override
    public void setContent(Region content){
        super.setContent(content);
        this.content = content;
    }

    @Override
    public void checkWindowBounds(){
        if(content != null && !ZoomService.freeScalingProperty().getValue()){
            if (windowXProperty().get() < 0) {
                windowXProperty().set(0);
            }

            if (windowYProperty().get() < 0) {
                windowYProperty().set(0);
            }

            final double zoomFactor = content.getLocalToSceneTransform().getMxx();
            final double maxX = zoomFactor * content.getWidth() - getWidth();
            final double maxY = zoomFactor * content.getHeight() - getHeight();

            if (windowXProperty().get() > maxX) {
                if (maxX < 0) //If the size of the visible area is greater than the size of the scaled content, we do equal margins on both sides
                    windowXProperty().set(maxX/2);
                else
                    windowXProperty().set(maxX);
            }


            if (windowYProperty().get() > maxY) {
                if (maxY < 0) //If the size of the visible area is greater than the size of the scaled content, we do equal margins on both sides
                    windowYProperty().set(maxY/2);
                else
                    windowYProperty().set(maxY);
            }

            windowXProperty().set(Math.round(windowXProperty().get()));
            windowYProperty().set(Math.round(windowYProperty().get()));
        }
    }

    /**
     * Initializes the minimap, adding it as a child of the container and setting its position.
     */
    private void initializeMinimap() {

//        getChildren().add(minimap);
//
//        minimap.setWindow(this);
//        minimap.layoutXProperty().bind(widthProperty().subtract(MINIMAP_WIDTH + MINIMAP_RIGHT_INDENT));
//        minimap.setLayoutY(MINIMAP_TOP_INDENT);
//        minimap.setVisible(false);
    }

    /**
     * This listener updates the minimap with the new model each time one is set in the {@link GraphEditor} instance.
     */
    private void createModelChangeListener() {

//        modelChangeListener = (ChangeListener<GModel>) (observable, oldValue, newValue) -> {
//            if (newValue == null || (newValue != null && !newValue.equals(oldValue))) {
//                graphEditor.getView().resize(newValue.getContentWidth(), newValue.getContentHeight());
//                checkWindowBounds();
//                minimap.setModel(newValue);
//            }
//        };
    }
}
