module de.tesis.dynaware.grapheditor.core {
    exports de.tesis.dynaware.grapheditor.core.skins.defaults;
    exports de.tesis.dynaware.grapheditor.core;
    exports de.tesis.dynaware.grapheditor.core.skins.defaults.connection;
    exports de.tesis.dynaware.grapheditor.core.view;
    exports de.tesis.dynaware.grapheditor.core.graphlayers;
    exports de.tesis.dynaware.grapheditor.core.connections;
    requires javafx.graphics;
    requires de.tesis.dynaware.grapheditor.api;
    requires de.tesis.dynaware.grapheditor.model;
    requires org.eclipse.emf.ecore;
    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore.xmi;
    requires edit;
    requires java.datatransfer;
    requires slf4j.api;
//    requires logback.classic;
    requires java.desktop;
}