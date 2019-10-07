/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package de.tesis.dynaware.grapheditor.core.skins.defaults;

import de.tesis.dynaware.grapheditor.model.GNode;
import javafx.beans.value.ChangeListener;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.geometry.Point2D;
import de.tesis.dynaware.grapheditor.GJointSkin;
import de.tesis.dynaware.grapheditor.model.GJoint;
import de.tesis.dynaware.grapheditor.utils.DraggableBox;
import javafx.scene.input.MouseEvent;

/**
 * The default joint skin.
 *
 * <p>
 * Pretty much just a {@link DraggableBox} with some hover and pressed effects.
 * </p>
 */
public class DefaultJointSkin extends GJointSkin {

    private static final String STYLE_CLASS = "default-joint";

    private static final PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("selected");

    private static final double SIZE = 12;
    private static final double SNAP_OFFSET = -5;

    /**
     * Creates a new default join instance.
     *
     * @param joint the {@link GJoint} the skin is being created for
     */
    public DefaultJointSkin(final GJoint joint) {

        super(joint);

        getRoot().resize(SIZE, SIZE);
        getRoot().getStyleClass().setAll(STYLE_CLASS);

        getRoot().setPickOnBounds(false);
        getRoot().setSnapToGridOffset(new Point2D(SNAP_OFFSET, SNAP_OFFSET));

        addSelectionListener();

        getRoot().addEventFilter(MouseEvent.MOUSE_PRESSED, this::filterMousePressed);

        getRoot().addEventHandler(MouseEvent.MOUSE_PRESSED,this::handlerMousePressed);
        getRoot().addEventHandler(MouseEvent.MOUSE_RELEASED,this::handlerMouseReleased);
        getRoot().addEventHandler(MouseEvent.MOUSE_DRAGGED,this::handlerMouseDragged);
    }

    /**
     * Adds a listener to react to whether the joint is selected or not and change the CSS classes accordingly.
     */
    private void addSelectionListener() {

        selectedProperty().addListener((ChangeListener<Boolean>) (v, o, n) -> {

            if (n) {
                getRoot().pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, true);
                getRoot().toFront();
            } else {
                getRoot().pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, false);
            }
        });
    }

    private void filterMousePressed(MouseEvent event){
        if(getGraphEditor() != null && getGraphEditor().getModel() != null){
            for(GNode node : getGraphEditor().getModel().getNodes()){
                if(getGraphEditor().getSkinLookup().lookupNode(node).isSelected()) {
                    node.getConnectors()
                            .stream().flatMap(connector -> connector.getConnections().stream())
                            .forEach(connection -> getGraphEditor().getModel().getConnectionsForRedraw().add(connection));
                }
            }
            getGraphEditor().getModel().getConnectionsForRedraw().add(getJoint().getConnection());
        }
    }


    private void handlerMousePressed(MouseEvent t) {
        DefaultConnectionSkin connectionSkin = (DefaultConnectionSkin) getGraphEditor().getSkinLookup().lookupConnection(this.getJoint().getConnection());
        connectionSkin.setIsJointSelected(true);
        connectionSkin.setWasSelected(connectionSkin.selectedProperty().getValue());
        connectionSkin.changeVisualSelection(true);
    }


    private void handlerMouseReleased(MouseEvent t) {
        DefaultConnectionSkin connectionSkin = (DefaultConnectionSkin) getGraphEditor().getSkinLookup().lookupConnection(this.getJoint().getConnection());
        connectionSkin.setIsJointSelected(false);
        connectionSkin.setIsDragged(false);
        connectionSkin.setSelected(connectionSkin.wasSelected());
        connectionSkin.changeVisualSelection(connectionSkin.wasSelected());
    }

    private <T extends Event> void handlerMouseDragged(T t) {
        DefaultConnectionSkin connectionSkin = (DefaultConnectionSkin) getGraphEditor().getSkinLookup().lookupConnection(this.getJoint().getConnection());
        connectionSkin.setIsJointSelected(false);
        connectionSkin.setIsDragged(true);
    }

    @Override
    public double getWidth() {
        return SIZE;
    }

    @Override
    public double getHeight() {
        return SIZE;
    }
}
