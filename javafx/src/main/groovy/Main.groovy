import javafx.application.*
import javafx.event.*
import javafx.scene.*
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.stage.*

public class Main extends Application {
    public static void main(String[] args) {
        launch(Main.class, args)
    }

    @Override
    public void start(Stage stage) {
        stage.title = "Hello World!"

        def btn = new Button();
        btn.text = "Say 'Hello World'"
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        })

        def root = new StackPane()
        root.children.add(btn);
        stage.scene = new Scene(root, 300, 250)
        stage.show()
    }
}
