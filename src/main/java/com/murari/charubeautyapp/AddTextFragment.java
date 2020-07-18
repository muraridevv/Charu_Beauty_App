package com.murari.charubeautyapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.murari.charubeautyapp.Adapter.ColorAdapter;
import com.murari.charubeautyapp.Interface.AddTextFragmentListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTextFragment extends BottomSheetDialogFragment implements ColorAdapter.ColorAdapterListener {

    int colorSelected= Color.parseColor("#000000");//default color of text is black

    AddTextFragmentListener listener;

    EditText edit_add_text;
    RecyclerView recycler_color;
    Button btn_done;

    public void setListener(AddTextFragmentListener listener) {
        this.listener = listener;
    }

    static AddTextFragment instance;

    public static AddTextFragment getInstance() {
        if (instance==null)
            instance=new AddTextFragment();
        return instance;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddTextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddTextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddTextFragment newInstance(String param1, String param2) {
        AddTextFragment fragment = new AddTextFragment();
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
        View itemView= inflater.inflate(R.layout.fragment_add_text, container, false);
        edit_add_text= itemView.findViewById(R.id.edit_add_text);
        btn_done= itemView.findViewById(R.id.btn_done);
        recycler_color= itemView.findViewById(R.id.recycler_color);
        recycler_color.setHasFixedSize(true);
        recycler_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        ColorAdapter colorAdapter=new ColorAdapter(getContext(),this);
        recycler_color.setAdapter(colorAdapter);

        //Event
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddTextButtonClick(edit_add_text.getText().toString(),colorSelected);
            }
        });

        return itemView;
    }

    @Override
    public void onColorSelected(int color) {
        colorSelected=color; //set color when user select
    }
}