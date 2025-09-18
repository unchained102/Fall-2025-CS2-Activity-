module edu.westga.cs1302.Lab_9_18_2025 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens edu.westga.cs1302.Project1.views to javafx.fxml;
    exports edu.westga.cs1302.Project1;
}
