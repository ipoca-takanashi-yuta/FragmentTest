package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import com.example.ipocano58.fragmenttest.R;

/**
 * Created by ipocaNO58 on 2017/03/02.
 */

public class BaseFragment extends Fragment {

    protected String mTag = "BaseFragment";
    
    
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(mTag, "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(mTag, "onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(mTag, "onDestroyView");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d(mTag, "onAttachFragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTag = this.getClass().getSimpleName();
        Log.d(mTag, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(mTag, "onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(mTag, "onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(mTag, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(mTag, "onResume");
        initView();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(mTag, "onStop");
    }

    protected void initView(){
        TextView textView = (TextView) getActivity().findViewById(R.id.back_stack_text);
        textView.setText("BackStack数:" + getFragmentManager().getBackStackEntryCount());
    }
}
