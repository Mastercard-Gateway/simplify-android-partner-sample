Simplify Commerce - Android Partner SDK Sample App
==================================================

The Simplify Commerce Partner SDK allows easy you to easily integrate card reader support into your mPOS solution.

Installation
------------

### Getting the SDK

In your project's build.gradle file, include the ksoap2 repository by adding the maven declaration to your *repositories* closure

    allprojects {
        repositories {
            jcenter()

            maven {
                url 'http://ksoap2-android.googlecode.com/svn/m2-repo'
            }
        }
    }

In your app module, include the partner SDK dependency via Gradle:

    compile 'com.simplify:partner-sdk-android:1.0.0@aar'

or Maven:

    <dependency>
        <groupId>com.simplify</groupId>
        <artifactId>partner-sdk-android</artifactId>
        <version>1.0</version>
        <type>aar</type>
    </dependency>


### Obtaining the MagTek support library

The required MagTek library is included in this sample app, or you can download from MagTek directly:

1. [Download the Magtek audio library](http://www.magtek.com/support/software/downloads/sw/99510109.zip)
2. Navigate to the `/Audio.And.BulleT/SampleCode/libs` directory
3. Copy the `magtek-scra.jar` file to your module’s `libs` directory
4. Right-click on your module
5. Click on "Open Module Settings"
6. Click the "Dependencies" tab for you application module
7. Click the "+" icon at the bottom of the window
8. Choose "File dependency" from the drop down
9. Select the library


Usage
-----

To initialize the SDK with the correct Magtek device configuration, add the following to your Application onCreate method

    try {
        CardReader.init(getBaseContext(), CardReader.ADAPTER_MAGTEK_UDYNAMO);
    }
    catch (CardReader.AdapterNotFoundException e) {
       e.printStackTrace();
    }

### Incorporating the UI

To receive card details from the UI, you need to implement a listener from your activity

    private CardReaderDialogFragment.CardReaderListener mCardReaderListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    	// …

    	mCardReaderListener = new CardReaderDialogFragment.CardReaderListener()
    	{
    		@Override
    		public void onDisconnect() {
    		}

    		@Override
    		public void onConnect() {
    		}

    		@Override
    		public void onReadSuccess(Map<String, Object> cardInfo) {
    		}

    		@Override
    		public void onReadError(String message) {
    		}
    	};
    }

To show the UI, add the following to your context

    public void showCardReaderDialog()
    {
    	CardReaderDialogFragment dialog = CardReaderDialogFragment.newInstance(mCardReaderListener);
    	dialog.show(getFragmentManager(), “cardreader");
    }