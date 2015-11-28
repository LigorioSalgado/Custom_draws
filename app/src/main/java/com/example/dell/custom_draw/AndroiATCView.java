package com.example.dell.custom_draw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by DELL on 27/11/2015.
 */
public class AndroiATCView extends View {
    //Circle and text colors
    private int squareCol, labelCol;
    //label text
    private String squareText;
    //paint for drawing custom view
    private Paint squarePaint;

    public AndroiATCView(Context context, AttributeSet attrs) {
        super(context,attrs);
        //paint object dor drawing in onDraw
        squarePaint = new  Paint();
        //get the attributes specified in attrs.xml
        //using the name you included

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.AndroidATCView,0,0);

        try{
            //get the text and colors spcified using the names attrs.xml
            squareText = a.getString(R.styleable.AndroidATCView_squareLabel);
            squareCol = a.getInteger(R.styleable.AndroidATCView_squareColor, 0);// 0 is default
            labelCol =a.getInteger(R.styleable.AndroidATCView_labelColor,0);
        }finally{
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        //set drawing propierties
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);

        //set the paint color using the circle color specified
        squarePaint.setColor(squareCol);
        // draw the Square using the properties defined
        canvas.drawRect(0,0, this.getMeasuredWidth(),this.getMeasuredHeight(),squarePaint);
        //set the text color  specified
        squarePaint.setColor(labelCol);
        //set text properties

        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);

        // drawthe text using the string attribute and chosen properties
        canvas.drawText(squareText, this.getMeasuredWidth()/2,this.getMeasuredHeight()/2,squarePaint);


    }

    public int getSquareColor() {
        return squareCol;
    }

    public void setSquareColor(int newColor) {
        squareCol = newColor;
        invalidate();
        requestLayout();
    }

    public String getSquareText() {
        return squareText;
    }

    public void setLabelText(String newLabel) {
        squareText = newLabel;
        invalidate();
        requestLayout();
    }

    public int getLabelCol() {
        return labelCol;
    }

    public void setLabelColor(int newColor) {
       labelCol=newColor;
        invalidate();
        requestLayout();
    }
}