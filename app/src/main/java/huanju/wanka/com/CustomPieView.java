package huanju.wanka.com;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * @author create by ZY
 * @date 2018-5-22
 * @description 饼状图控件
 */

public class CustomPieView extends View {

    private Paint anglePaint;
    private Paint mTextPaint;
    private ArrayList<PieBean> mList;

    public CustomPieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 初始化画笔
        initPaint();
    }

    /**
     * 设置数据
     * @param list
     */
    public void setDate (ArrayList<PieBean> list) {
        this.mList = list;
    }

    /**
     * 初始化各画笔
     */
    private void initPaint() {
        anglePaint = new Paint();

        mTextPaint = new Paint();
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(34);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // 创建矩形模型,在其内部进行绘制
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());

        // 累计每次的角度合
        int drawSectorTotalAngle = -45;
        // 画扇形
        for (int i = 0; i < mList.size(); i++) {
            anglePaint.setColor(Color.parseColor(mList.get(i).color));
            canvas.drawArc(rectF, drawSectorTotalAngle, mList.get(i).angle, true, anglePaint);
            drawSectorTotalAngle += mList.get(i).angle;
        }

        /**
         * 坐标公式:
         * x = 原点 + r * cos(angle * π / 180)
         * y = 原点 + r * sin(angle * π /180)
         */
        // 累计每次的角度合
        int drawTextTotleAngle = -45;
        // 画文本
        for (int i = 0; i < mList.size(); i++) {
            float x = (float) (getWidth() / 2 + getWidth() / 2.5 * (Math.cos((mList.get(i).angle / 2 + drawTextTotleAngle) * 3.14 / 180)));
            float y = (float) (getHeight() / 2 + getWidth() / 2.5 * (Math.sin((mList.get(i).angle / 2 + drawTextTotleAngle) * 3.14 / 180)));
            canvas.drawText(mList.get(i).content, x, y, mTextPaint);
            drawTextTotleAngle += mList.get(i).angle;
        }

        super.onDraw(canvas);
    }

    //    /**
//     * 这里在画角度的时候需要注意,每次是从上次的结束位置开始画,然后画多少
//     * 比如这里传90和90就是从上次90度开始画,画多少呢?再画90度
//     * 从180度开始画画多少呢?画90度
//     * @param canvas
//     */
//    @Override
//    protected void onDraw(Canvas canvas) {
//        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
//        /**
//         * 参数说明:
//         * RectF:       在哪个矩形内进行绘制
//         * startAngle:  起始角度
//         * sweepAngle:  结束角度
//         * useCenter:   是否穿过中心
//         * paint:       画笔
//         */
//        // 画矩形
//        canvas.drawArc(rectF, 0, 90, true, mRedPaint);
//        canvas.drawArc(rectF, 90, 90, true, mBluePaint);
//        canvas.drawArc(rectF, 180, 90, true, mGrayPaint);
//        canvas.drawArc(rectF, 270, 90, true, mGreenPaint);
//        // 画文本
//        canvas.drawText("红色", getWidth() - getWidth() / 3, getHeight() - getHeight() / 3, mTextPaint);
//        canvas.drawText("蓝色", getWidth() / 3, getHeight() - getHeight() / 3, mTextPaint);
//        canvas.drawText("灰色", getWidth() / 3, getHeight() / 3, mTextPaint);
//        canvas.drawText("绿色", getWidth() - getWidth() / 3, getHeight() / 3, mTextPaint);
//        super.onDraw(canvas);
//    }
}
