package com.example.bottomnavigation;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

import Adapters.ScheduleStudentRecyclerViewAdapter;
import DataClass.ScheduleStudentListItemDataClass;

public class ScheduleFragment extends Fragment {

    class Node {
        String teacher_name, subject_name, subject_code, room_no;

        public Node() {
            this.teacher_name = "Teacher Name";
            this.subject_name = "subject_name";
            this.subject_code = "subject_code";
            this.room_no = "room_no";
        }
    }

    Node[] node;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_schedule, container, false);
        generateObjectArrayNode(view);

        return view;
    }

    public void generateObjectArrayNode(View view) {
        node = new Node[41];
        for (int i = 0; i < 41; i++)
            node[i] = new Node();
        setButtons(view);
    }

    private void setButtons(View view) {
        char x = 'b', y = '1';
        for (int i = 1; i <= 40; i++) {
            String sId = Character.toString(x) + "" + Character.toString(y);
            int id = getResources().getIdentifier(sId, "id", getActivity().getPackageName());
            if (id == 0) {
                Toast.makeText(getContext(), sId + "NULL", Toast.LENGTH_SHORT).show();
            } else {
                node[i].teacher_name = "RABI SHAW";
                node[i].subject_name = "OPERATING SYSTEMS";
                node[i].room_no = "204";
                final int j=i;

                Button button = view.findViewById(id);
                button.setText("CS501");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Dialog student_dialog = new Dialog(getContext());
                        student_dialog.setContentView(R.layout.schedule_student_dialog);

                        TextView teacher_dialog, subject_dialog, room_dialog;
                        teacher_dialog = student_dialog.getWindow().findViewById(R.id.dialog_teacher);
                        subject_dialog = student_dialog.getWindow().findViewById(R.id.dialog_subject);
                        room_dialog = student_dialog.getWindow().findViewById(R.id.dialog_room);
                        teacher_dialog.setText(node[j].teacher_name);
                        subject_dialog.setText(node[j].subject_name);
                        room_dialog.setText(node[j].room_no);

                        student_dialog.setCanceledOnTouchOutside(true);
                        student_dialog.show();
                    }
                });
            }
            y++;

            if (y > '5') {
                y = '1';
                x++;
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
