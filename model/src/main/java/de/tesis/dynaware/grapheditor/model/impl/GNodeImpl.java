/**
 */
package de.tesis.dynaware.grapheditor.model.impl;

import de.tesis.dynaware.grapheditor.model.GModel;
import de.tesis.dynaware.grapheditor.model.GNode;
import de.tesis.dynaware.grapheditor.model.GParameter;
import de.tesis.dynaware.grapheditor.model.GraphPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getX <em>X</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getY <em>Y</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getSubgraph <em>Subgraph</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getRotateAngle <em>Rotate Angle</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getLibraryBlockId <em>Library Block Id</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getPageId <em>Page Id</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getDbObjectId <em>Db Object Id</em>}</li>
 *   <li>{@link de.tesis.dynaware.grapheditor.model.impl.GNodeImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GNodeImpl extends GConnectableImpl implements GNode {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final double X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected double x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final double Y_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected double y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final double WIDTH_EDEFAULT = 151.0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected double width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final double HEIGHT_EDEFAULT = 101.0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected double height = HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubgraph() <em>Subgraph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubgraph()
	 * @generated
	 * @ordered
	 */
	protected GModel subgraph;

	/**
	 * The default value of the '{@link #getRotateAngle() <em>Rotate Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotateAngle()
	 * @generated
	 * @ordered
	 */
	protected static final double ROTATE_ANGLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRotateAngle() <em>Rotate Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotateAngle()
	 * @generated
	 * @ordered
	 */
	protected double rotateAngle = ROTATE_ANGLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLibraryBlockId() <em>Library Block Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryBlockId()
	 * @generated
	 * @ordered
	 */
	protected static final int LIBRARY_BLOCK_ID_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getLibraryBlockId() <em>Library Block Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryBlockId()
	 * @generated
	 * @ordered
	 */
	protected int libraryBlockId = LIBRARY_BLOCK_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageId() <em>Page Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageId()
	 * @generated
	 * @ordered
	 */
	protected static final int PAGE_ID_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPageId() <em>Page Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageId()
	 * @generated
	 * @ordered
	 */
	protected int pageId = PAGE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbObjectId() <em>Db Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbObjectId()
	 * @generated
	 * @ordered
	 */
	protected static final int DB_OBJECT_ID_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getDbObjectId() <em>Db Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDbObjectId()
	 * @generated
	 * @ordered
	 */
	protected int dbObjectId = DB_OBJECT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<GParameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.GNODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setX(double newX) {
		double oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setY(double newY) {
		double oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWidth(double newWidth) {
		double oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeight(double newHeight) {
		double oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GModel getSubgraph() {
		return subgraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubgraph(GModel newSubgraph, NotificationChain msgs) {
		GModel oldSubgraph = subgraph;
		subgraph = newSubgraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__SUBGRAPH, oldSubgraph, newSubgraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSubgraph(GModel newSubgraph) {
		if (newSubgraph != subgraph) {
			NotificationChain msgs = null;
			if (subgraph != null)
				msgs = ((InternalEObject)subgraph).eInverseRemove(this, GraphPackage.GMODEL__SUPERGRAPH, GModel.class, msgs);
			if (newSubgraph != null)
				msgs = ((InternalEObject)newSubgraph).eInverseAdd(this, GraphPackage.GMODEL__SUPERGRAPH, GModel.class, msgs);
			msgs = basicSetSubgraph(newSubgraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__SUBGRAPH, newSubgraph, newSubgraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRotateAngle() {
		return rotateAngle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotateAngle(double newRotateAngle) {
		double oldRotateAngle = rotateAngle;
		rotateAngle = newRotateAngle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__ROTATE_ANGLE, oldRotateAngle, rotateAngle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getLibraryBlockId() {
		return libraryBlockId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLibraryBlockId(int newLibraryBlockId) {
		int oldLibraryBlockId = libraryBlockId;
		libraryBlockId = newLibraryBlockId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__LIBRARY_BLOCK_ID, oldLibraryBlockId, libraryBlockId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPageId() {
		return pageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPageId(int newPageId) {
		int oldPageId = pageId;
		pageId = newPageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__PAGE_ID, oldPageId, pageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDbObjectId() {
		return dbObjectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDbObjectId(int newDbObjectId) {
		int oldDbObjectId = dbObjectId;
		dbObjectId = newDbObjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GNODE__DB_OBJECT_ID, oldDbObjectId, dbObjectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<GParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<GParameter>(GParameter.class, this, GraphPackage.GNODE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphPackage.GNODE__SUBGRAPH:
				if (subgraph != null)
					msgs = ((InternalEObject)subgraph).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphPackage.GNODE__SUBGRAPH, null, msgs);
				return basicSetSubgraph((GModel)otherEnd, msgs);
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
			case GraphPackage.GNODE__SUBGRAPH:
				return basicSetSubgraph(null, msgs);
			case GraphPackage.GNODE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case GraphPackage.GNODE__ID:
				return getId();
			case GraphPackage.GNODE__TYPE:
				return getType();
			case GraphPackage.GNODE__NAME:
				return getName();
			case GraphPackage.GNODE__X:
				return getX();
			case GraphPackage.GNODE__Y:
				return getY();
			case GraphPackage.GNODE__WIDTH:
				return getWidth();
			case GraphPackage.GNODE__HEIGHT:
				return getHeight();
			case GraphPackage.GNODE__SUBGRAPH:
				return getSubgraph();
			case GraphPackage.GNODE__ROTATE_ANGLE:
				return getRotateAngle();
			case GraphPackage.GNODE__LIBRARY_BLOCK_ID:
				return getLibraryBlockId();
			case GraphPackage.GNODE__PAGE_ID:
				return getPageId();
			case GraphPackage.GNODE__DB_OBJECT_ID:
				return getDbObjectId();
			case GraphPackage.GNODE__PARAMETERS:
				return getParameters();
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
			case GraphPackage.GNODE__ID:
				setId((Integer)newValue);
				return;
			case GraphPackage.GNODE__TYPE:
				setType((String)newValue);
				return;
			case GraphPackage.GNODE__NAME:
				setName((String)newValue);
				return;
			case GraphPackage.GNODE__X:
				setX((Double)newValue);
				return;
			case GraphPackage.GNODE__Y:
				setY((Double)newValue);
				return;
			case GraphPackage.GNODE__WIDTH:
				setWidth((Double)newValue);
				return;
			case GraphPackage.GNODE__HEIGHT:
				setHeight((Double)newValue);
				return;
			case GraphPackage.GNODE__SUBGRAPH:
				setSubgraph((GModel)newValue);
				return;
			case GraphPackage.GNODE__ROTATE_ANGLE:
				setRotateAngle((Double)newValue);
				return;
			case GraphPackage.GNODE__LIBRARY_BLOCK_ID:
				setLibraryBlockId((Integer)newValue);
				return;
			case GraphPackage.GNODE__PAGE_ID:
				setPageId((Integer)newValue);
				return;
			case GraphPackage.GNODE__DB_OBJECT_ID:
				setDbObjectId((Integer)newValue);
				return;
			case GraphPackage.GNODE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends GParameter>)newValue);
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
			case GraphPackage.GNODE__ID:
				setId(ID_EDEFAULT);
				return;
			case GraphPackage.GNODE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GraphPackage.GNODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphPackage.GNODE__X:
				setX(X_EDEFAULT);
				return;
			case GraphPackage.GNODE__Y:
				setY(Y_EDEFAULT);
				return;
			case GraphPackage.GNODE__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case GraphPackage.GNODE__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case GraphPackage.GNODE__SUBGRAPH:
				setSubgraph((GModel)null);
				return;
			case GraphPackage.GNODE__ROTATE_ANGLE:
				setRotateAngle(ROTATE_ANGLE_EDEFAULT);
				return;
			case GraphPackage.GNODE__LIBRARY_BLOCK_ID:
				setLibraryBlockId(LIBRARY_BLOCK_ID_EDEFAULT);
				return;
			case GraphPackage.GNODE__PAGE_ID:
				setPageId(PAGE_ID_EDEFAULT);
				return;
			case GraphPackage.GNODE__DB_OBJECT_ID:
				setDbObjectId(DB_OBJECT_ID_EDEFAULT);
				return;
			case GraphPackage.GNODE__PARAMETERS:
				getParameters().clear();
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
			case GraphPackage.GNODE__ID:
				return id != ID_EDEFAULT;
			case GraphPackage.GNODE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case GraphPackage.GNODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphPackage.GNODE__X:
				return x != X_EDEFAULT;
			case GraphPackage.GNODE__Y:
				return y != Y_EDEFAULT;
			case GraphPackage.GNODE__WIDTH:
				return width != WIDTH_EDEFAULT;
			case GraphPackage.GNODE__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case GraphPackage.GNODE__SUBGRAPH:
				return subgraph != null;
			case GraphPackage.GNODE__ROTATE_ANGLE:
				return rotateAngle != ROTATE_ANGLE_EDEFAULT;
			case GraphPackage.GNODE__LIBRARY_BLOCK_ID:
				return libraryBlockId != LIBRARY_BLOCK_ID_EDEFAULT;
			case GraphPackage.GNODE__PAGE_ID:
				return pageId != PAGE_ID_EDEFAULT;
			case GraphPackage.GNODE__DB_OBJECT_ID:
				return dbObjectId != DB_OBJECT_ID_EDEFAULT;
			case GraphPackage.GNODE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", type: ");
		result.append(type);
		result.append(", name: ");
		result.append(name);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", rotateAngle: ");
		result.append(rotateAngle);
		result.append(", libraryBlockId: ");
		result.append(libraryBlockId);
		result.append(", pageId: ");
		result.append(pageId);
		result.append(", dbObjectId: ");
		result.append(dbObjectId);
		result.append(')');
		return result.toString();
	}

} //GNodeImpl
