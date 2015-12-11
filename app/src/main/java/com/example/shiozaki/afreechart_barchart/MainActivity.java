package com.example.shiozaki.afreechart_barchart;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.chart.plot.PlotOrientation;
import org.afree.data.xy.XYSeries;
import org.afree.data.xy.XYSeriesCollection;
import org.afree.graphics.SolidColor;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("XYSeries");
        series.add(1, 1);
        series.add(2, 2);
        series.add(3, 3);
        series.add(4, 2);
        series.add(5, 3);
        series.add(6, 4);
        series.add(7, 7);
        dataset.addSeries(series);

        AFreeChart chart = ChartFactory.createXYLineChart(
                "タイトル",
                "X軸ラベル",
                "Y軸ラベル",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        chart.setBackgroundPaintType(new SolidColor(Color.GRAY));//背景の色
        chart.setBorderPaintType(new SolidColor(Color.BLACK));//枠線の色

        GraphView spcv = (GraphView) findViewById(R.id.graphView1);
        spcv.setChart(chart);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}