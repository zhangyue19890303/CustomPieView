package huanju.wanka.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PieBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomPieView customPieView = findViewById(R.id.my_custom_pie_view);
        initData();
        customPieView.setDate(mList);
    }

    /**
     * 模拟数据
     */
    private void initData() {
        mList = new ArrayList<PieBean>();

        PieBean pieBean1 = new PieBean();
        pieBean1.angle = 160;
        pieBean1.color = "#FF0000";
        pieBean1.content = "红色";
        mList.add(pieBean1);

        PieBean pieBean2 = new PieBean();
        pieBean2.angle = 60;
        pieBean2.color = "#0000FF";
        pieBean2.content = "蓝色";
        mList.add(pieBean2);

        PieBean pieBean3 = new PieBean();
        pieBean3.angle = 70;
        pieBean3.color = "#CCCCCC";
        pieBean3.content = "灰色";
        mList.add(pieBean3);

        PieBean pieBean4 = new PieBean();
        pieBean4.angle = 50;
        pieBean4.color = "#7FFF00";
        pieBean4.content = "绿色";
        mList.add(pieBean4);

        PieBean pieBean5 = new PieBean();
        pieBean5.angle = 20;
        pieBean5.color = "#FFFF00";
        pieBean5.content = "黄色";
        mList.add(pieBean5);
    }
}
