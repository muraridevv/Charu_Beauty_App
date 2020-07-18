package com.murari.charubeautyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.murari.charubeautyapp.Adapter.FrameAdapter;
import com.murari.charubeautyapp.Interface.AddFrameListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FrameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrameFragment extends BottomSheetDialogFragment implements FrameAdapter.FrameAdapterListener {

    RecyclerView recycler_frame;
    Button btn_add_frame;

    int frame_selected=-1;

    AddFrameListener listener;

    public void setListener(AddFrameListener listener) {
        this.listener = listener;
    }

    static FrameFragment instance;

    public static FrameFragment getInstance(){
        if(instance==null)
            instance=new FrameFragment();
        return instance;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FrameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FrameFragment newInstance(String param1, String param2) {
        FrameFragment fragment = new FrameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView= inflater.inflate(R.layout.fragment_frame, container, false);

        recycler_frame= itemView.findViewById(R.id.recycler_frame);
        btn_add_frame= itemView.findViewById(R.id.btn_add_frame);

        recycler_frame.setHasFixedSize(true);
        recycler_frame.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recycler_frame.setAdapter(new FrameAdapter(getContext(),this));

        btn_add_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddFrame(frame_selected);
            }
        });
        return itemView;
    }

    @Override
    public void onFrameSelected(int frame) {
        frame_selected=frame;
    }
}