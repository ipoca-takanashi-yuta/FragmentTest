package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ipocano58.fragmenttest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends BaseFragment implements View.OnClickListener{
    private static final String ADD = "add";
    private static final String CAN_RETURN = "can_return";
    private static final String ADD_AND_CAN_RETURN = "add_and_can_return";

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        Button button1 = (Button) v.findViewById(R.id.fragment_a_button_add_can_return);
        button1.setTag(ADD_AND_CAN_RETURN);
        button1.setOnClickListener(this);

        Button button2 = (Button) v.findViewById(R.id.fragment_a_button_add);
        button2.setTag(ADD);
        button2.setOnClickListener(this);

        Button button3 = (Button) v.findViewById(R.id.fragment_a_button_replace_can_return);
        button3.setTag(CAN_RETURN);
        button3.setOnClickListener(this);

        Button button4 = (Button) v.findViewById(R.id.fragment_a_button_replace);
        button4.setOnClickListener(this);

        TextView textView = (TextView) getActivity().findViewById(R.id.back_stack_text);
        textView.setText("BackStack数:" + getFragmentManager().getBackStackEntryCount());
        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (v.getTag() != null && (v.getTag().equals(ADD) || v.getTag().equals(ADD_AND_CAN_RETURN)))
            ft.add(R.id.fragment_container, new BFragment());
        else
            ft.replace(R.id.fragment_container, new BFragment());
        if (v.getTag() != null && (v.getTag().equals(CAN_RETURN) || v.getTag().equals(ADD_AND_CAN_RETURN)))
            ft.addToBackStack("FragmentA");
        ft.commit();
    }
}
