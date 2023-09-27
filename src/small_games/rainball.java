
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Collector extends Application {

    //variable
    private static final int width = 600;
    private static final int height = 600;
    private static double BALL_R = 40;
    int x = 300;
    int y = -90,yy=-60,yyy=-30,yyyy=0;
    
    int xx;
    int r = (int) (Math.random() * 600),rr=(int) (Math.random() * 600),rrr=(int) (Math.random() * 600),rrrr=(int) (Math.random() * 600);
    private int num;
    boolean peo;
    int i;
    double time;

    public void start(Stage stage) throws Exception {
        stage.setTitle("collector");
        //background size
        Canvas canvas = new Canvas(width, height);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        //mouse control (move)
        canvas.setOnMouseMoved(e -> xx = (int) e.getX());
        canvas.setOnMouseClicked(e -> peo = true);
        //JavaFX Timeline = free form animation defined by KeyFrames and their duration 
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(2), e -> run(gc)));
        //number of cycles in animation, -1 = repeat indefinitely
        tl.setCycleCount(-1);

        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {
        //set graphics
        //set background color

        gc.setFill(Color.DARKORANGE);
        gc.fillRect(0, 0, width, height);

        //set text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(25));

	    //simple computer opponent who is following the ball
        if (y == 600) {
            r = (int) (Math.random() * 600);
            y = -90;
        }
        gc.fillOval(r, y++, BALL_R, BALL_R);

        if (yy == 600) {
            rr = (int) (Math.random() * 600);
            yy = -60;
        }
        gc.fillOval(rr, yy++, BALL_R, BALL_R);

        if (yyy == 600) {
            rrr = (int) (Math.random() * 600);
            yyy = -30;
        }
         gc.fillOval(rrr, yyy++, BALL_R, BALL_R);
       
         if (yyyy == 600) {
            rrrr = (int) (Math.random() * 600);
            yyyy = 0;
        }
        gc.fillOval(rrrr, yyyy++, BALL_R, BALL_R);

        gc.fillText("collected: " + num, 460, 30);
        //draw player 

        gc.fillRect(xx, 580, 90, 20);

        if (r - xx < 90 && r - xx >= -40 && y == 580) {
            num++;
        }
        
         if (rr - xx < 90 && rr - xx >= -40 && yy == 580) {
            num++;
        }
         
          if (rrr - xx < 90 && rrr - xx >= -40 && yyy == 580) {
            num++;
        }
          
           if (rrrr - xx < 90 && rrrr - xx >= -40 && yyyy == 580) {
            num++;
        }

        time += 3;

        gc.fillText("time: " + time / 1000, 460, 60);
    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }
}

