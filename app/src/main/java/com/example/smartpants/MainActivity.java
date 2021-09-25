package com.example.smartpants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import com.example.smartpants.Daily.For_daily;
import com.example.smartpants.Daily.TimeSeriesDaily;
import com.example.smartpants.Daily._20210920;
import com.example.smartpants.Daily._20210921;
import com.example.smartpants.Daily._20210922;
import com.example.smartpants.Daily._20210923;
import com.example.smartpants.Daily._20210924;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AnyChartView anyChartView = findViewById(R.id.any_chart_view);


        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.title("Trend of Sales of the Most Popular Products of ACME Corp.");

        cartesian.yAxis(0).title("Number of Bottles Sold (thousands)");
        cartesian.xAxis(0).labels().padding(5d, 5d, 5d, 5d);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

        Line series1 = cartesian.line(series1Mapping);
        series1.name("Brandy");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);


    }

    List<DataEntry> seriesData;
    void load_data(String data)
    {
        Call<For_daily> daily_data=ApiClient.init().getallrecords("TIME_SERIES_DAILY",data,"full","json","WV53Q3GG3Z18LJIE");
        daily_data.enqueue(new Callback<For_daily>() {
            @Override
            public void onResponse(Call<For_daily> call, Response<For_daily> response) {
                For_daily res=response.body();
                if(res!=null)
                {
                    seriesData = new ArrayList<>();
                    Toast.makeText(getApplicationContext(), "1111111111111", Toast.LENGTH_SHORT).show();
                    TimeSeriesDaily res_daily= res.getTimeSeriesDaily();
                    _20210920 oneday= res_daily.get_20210920();

                    seriesData.add(new CustomDataEntry("20 sept", Integer.parseInt(oneday.get1Open()),
                            Integer.parseInt(oneday.get2High()),
                            Integer.parseInt(oneday.get3Low())));



                    _20210921 _2day= res_daily.get_20210921();

                    seriesData.add(new CustomDataEntry("20 sept", Integer.parseInt(_2day.get1Open()),
                            Integer.parseInt(_2day.get2High()),
                            Integer.parseInt(_2day.get3Low())));

                    _20210922 _3day= res_daily.get_20210922();

                    seriesData.add(new CustomDataEntry("20 sept", Integer.parseInt(_3day.get1Open()),
                            Integer.parseInt(_3day.get2High()),
                            Integer.parseInt(_3day.get3Low())));

                    _20210923 _4day= res_daily.get_20210923();

                    seriesData.add(new CustomDataEntry("20 sept", Integer.parseInt(_4day.get1Open()),
                            Integer.parseInt(_4day.get2High()),
                            Integer.parseInt(_4day.get3Low())));

                    _20210924 _5day= res_daily.get_20210924();

                    seriesData.add(new CustomDataEntry("20 sept", Integer.parseInt(_5day.get1Open()),
                            Integer.parseInt(_5day.get2High()),
                            Integer.parseInt(_5day.get3Low())));
                }


            }



            @Override
            public void onFailure(Call<For_daily> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       load_data(view.toString());
    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }

    }
}