package com.simplify.sdk.partner.sample;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.simplify.sdk.partner.CardReaderDialogFragment;

/**
 * Created by stewartboling on 10/28/14.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    CardReaderDialogFragment cardReaderDialogFragment;

    @SuppressWarnings("deprecation")
    public MainActivityTest() {
        // This constructor was deprecated - but we want to support lower API levels.
        super("com.google.android.apps.common.testing.ui.testapp", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //cardReaderDialogFragment = (CardReaderDialogFragment) getActivity().getFragmentManager().findFragmentByTag("dialog");
    }

    public void testDialogNotNull() throws Exception {
        //assertNotNull(cardReaderDialogFragment);
    }

    public void testDialogVisible() throws Exception {
        //assertEquals(cardReaderDialogFragment.getDialog().isShowing(), true);
    }

    public void testConnectTextVisible() throws Exception {
        //View v = cardReaderDialogFragment.getDialog().getWindow().getDecorView().findViewById(R.id.text_connect);
        //assertEquals(v.getVisibility(), View.VISIBLE);
    }
}
