
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ActiveMemory extends Application {

    //variable
    private static final int width = 600;
    private static final int height = 600;
    double timme = 0;
    private static double BALL_R = 40;
   
    int xx;
    int a;
    int b;
    int c;
    private int num, numm;

    boolean peo;
    int i, ii;
    double time;

    public void start(Stage stage) throws Exception {
        stage.setTitle("active memory");
        //background size
        Canvas canvas = new Canvas(width, height);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        //mouse control (move)
        canvas.setOnMouseMoved(e -> xx = (int) e.getX());
        canvas.setOnMouseClicked(e -> peo = true);
        //JavaFX Timeline = free form animation defined by KeyFrames and their duration 
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(7), e -> run(gc)));
        //number of cycles in animation, -1 = repeat indefinitely
        tl.setCycleCount(-1);

        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {
        //set graphics
        //set background color
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, width, height);

        //set text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

        //simple computer opponent who is following the ball
        //draw the ball
        if (peo == false) {
            a =(int) (Math.random() * 450);
              b =(int) (Math.random() * 450);
                c =(int) (Math.random() * 450);
        }
        if (peo == false) {
            gc.fillOval(a, a, BALL_R, BALL_R);
                gc.fillOval(b, b, BALL_R, BALL_R);
                    gc.fillOval(c, c, BALL_R, BALL_R);
            numm = 0;
        } else if (numm < 7) {
            gc.fillOval(a, a, BALL_R, BALL_R);
                gc.fillOval(b, b, BALL_R, BALL_R);
                    gc.fillOval(c, c, BALL_R, BALL_R);
            numm++;
        }

        gc.fillText("taken " + (double)num/60, 460, 30);
        //draw player 

        gc.fillRect(xx-40, 570, 130, 20);
        if (peo == true && i <= 600 && i >= 0) {{
            gc.fillRect(xx-40, i, 130, 20);
             
                if ((a-xx <= 50) && (a-xx >= -BALL_R) &&(a-i < 20) && (a-i >= -BALL_R)) num++;
                if(((b-xx <= 50) && (b-xx >= -BALL_R) &&(b-i < 20) && (b-i >= -BALL_R)))num++;
                if((c-xx <= 50) && (c-xx >= -BALL_R) &&(c-i < 20) && (c-i >= -BALL_R))num++;
                
          } i--;
 
        } else {
            peo = false;
            i = 600;
        }

        time += 3;
        gc.fillText("time: " + time / 1000, 460, 60);

    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }
}
