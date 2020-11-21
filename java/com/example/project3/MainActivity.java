package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bySex(View view){
        Intent bySexIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quickchart.io/chart?bkg=white&c={ type: 'bar', data: { labels: ['Male', 'Female', 'Unknown'], datasets: [{ label: 'Positive Cases', data: [25276, 30803, 293] }] }}"));
        startActivity(bySexIntent);
    }

    public void byOutcome(View view) {
        Intent byOutcomeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quickchart.io/chart?bkg=white&c={ type: 'bar', data: { labels: ['Philadelphia County'], datasets: [{ label: 'Total Cases', data: [55302] }, { label: 'Cases per 1M People', data: [35993] }, { label: 'New Cases', data: [2579] }, { label: 'Total Deaths', data: [1935] }] }}"));
        startActivity(byOutcomeIntent);
    }

    public void testingSites(View view) {
        Intent byDateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.phila.gov/covid-testing-sites/"));
        startActivity(byDateIntent);
    }

    public void byCounty(View view) {
        Intent byCountyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quickchart.io/chart?bkg=white&c={ type: 'bar', data: { labels: ['Philadelphia', 'Allegheny', 'Montgomery', 'Delaware'], datasets: [{ label: 'Total Cases', data: [55302, 20526, 17631, 16736] }] }}"));
        startActivity(byCountyIntent);
    }

    public void byAge(View view) {
        Intent byAgeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quickchart.io/chart?bkg=white&c={ type: 'bar', data: { labels: ['Ages'], datasets: [{ label: '>20', data: [5506] }, { label: '20-34', data: [17425] }, { label: '35-54', data: [16778] }, { label: '55-74', data: [12342] }, { label: '75+', data: [4292] }] }}"));
        startActivity(byAgeIntent);
    }

    public void byRace(View view) {
        Intent byRaceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quickchart.io/chart?bkg=white&c={ type: 'bar', data: { labels: ['Races'], datasets: [{ label: 'White', data: [10710] }, { label: 'Black', data: [20164] }, { label: 'Hispanic', data: [6807] }, { label: 'Asian', data: [1840] }, { label: 'Other', data: [2219] }] }}"));
        startActivity(byRaceIntent);
    }

    public void information(View view){
        Intent informationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://opendataphilly.org/dataset/covid-cases"));
        startActivity(informationIntent);
    }
}