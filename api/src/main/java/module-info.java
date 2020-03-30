module de.tesis.dynaware.grapheditor.api {
    exports de.tesis.dynaware.grapheditor.utils;
    exports de.tesis.dynaware.grapheditor;
    exports de.tesis.dynaware.grapheditor.zoom;
    exports de.tesis.dynaware.grapheditor.window;
    requires javafx.base;
    requires javafx.graphics;
    requires de.tesis.dynaware.grapheditor.model;
    requires org.eclipse.emf.common;
    requires org.eclipse.emf.ecore;
    requires edit;
    requires slf4j.api;
//    requires logback.classic;
    requires javafx.controls;
}