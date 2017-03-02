package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ipocano58.fragmenttest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends BaseFragment {
    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView textView = (TextView) getActivity().findViewById(R.id.back_stack_text);
        textView.setText("BackStack数:" + getFragmentManager().getBackStackEntryCount());

        View v = inflater.inflate(R.layout.fragment_c, container, false);

        if (getFragmentManager().getBackStackEntryCount() == 2) {
            Button button1 = (Button) v.findViewById(R.id.fragment_c_button_return_a);
            button1.setVisibility(View.VISIBLE);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().popBackStack("FragmentA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    Fragment fragmentA = getFragmentManager().findFragmentByTag("TagA");
                    fragmentA.onResume();
                }
            });

            Button button2 = (Button) v.findViewById(R.id.fragment_c_button_return_b);
            button2.setVisibility(View.VISIBLE);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().popBackStack("FragmentB", FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                    ((MainActivity)getActivity()).setStackCountText();
                }
            });
        }
        else if (getFragmentManager(). getBackStackEntryCount() == 1) {
            Button button = (Button) v.findViewById(R.id.fragment_c_button_return);
            button.setVisibility(View.VISIBLE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().popBackStack();
//                    ((MainActivity)getActivity()).setStackCountText();
                }
            });
        }

        return v;
    }

    @Override
    protected void initView() {
        TextView textView = (TextView) getActivity().findViewById(R.id.back_stack_text);
        textView.setText("BackStack数:" + getFragmentManager().getBackStackEntryCount());
        super.initView();
    }
}
