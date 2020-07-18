package com.murari.charubeautyapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.murari.charubeautyapp.Adapter.ColorAdapter;
import com.murari.charubeautyapp.Interface.BrushFragmentListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrushFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrushFragment extends BottomSheetDialogFragment implements ColorAdapter.ColorAdapterListener {

    SeekBar seekBar_brush_size,seekBar_opacity_size;
    RecyclerView recycler_color;
    ToggleButton btn_brush_slate;
    ColorAdapter colorAdapter;

    BrushFragmentListener listener;

    static BrushFragment instance;

    public static BrushFragment getInstance(){
        if(instance==null)
            instance=new BrushFragment();
        return instance;
    }

    public void setListener(BrushFragmentListener listener) {
        this.listener = listener;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BrushFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrushFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrushFragment newInstance(String param1, String param2) {
        BrushFragment fragment = new BrushFragment();
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
        View itemView= inflater.inflate(R.layout.fragment_brush, container, false);

        seekBar_brush_size= itemView.findViewById(R.id.seekbar_brush_size);
        seekBar_opacity_size= itemView.findViewById(R.id.seekbar_brush_opacity);
        btn_brush_slate= itemView.findViewById(R.id.btn_brush_slate);
        recycler_color= itemView.findViewById(R.id.recycler_color);
        recycler_color.setHasFixedSize(true);
        recycler_color.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

         colorAdapter=new ColorAdapter(getContext(),this);
         recycler_color.setAdapter(colorAdapter);

         //Event
        seekBar_opacity_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                listener.onBrushOpacityChangedListener(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar_brush_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                listener.onBrushSizeChangedListener(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_brush_slate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                listener.onBrushSlateChangedListener(isChecked);
            }
        });

        return itemView;
    }



    @Override
    public void onColorSelected(int color) {
        listener.onBrushColorChangedListener(color);
    }
}