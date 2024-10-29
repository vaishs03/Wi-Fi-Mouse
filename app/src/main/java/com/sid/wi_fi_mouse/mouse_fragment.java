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


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.PrintWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class mouse_fragment extends Fragment {

    Button left_click;
    Button right_click;
    TextView mousePad;

    private boolean mouseMoved=false;
    PrintWriter out = ConnectionSingleton.getPrintWriter();

    private float initX =0;
    private float initY =0;
    private float disX =0;
    private float disY =0;

    public mouse_fragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mouse_fragment, container, false);

        left_click = (Button)view.findViewById(R.id.left_click);
        right_click = (Button)view.findViewById(R.id.right_click);
        mousePad = (TextView)view.findViewById(R.id.mousePad);

        mousePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //save X and Y positions when user touches the TextView
                        initX = event.getX();
                        initY = event.getY();
                        mouseMoved = false;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        disX = event.getX() - initX; //Mouse movement in x direction
                        disY = event.getY() - initY; //Mouse movement in y direction
                            /*set init to new position so that continuous mouse movement
                            is captured*/
                        initX = event.getX();
                        initY = event.getY();
                        if (disX != 0 || disY != 0) {
                            out.println(disX + "," + disY); //send mouse movement to server
                        }
                        mouseMoved = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        //consider a tap only if usr did not move mouse after ACTION_DOWN
                        if (!mouseMoved) {
                            out.println(Constants.MOUSE_LEFT_CLICK);
                        }
                }
                return true;
            }
        });

        left_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.MOUSE_LEFT_CLICK);
            }
        });
        right_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out.println(Constants.MOUSE_RIGHT_CLICK);
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
