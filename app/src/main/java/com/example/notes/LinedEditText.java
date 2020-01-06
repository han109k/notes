package com.example.notes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;

public class LinedEditText extends AppCompatEditText {

    private Rect mRect;
    private Paint mPaint;

    public LinedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(0xFFFFD960);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int height =((View) this.getParent()).getHeight();
        int lineHieght = getLineHeight();
        int numberOfLines = height / lineHieght;

        Rect r = mRect;
        Paint p = mPaint;

        int baseline = getLineBounds(0, r);

        for(int i = 0; i < numberOfLines; i++){

            canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, p);

            baseline += lineHieght;
        }

        super.onDraw(canvas);
    }
}
