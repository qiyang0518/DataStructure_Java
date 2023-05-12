module com.example.shujujiegou_java {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.DataStructure_java to javafx.fxml;
    exports com.example.DataStructure_java;
    exports com.example.DataStructure_java.sparseArr;
    opens com.example.DataStructure_java.sparseArr to javafx.fxml;
    exports com.example.DataStructure_java.queue_;
    opens com.example.DataStructure_java.queue_ to javafx.fxml;
    exports com.example.DataStructure_java.list;
    opens com.example.DataStructure_java.list to javafx.fxml;
}