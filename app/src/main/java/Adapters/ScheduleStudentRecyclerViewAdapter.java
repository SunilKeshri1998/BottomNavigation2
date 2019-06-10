package Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bottomnavigation.R;

import java.util.List;

import DataClass.ScheduleStudentListItemDataClass;

public class ScheduleStudentRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleStudentRecyclerViewAdapter.ViewHolder> {


    private List<ScheduleStudentListItemDataClass> subjectListForStudents;
    private Context context;

    public ScheduleStudentRecyclerViewAdapter(List<ScheduleStudentListItemDataClass> subjectListForStudents, Context context) {
        this.subjectListForStudents = subjectListForStudents;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_schedule_student_recyclerview,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ScheduleStudentListItemDataClass scheduleStudentListItemDataClass=subjectListForStudents.get(i);

        viewHolder.teacher.setText(scheduleStudentListItemDataClass.getTeacher());
        viewHolder.subject.setText(scheduleStudentListItemDataClass.getSubject());
        //viewHolder.slot.setText(scheduleStudentListItemDataClass.getSlot()+"pm");
        if(scheduleStudentListItemDataClass.getClassCancelled()==false)
        {
            viewHolder.listLayout.setBackgroundColor(Color.GREEN);
        }
        else
        {

            viewHolder.listLayout.setBackgroundColor(Color.RED);
        }

    }

    @Override
    public int getItemCount() {
        return subjectListForStudents.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView subject,teacher,slot;
        public LinearLayout listLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            teacher=(TextView)itemView.findViewById(R.id.list_item_schedule_student_teacher);
            subject=(TextView)itemView.findViewById(R.id.list_item_schedule_student_subject);
            slot=(TextView)itemView.findViewById(R.id.list_item_schedule_student_slot);
            listLayout=(LinearLayout)itemView.findViewById(R.id.list_item_schedule_student_main_layout);
        }
    }

}
