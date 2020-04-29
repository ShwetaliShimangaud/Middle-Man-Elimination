package com.example.firebase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class payment_trans extends AppCompatActivity implements PaymentResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_trans);
        Checkout.preload(getApplicationContext());
        String TAG="Error";

        Checkout checkout = new Checkout();

        //checkout.setImage(R.drawable.logo);

        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();

            options.put("name", "Merchant Name");
            options.put("description", "Test Order");
            options.put("currency", "INR");
            options.put("amount", "100");
            checkout.open(activity, options);
        }
        catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);	}
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this,"Payment successful",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();

    }
    }

