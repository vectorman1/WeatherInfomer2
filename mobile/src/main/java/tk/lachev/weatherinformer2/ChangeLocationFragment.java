package tk.lachev.weatherinformer2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import tk.lachev.weatherinformer2.utils.CityPreference;
//Change Location Fragment
public class ChangeLocationFragment extends Fragment {

    Button submitButton;
    EditText locationField;
	public ChangeLocationFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_change_location, container, false);

        submitButton = (Button)rootView.findViewById(R.id.submit);
        locationField = (EditText)rootView.findViewById(R.id.editText);
        //A little bit of "bad user" protection, if he hasn't entered anything worthwhile don't let him click the button.
        locationField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 2) {
                    submitButton.setEnabled(true);
                }
                if (s.length() <= 2) {
                    submitButton.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocation(locationField.getText().toString());
            }
        });

        return rootView;
    }
    //Calling method with already checked text from EditText view's text, calling the SharedPrefs of the selected location, updating it and hiding the keyboard.
    private void changeLocation(String s) {
        CityPreference cityPreference = new CityPreference(getActivity());
        cityPreference.setCity(s);
        Log.i("LocationService", "Updated preferred location.");
        View view = this.getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, new HomeFragment()).commit();
    }
}
