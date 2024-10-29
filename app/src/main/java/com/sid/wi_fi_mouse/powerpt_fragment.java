package com.sid.wi_fi_mouse;

/*
  Created by Siddharth Sonawane on 14-April-2021.
  Siddharth Sonawane
 K.B.H. Polytechnic Malegaon,
 Nashik-423 205, India
 */

/*Copyright Siddharth Sonawane
 *Copyright infringement is the use of works protected by copyright law
 * without permission, infringing certain exclusive rights granted to the copyright holder,
 * such as the right to reproduce, distribute, display or perform the protected work, or to make derivative works.
 * It is a punishable offence under Copyright Act, 1957
 */


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import java.io.PrintWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class powerpt_fragment extends Fragment {

    PrintWriter out = ConnectionSingleton.getPrintWriter();

    ImageButton next;
    ImageButton prev;
    ImageButton start;
    ImageButton end;
    ImageButton pen;

    public powerpt_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_powerpt_fragment, container, false);

        next = (ImageButton)view.findViewById(R.id.imageButton14);
        prev = (ImageButton)view.findViewById(R.id.imageButton13);
        start = (ImageButton)view.findViewById(R.id.imageButton2);
        end = (ImageButton)view.findViewById(R.id.imageButton12);
        pen = (ImageButton)view.findViewById(R.id.imageButton11);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.NEXT_SLIDE);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.PREV_SLIDE);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.START);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.END);
            }
        });

        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.PEN);
            }
        });

        return view;
    }
/*
  Created by Siddharth Sonawane on 14-April-2021.
  Siddharth Sonawane
 K.B.H. Polytechnic Malegaon,
 Nashik-423 205, India
 */
}
