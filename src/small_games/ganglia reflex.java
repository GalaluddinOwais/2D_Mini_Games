package small_games;

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

public class Reactor extends Application {

    //variable
    private static final int width = 600;
    private static final int height = 600;
    int x,xx,i,frequent,peo;
    double num,numm,time,m;
   
 
    

    public void start(Stage stage) throws Exception {
        stage.setTitle("ganglionic");
        //background size
        Canvas canvas = new Canvas(width, height);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        //mouse control (move)
        canvas.setOnMouseMoved(e -> xx = (int) e.getX());
        canvas.setOnMousePressed(e -> peo *= -1);
        //JavaFX Timeline = free form animation defined by KeyFrames and their duration 
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1), e -> run(gc)));
        //number of cycles in animation, -1 = repeat indefinitely
        tl.setCycleCount(-1);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {
        //set graphics
        //set background color
        gc.setFill(Color.color((double) 0 / 255, (double) 222 / 255, (double) 160 / 255));
        gc.fillRect(0, 0, width, height);

        //set text
        gc.setFill(Color.color((double) 255 / 255, (double) 255 / 255, (double) 255 / 255));
        gc.setFont(Font.font(25));

        //simple computer opponent who is following the ball
        //draw the ball
        gc.fillText("late by: " + num/1000+" sec.", 395, 30);


        if (peo == -1) {
            gc.fillOval(150, 150, 300, 300);
            num++; 
        }
        else {gc.fillText("don't click ", 240, 290);
        gc.fillText("or the target appears! ", 180, 320);
        }
i++;
int r=(int)(Math.random()*20000+1);
if(i%r==0)peo = -1;
    

       
      
        if(time/1000==60) {m=num;time++;}
        else if (time/1000<60)  gc.fillText("time: " + time++ / 1000+"/60", 410, 60);
        else gc.fillText("final score!: " + m /1000+" sec.", 350, 60);
        
    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }
