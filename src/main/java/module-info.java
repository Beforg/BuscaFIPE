module BuscaFIPE {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    opens br.com.alura.BuscaFIPE to javafx.fxml, spring.core;
    exports br.com.alura.BuscaFIPE;
    exports br.com.alura.BuscaFIPE.controller;
    opens br.com.alura.BuscaFIPE.controller to javafx.fxml, spring.core;
    exports br.com.alura.BuscaFIPE.model to com.fasterxml.jackson.databind;
}