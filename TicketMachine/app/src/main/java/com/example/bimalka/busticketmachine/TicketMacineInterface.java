package com.example.bimalka.busticketmachine;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.*;

public class TicketMacineInterface extends AppCompatActivity {

    private TextView busnumber;
    private TextView from;
    private TextView to;
    private TextView availableSeats;
    private Button save;


    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_macine_interface);

        busnumber =(TextView) findViewById(R.id.txtBusNumber) ;
        from =(TextView) findViewById(R.id.txtFrom) ;
        to =(TextView) findViewById(R.id.txtTo) ;
        availableSeats =(TextView) findViewById(R.id.txtAvailableSeats) ;
        save = (Button) findViewById(R.id.btnAddBusDetails);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("BusTrackingDetails");
        ActivityCompat.requestPermissions(TicketMacineInterface.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });

    }

    public void swtOption(View view){
        Switch swtOption=(Switch) findViewById(R.id.switchFromToInvert);
        from =(TextView) findViewById(R.id.txtFrom) ;
        to =(TextView) findViewById(R.id.txtTo) ;
        if(swtOption.isChecked()){
            from.setText("Badulla");
            to.setText("Colombo");
            System.out.println("HI");
        }else{
            from.setText("Colombo");
            to.setText("Badulla");
        }
    }

    private void addData() {
        String Busnumber = busnumber.getText().toString().trim();
        String From = from.getText().toString().trim();
        String To = to.getText().toString().trim();
        String AvailableSeats = availableSeats.getText().toString().trim();

       GPSTracker g = new GPSTracker(getApplicationContext());
       Location l = g.getLastKnownLocation();

            //double latitude = l.getLatitude();
           // double longtitude = l.getLongitude();

            //Toast.makeText(getApplicationContext(),"LAT : "+latitude+"\n LON"+longtitude,Toast.LENGTH_SHORT).show();

        SaveBusDetails saveBusDetails = new SaveBusDetails(Busnumber,From,To,AvailableSeats/*,latitude,longtitude*/);

        databaseReference.push().setValue(saveBusDetails);
        Toast.makeText(getApplication(),"Saved Successfully",Toast.LENGTH_LONG).show();
    }


}
