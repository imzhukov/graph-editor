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
     * @see #setName(String)
     * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGParameter_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.tesis.dynaware.grapheditor.model.GParameter#getName <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' attribute.
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Y</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Y</em>' attribute.
     * @see #setName(String)
     * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGParameter_ID()
     * @model
     * @generated
     */
    int getID();

    /**
     * Sets the value of the '{@link de.tesis.dynaware.grapheditor.model.GParameter#getID <em>Y</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Y</em>' attribute.
     * @generated
     */
    void setID(int value);
}