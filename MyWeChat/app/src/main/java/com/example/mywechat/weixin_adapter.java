package com.example.mywechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class weixin_adapter extends RecyclerView .Adapter<weixin_adapter.SwipeViewHolder> implements ItemTouchHelperListener{
    private List<String>list;
    private Context context;
    private View inflater;

    public weixin_adapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public SwipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(context).inflate(R.layout.item1,parent,false);
        SwipeViewHolder swipeviewholder=new SwipeViewHolder(inflater);
        return swipeviewholder;
    }

    @Override
    public void onBindViewHolder(SwipeViewHolder holder, int position) {
        holder.teamContent.setText(list.get(position));
    }

    @Override
    public int getItemCount() {return list.size();}

    @Override
    public void onItemDismiss1(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }
        list.remove(position);
        notifyItemRemoved(position);

        if (position != list.size()) {
            notifyItemRangeChanged(position, list.size() - position);
        }
    }
    public void onItemDismiss(int fromPosition, int toPosition)
    {
        String prev = list.remove(fromPosition);
        list.add(toPosition > fromPosition ? toPosition - 1 : toPosition, prev);
        notifyItemMoved(fromPosition, toPosition);
    }
    public class SwipeViewHolder extends RecyclerView.ViewHolder{
        TextView teamContent;

        public SwipeViewHolder(View itemView) {
            super(itemView);
            teamContent = itemView.findViewById(R.id.team_content);
        }
    }
}
