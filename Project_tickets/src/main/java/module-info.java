module bg.tuvarna.sit.group5.tickets {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires log4j;
    requires java.naming;
    exports bg.tuvarna.sit.group5.tickets.application;
    opens bg.tuvarna.sit.group5.tickets.application to javafx.fxml;

    exports bg.tuvarna.sit.group5.tickets.presentation.controllers;
    opens bg.tuvarna.sit.group5.tickets.presentation.controllers to javafx.fxml;
}