package rixin.app.officeauto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

import rixin.app.officeauto.R;
import rixin.app.officeauto.myclass.News;

/**
 * Created by egguncle on 16.8.13.
 */
public class HomeRecycleAdapter extends RecyclerView.Adapter<HomeRecycleAdapter.ViewHolder> {

    private List<News> listNews;
    private Context context;
    private PopupWindow popupWindow;


    public HomeRecycleAdapter(Context context, List<News> listNews) {
        this.listNews = listNews;
        this.context = context;

    }

    @Override
    public HomeRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home,
                parent, false));
    }

    @Override
    public void onBindViewHolder(HomeRecycleAdapter.ViewHolder holder, int position) {
        holder.tvItemHomeTitle.setText(listNews.get(position).getStrNewTitle());
        holder.tvItemHomeDate.setText(listNews.get(position).getStrNewDate());
        holder.tvHomeItemAuthor.setText(listNews.get(position).getStrNewAuthor());
        holder.tvHomeItemContent.setText(listNews.get(position).getStrNewContent());
        holder.tvHomeItemForm.setText(listNews.get(position).getStrNewForm());

//        holder.homeLine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listNews == null ? 0 : listNews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItemHomeTitle;
        private TextView tvItemHomeDate;
        private TextView tvHomeItemAuthor;
        private TextView tvHomeItemContent;
        private TextView tvHomeItemForm;
        private LinearLayout homeLine;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItemHomeTitle = (TextView) itemView.findViewById(R.id.tv_item_home_title);
            tvItemHomeDate = (TextView) itemView.findViewById(R.id.tv_item_home_date);
            tvHomeItemAuthor = (TextView) itemView.findViewById(R.id.tv_home_item_author);
            tvHomeItemContent = (TextView) itemView.findViewById(R.id.tv_home_item_content);
            tvHomeItemForm = (TextView) itemView.findViewById(R.id.tv_home_item_form);
            homeLine = (LinearLayout) itemView.findViewById(R.id.item_home_line);
        }

    }
}
