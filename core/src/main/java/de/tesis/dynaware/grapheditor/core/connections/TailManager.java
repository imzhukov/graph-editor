package de.tesis.dynaware.grapheditor.core.connections;

import java.util.Collections;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import de.tesis.dynaware.grapheditor.GTailSkin;
import de.tesis.dynaware.grapheditor.SkinLookup;
import de.tesis.dynaware.grapheditor.core.view.GraphEditorView;
import de.tesis.dynaware.grapheditor.model.GConnection;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.utils.GeometryUtils;

/**
 * Responsible for creating, drawing, and removing tails.
 */
public class TailManager {

    private final SkinLookup skinLookup;
    private final GraphEditorView view;

    private GTailSkin tailSkin;

    private Point2D sourcePosition;
    private List<Point2D> jointPositions;

    /**
     * Creates a new {@link TailManager} instance.
     * 
     * @param skinLookup the {@link SkinLookup} used to look up connector and tail skins
     * @param view the {@link GraphEditorView} to which tail skins will be added and removed
     */
    public TailManager(final SkinLookup skinLookup, final GraphEditorView view) {
        this.skinLookup = skinLookup;
        this.view = view;
    }

    /**
     * Creates a new tail and adds it to the view.
     * 
     * @param connector the connector where the tail starts from
     * @param the mouse event responsible for creating the tail
     */
    public void create(final GConnector connector, final MouseEvent event) {

        // Check if tailSkin already created, because this method may be called multiple times.
        if (tailSkin == null) {

            tailSkin = skinLookup.lookupTail(connector);

            sourcePosition = GeometryUtils.getConnectorPosition(connector, skinLookup);
            final Point2D cursorPosition = getScaledPosition(GeometryUtils.getCursorPosition(event, view));

            tailSkin.draw(sourcePosition, cursorPosition);

            view.add(tailSkin);
            tailSkin.getRoot().toBack();
        }
    }

    /**
     * Creates a new tail from a connection that was detached.
     * 
     * @param connector the connector that the connection was detached from
     * @param connection the connection that was detached
     * @param the mouse event responsible for creating the tail
     */
    public void createFromConnection(final GConnector connector, final GConnection connection, final MouseEvent event) {

        jointPositions = GeometryUtils.getJointPositions(connection, skinLookup);

        final GConnector newSource;
        if (connector.equals(connection.getSource())) {
            Collections.reverse(jointPositions);
            newSource = connection.getTarget();
        } else {
            newSource = connection.getSource();
        }

        tailSkin = skinLookup.lookupTail(newSource);

        sourcePosition = GeometryUtils.getConnectorPosition(newSource, skinLookup);
        final Point2D cursorPosition = getScaledPosition(GeometryUtils.getCursorPosition(event, view));

        tailSkin.draw(sourcePosition, cursorPosition, jointPositions);
        view.add(tailSkin);
        tailSkin.getRoot().toBack();
    }

    /**
     * Updates the tail position based on new cursor position.
     * 
     * @param the mouse event responsible for updating the position
     */
    public void updatePosition(final MouseEvent event) {

        if (tailSkin != null && sourcePosition != null) {

            final Point2D cursorPosition = getScaledPosition(GeometryUtils.getCursorPosition(event, view));

            if (jointPositions != null) {
                tailSkin.draw(sourcePosition, cursorPosition, jointPositions);
            } else {
                tailSkin.draw(sourcePosition, cursorPosition);
            }
        }
    }

    /**
     * Snaps the position of the tail to show the position the connection itself would take if it would be created.
     * 
     * @param source the source connector
     * @param target the target connector
     * @param valid {@code true} if the connection is valid, {@code false} if invalid
     */
    public void snapPosition(final GConnector source, final GConnector target, final boolean valid) {

        if (tailSkin != null) {

            final Point2D sourcePosition = GeometryUtils.getConnectorPosition(source, skinLookup);
            final Point2D targetPosition = GeometryUtils.getConnectorPosition(target, skinLookup);

            if (jointPositions != null) {
                tailSkin.draw(sourcePosition, targetPosition, jointPositions, target, valid);
            } else {
                tailSkin.draw(sourcePosition, targetPosition, target, valid);
            }
        }
    }

    /**
     * Cleans up.
     * 
     * <p>
     * Called at the end of a drag gesture or during initialization. Removes any tail from the view and resets tracking
     * parameters.
     * </p>
     */
    public void cleanUp() {

        jointPositions = null;

        if (tailSkin != null) {
            view.remove(tailSkin);
            tailSkin = null;
        }
    }

    /**
     * Corrects the cursor position in the case where scale transforms are applied.
     * 
     * @param cursorPosition the cursor position calculated assuming scale factor of 1
     * 
     * @return the corrected cursor position
     */
    private Point2D getScaledPosition(final Point2D cursorPosition) {

        final double scale = view.getLocalToSceneTransform().getMxx();
        return new Point2D(cursorPosition.getX() / scale, cursorPosition.getY() / scale);
    }
}
