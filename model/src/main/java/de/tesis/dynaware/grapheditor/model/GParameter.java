package de.tesis.dynaware.grapheditor.model;

import org.eclipse.emf.ecore.EObject;

public interface GParameter extends EObject {

    /**
     * Returns the value of the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Y</em>' attribute.
     * @see #setValue(String)
     * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGParameter_ID()
     * @model
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link de.tesis.dynaware.grapheditor.model.GParameter#getValue <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' attribute.
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Y</em>' attribute.
     * @see #setId(int)
     * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGParameter_ID()
     * @model
     * @generated
     */
    int getId();

    /**
     * Sets the value of the '{@link de.tesis.dynaware.grapheditor.model.GParameter#getId <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' attribute.
     * @generated
     */
    void setId(int value);
}