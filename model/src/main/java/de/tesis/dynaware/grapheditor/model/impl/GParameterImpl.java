package de.tesis.dynaware.grapheditor.model.impl;

import de.tesis.dynaware.grapheditor.model.GParameter;
import de.tesis.dynaware.grapheditor.model.GraphPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class GParameterImpl extends MinimalEObjectImpl.Container implements GParameter {

    protected static final int ID_EDEFAULT = -1;

    protected int id = ID_EDEFAULT;

    protected static final String VALUE_EDEFAULT = "";

    protected String value = VALUE_EDEFAULT;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GPARAMETER__VALUE, oldValue, value));
        }
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setId(int newID) {
        int oldID = id;
        id = newID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.GPARAMETER__ID, oldID, id));
    }

    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case GraphPackage.GPARAMETER__ID:
                return getID();
            case GraphPackage.GPARAMETER__VALUE:
                return getValue();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case GraphPackage.GPARAMETER__ID:
                setId((Integer) newValue);
                return;
            case GraphPackage.GPARAMETER__VALUE:
                setValue((String) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case GraphPackage.GPARAMETER__ID:
                setId(ID_EDEFAULT);
                return;
            case GraphPackage.GPARAMETER__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case GraphPackage.GPARAMETER__ID:
                return id != ID_EDEFAULT;
            case GraphPackage.GPARAMETER__VALUE:
                return !value.equalsIgnoreCase(VALUE_EDEFAULT);
        }
        return super.eIsSet(featureID);
    }
}
