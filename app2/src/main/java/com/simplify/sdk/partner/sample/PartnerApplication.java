package com.simplify.sdk.partner.sample;

import android.app.Application;

import com.simplify.sdk.core.cardreader.CardReader;

public class PartnerApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        try {
            CardReader.init(getBaseContext(), CardReader.ADAPTER_MAGTEK_UDYNAMO);
        }
        catch (CardReader.AdapterNotFoundException e) {
            e.printStackTrace();
        }
    }
}
