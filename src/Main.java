import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);

        Label juhis = new Label("Sisesta koosoleku teema esimesse lahtrisse ja teise planeeritud aeg minutites");
        TextField teema = new TextField();
        teema.setTranslateY(30);
        TextField aeg = new TextField();
        aeg.setTranslateY(60);
        Button submit = new Button("Salvesta");
        submit.setTranslateY(90);
        Label info = new Label();
        info.setTranslateY(120);
        Button valmis = new Button("VALMIS");
        valmis.setTranslateY(150);
        Label statistika = new Label();
        statistika.setTranslateY(180);
        Koosolek k1 = new Koosolek();

        pane.getChildren().addAll(juhis, teema, aeg, submit, info, valmis, statistika);
        primaryStage.setScene(scene);
        primaryStage.show();

        submit.setOnMouseClicked(event -> {
            info.setText("Koosoleku info sisestatud! Nüüd arutage. Kui valmis, vajuta nuppu VALMIS");
            k1.lisaInfo(Double.parseDouble(aeg.getText()),teema.getText());
        });

        valmis.setOnMouseClicked(event -> {
            info.setText(k1.tulemus());
            statistika.setText(k1.efektiivsus());
            teema.clear();
            aeg.clear();
        });

    }
}