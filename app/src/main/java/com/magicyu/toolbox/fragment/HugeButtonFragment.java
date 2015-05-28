package com.magicyu.toolbox.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.magicyu.toolbox.R;

/**
 * Created by yushiwei on 15-5-27.
 */
public class HugeButtonFragment extends Fragment{

    LinearLayout layout;

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.huge_button_fragment, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    public void init() {
        listView = (ListView) getActivity().findViewById(R.id.hugeButtonListView);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int i) {
                return "FFF";
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_huge_button_split, null);
                    LinearLayout layout = (LinearLayout) view.findViewById(R.id.huge_button_layout);
                    layout.setMinimumHeight(getActivity().getWindowManager().getDefaultDisplay().getWidth());
                }
                return view;
            }
        });
    }
}
