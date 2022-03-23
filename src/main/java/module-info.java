module com.example.jigsaw_10 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires org.kordamp.bootstrapfx.core;

  opens com.example.jigsaw_10 to javafx.fxml;
  exports com.example.jigsaw_10;
}