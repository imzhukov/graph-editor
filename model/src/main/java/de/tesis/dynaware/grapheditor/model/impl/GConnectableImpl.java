/**
 */
package de.tesis.dynaware.grapheditor.model.impl;

import de.tesis.dynaware.grapheditor.model.GConnectable;
import de.tesis.dynaware.grapheditor.model.GConnector;
import de.tesis.dynaware.grapheditor.model.GraphPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GConnectable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GConnectableImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GConnectableImpl#getSortedId <em>Sorted Id</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GConnectableImpl#getSortedSum <em>Sorted Sum</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GConnectableImpl extends MinimalEObjectImpl.Container implements GConnectable {
	/**
	 * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<GConnector> connectors;

	/**
	 * The default value of the '{@link #getSortedId() <em>Sorted Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortedId()
	 * @generated
	 * @ordered
	 */
	protected static final int SORTED_ID_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getSortedId() <em>Sorted Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortedId()
	 * @generated
	 * @ordered
	 */
	protected int sortedId = SORTED_ID_EDEFAULT;
	/**
	 * The default value of the '{@link #getSortedSum() <em>Sorted Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortedSum()
	 * @generated
	 * @ordered
	 */
	protected static final int SORTED_SUM_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getSortedSum() <em>Sorted Sum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSortedSum()
	 * @generated
	 * @ordered
	 */
	protected int sortedSum = SORTED_SUM_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GConnectableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.GCONNECTABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GConnector> getConnectors() {
		if (connectors == null) {
			connectors = new EObjectContainmentWithInverseEList<GConnector>(GConnector.class, this, GraphPackage.GCONNECTABLE__CONNECTORS, GraphPackage.GCONNECTOR__PARENT);
		}
		return connectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSortedId() {
		return sortedId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSortedId(int newSortedId) {
		int oldSortedId = sortedId;
		sortedId = newSortedId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GCONNECTABLE__SORTED_ID, oldSortedId, sortedId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSortedSum() {
		return sortedSum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSortedSum(int newSortedSum) {
		int oldSortedSum = sortedSum;
		sortedSum = newSortedSum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GCONNECTABLE__SORTED_SUM, oldSortedSum, sortedSum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.GCONNECTABLE__CONNECTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectors()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.GCONNECTABLE__CONNECTORS:
				return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.GCONNECTABLE__CONNECTORS:
				return getConnectors();
			case GraphPackage.GCONNECTABLE__SORTED_ID:
				return getSortedId();
			case GraphPackage.GCONNECTABLE__SORTED_SUM:
				return getSortedSum();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.GCONNECTABLE__CONNECTORS:
				getConnectors().clear();
				getConnectors().addAll((Collection<? extends GConnector>)newValue);
				return;
			case GraphPackage.GCONNECTABLE__SORTED_ID:
				setSortedId((Integer)newValue);
				return;
			case GraphPackage.GCONNECTABLE__SORTED_SUM:
				setSortedSum((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphPackage.GCONNECTABLE__CONNECTORS:
				getConnectors().clear();
				return;
			case GraphPackage.GCONNECTABLE__SORTED_ID:
				setSortedId(SORTED_ID_EDEFAULT);
				return;
			case GraphPackage.GCONNECTABLE__SORTED_SUM:
				setSortedSum(SORTED_SUM_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphPackage.GCONNECTABLE__CONNECTORS:
				return connectors != null && !connectors.isEmpty();
			case GraphPackage.GCONNECTABLE__SORTED_ID:
				return sortedId != SORTED_ID_EDEFAULT;
			case GraphPackage.GCONNECTABLE__SORTED_SUM:
				return sortedSum != SORTED_SUM_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (sortedId: ");
		result.append(sortedId);
		result.append(", sortedSum: ");
		result.append(sortedSum);
		result.append(')');
		return result.toString();
	}

} //GConnectableImpl
