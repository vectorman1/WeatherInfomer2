package tk.lachev.weatherinformer2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
//Calls for default mail app with rec: boris.lachevbg00@gmail.com, predefined topic and body.
public class ReportIssueFragment extends Fragment {
	
	public ReportIssueFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_report_an_issue, container, false);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"boris.lachevbg00@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Problem with WeatherInformer2");
        intent.putExtra(Intent.EXTRA_TEXT, "I am having the following problem/crash with the app WeatherInformer2:");
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), "There are no applications that can handle sending mail.", Toast.LENGTH_SHORT).show();
        }
        return rootView;
    }
}
