<template>
  <ejs-chart id="container" :title='title' :primaryXAxis='primaryXAxis'>
      <e-series-collection>
        <e-series :dataSource="forecastList" type="Line" xName="date" yName="temperature" name="Temperature"> </e-series>
      </e-series-collection>
  </ejs-chart>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { provide } from 'vue';
import axios from "axios";
import { ChartComponent as EjsChart, SeriesCollectionDirective as ESeriesCollection, SeriesDirective as ESeries, LineSeries, Legend, Category } from "@syncfusion/ej2-vue-charts";

const forecastList = ref([]);

const fetchForecastData = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/demo-fran/forecast?latitude=12&longitude=10");
    forecastList.value = response.data.forecastList;
  } catch (error) {
    console.error("There was an error fetching the forecast data:", error);
  }
};

onMounted(fetchForecastData);



const title = 'Sales Analysis';
const primaryXAxis = {valueType: 'Category'};
const chart = [LineSeries, Legend, Category];
provide('chart', chart);
</script>