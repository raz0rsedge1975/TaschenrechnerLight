module Taschenrechner {

    requires javafx.base;
    requires javafx.controls;

    opens rechner to javafx.graphics;
}