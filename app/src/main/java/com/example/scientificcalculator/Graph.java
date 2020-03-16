package com.example.scientificcalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;

import java.math.BigDecimal;
/**
 * @author maciliang
 * uid: u6803148
 */

public class Graph extends View {
    /**
     * this class can draw function image that is defined by the user
     */

    String function;

    public Graph (Context context, String function){
        super(context);
        this.function = function;
    }

    /**
     * evaluate the result of the function
     * @param x is the variable
     * @return the result of the given x
     * @throws Exception
     */
    private BigDecimal myFunc(BigDecimal x) throws Exception {
        RightTokenizer rightTokenizer = new RightTokenizer(function);
        RightParser myFunc = new RightParser(rightTokenizer,x);
        return myFunc.parseExp().evaluate();
    }

    /**
     * do the actual drawing activity
     */
    @Override
    protected void onDraw(Canvas canvas){
        Point point  = new Point();
        WindowManager wm = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getSize(point);
        int screenWidth = point.x;
        int screenHeight = point.y;

        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5.0f);
        canvas.drawLine(0,screenHeight/2.0f,screenWidth, screenHeight/2.0f,paint);
        canvas.drawLine(screenWidth/2.0f,0,screenWidth/2.0f,screenHeight,paint);
        paint.setTextSize(40.0f);
        canvas.drawText("0",screenWidth/2.0f-40,screenHeight/2.0f+40,paint);

        Path path = new Path();
        float oriX = screenWidth/2.0f;
        float oriY = screenHeight/2.0f;
        paint.setStrokeWidth(1.0f/40.0f);
        canvas.translate(oriX,oriY);
        canvas.scale(40.0f,-40.0f);

        float x0 = -oriX;
        float y0 = 0;
        try {
            y0 = myFunc(BigDecimal.valueOf(x0)).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        float x1,y1 = 0;

        path.moveTo(x0,y0);
        for (float i = 0; i<screenWidth/40.0f; i+=0.00025f){       //use consequent line segments to simulate the function image
            x1 = x0+i;
            try {
                y1 = myFunc(BigDecimal.valueOf(x1)).floatValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            canvas.drawLine(x0,y0,x1,y1,paint);
            x0 = x1;
            try {
                y0 = myFunc(BigDecimal.valueOf(x0)).floatValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
