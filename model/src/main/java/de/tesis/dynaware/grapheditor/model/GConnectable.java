/**
 */
package de.tesis.dynaware.grapheditor.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GConnectable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.GConnectable#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.GConnectable#getSortedId <em>Sorted Id</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.GConnectable#getSortedSum <em>Sorted Sum</em>}</li>
 * </ul>
 *
 * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGConnectable()
 * @model abstract="true"
 * @generated
 */
public interface GConnectable extends EObject {
	/**
	 * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link de.tesis.dynaware.grapheditor.model.GConnector}.
	 * It is bidirectional and its opposite is '{@link de.tesis.dynaware.grapheditor.model.GConnector#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connectors</em>' containment reference list.
	 * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGConnectable_Connectors()
	 * @see de.tesis.dynaware.grapheditor.model.GConnector#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<GConnector> getConnectors();

	/**
	 * Returns the value of the '<em><b>Sorted Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sorted Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sorted Id</em>' attribute.
	 * @see #setSortedId(int)
	 * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGConnectable_SortedId()
	 * @model
	 * @generated
	 */
	int getSortedId();

	/**
	 * Sets the value of the '{@link de.tesis.dynaware.grapheditor.model.GConnectable#getSortedId <em>Sorted Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sorted Id</em>' attribute.
	 * @see #getSortedId()
	 * @generated
	 */
	void setSortedId(int value);

	/**
	 * Returns the value of the '<em><b>Sorted Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sorted Sum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sorted Sum</em>' attribute.
	 * @see #setSortedSum(int)
	 * @see de.tesis.dynaware.grapheditor.model.GraphPackage#getGConnectable_SortedSum()
	 * @model
	 * @generated
	 */
	int getSortedSum();

	/**
	 * Sets the value of the '{@link de.tesis.dynaware.grapheditor.model.GConnectable#getSortedSum <em>Sorted Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sorted Sum</em>' attribute.
	 * @see #getSortedSum()
	 * @generated
	 */
	void setSortedSum(int value);

} // GConnectable
