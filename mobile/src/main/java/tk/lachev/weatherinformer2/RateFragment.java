package tk.lachev.weatherinformer2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//Nothing still here...
public class RateFragment extends Fragment {
	
	public RateFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_rate, container, false);
         
        return rootView;
    }
}
