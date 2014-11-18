package com.simplify.sdk.partner.sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.simplify.sdk.partner.CardReaderDialogFragment;
import com.simplify.sdk.partner.Constants;

import java.util.Map;


public class MainActivity extends Activity {

    private CardReaderDialogFragment.CardReaderListener mCardReaderListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_swipe).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showSwipeDialog();
            }
        });

        ((TextView) findViewById(R.id.sdk_version)).setText("Version " + Constants.VERSION_NUMBER);


        mCardReaderListener = new CardReaderDialogFragment.CardReaderListener() {
            @Override
            public void onReadSuccess(Map<String, Object> cardInfo) {
                Toast.makeText(MainActivity.this, "Card read success",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onReadError(String message) {

            }

            @Override
            public void onDisconnect() {

            }

            @Override
            public void onConnect() {

            }
        };
    }

    void showSwipeDialog()
    {
        CardReaderDialogFragment cardReaderDialogFragment = CardReaderDialogFragment.newInstance(mCardReaderListener);
        cardReaderDialogFragment.show(getFragmentManager(), "dialog");
    }
}
