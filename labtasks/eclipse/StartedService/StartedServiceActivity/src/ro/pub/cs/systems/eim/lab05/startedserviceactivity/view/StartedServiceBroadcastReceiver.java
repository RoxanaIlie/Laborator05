package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract.Constants;
import android.widget.TextView;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 8 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 6 - get the action and the extra information from the intent
        // and set the text on the messageTextView
    	String action = intent.getAction();
    	String data = null;
    	
        if (ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants.ACTION_STRING.equals(action)) {
        	data = intent.getStringExtra(Constants.DATA);
        } else if (ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants.ACTION_INTEGER.equals(action)) {
        	data = String.valueOf(intent.getIntExtra(ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants.DATA, -1));
        } else if (ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants.ACTION_ARRAY_LIST.equals(action)) {
        	data = intent.getStringArrayExtra(ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants.DATA).toString();
        }

        if (messageTextView != null)
        	messageTextView.setText(messageTextView.getText().toString() + "\n" + data);
        
        
        // TODO: exercise 8 - restart the activity through an intent
        // if the messageTextView is not available
        Intent startedServiceActivityIntent = new Intent(context, StartedServiceActivity.class);
        startedServiceActivityIntent.putExtra(ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants.MESSAGE, data);
        startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(startedServiceActivityIntent);
    }

}
