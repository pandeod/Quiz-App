package com.internship.scheduler.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.internship.scheduler.Entity.CalendarEvent;
import com.internship.scheduler.R;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    List<CalendarEvent> eventItems;
    Context context;

    public CalendarAdapter() {
    }

    public CalendarAdapter(List<CalendarEvent> eventItems, Context context) {
        this.eventItems = eventItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CalendarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_events_list_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CalendarAdapter.ViewHolder holder, int position) {
        final CalendarEvent eventItem=eventItems.get(position);
        holder.quizTitle.setText(eventItem.getTitle());
        holder.quizSubject.setText(eventItem.getSubject());
        holder.quizTime.setText(eventItem.getTiming());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.itemView.getContext());
                builder.setTitle(eventItem.getTitle());
                String msg=eventItem.getSubject()+"\nSyllabus : "+eventItem.getDescription()+"\nTiming : "+eventItem.getTiming()+"\nLabs : "+eventItem.getLabs()+"\n\nFaculty In-charge : "+eventItem.getAuthor();
                builder.setMessage(msg);
                builder.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return eventItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quizTitle;
        TextView quizSubject;
        TextView quizTime;
        TextView quizLabs;
        public ViewHolder(View itemView) {
            super(itemView);
            quizTitle=itemView.findViewById(R.id.quiz_title);
            quizSubject=itemView.findViewById(R.id.quiz_subject);
            quizTime=itemView.findViewById(R.id.quiz_timing);
        }
    }
}
