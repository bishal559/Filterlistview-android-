package com.example.filterlistview.ListAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filterlistview.Model.ListviewModel;
import com.example.filterlistview.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewAdatper extends BaseAdapter implements Filterable {
    Context context;
    List<ListviewModel>models;
    List<ListviewModel>modelfilter;

    public ListviewAdatper(Context context, List<ListviewModel> models) {
        this.context = context;
        this.models = models;
        this.modelfilter = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context, R.layout.listview,null);
        TextView name=(TextView) view.findViewById(R.id.name);
        TextView type=(TextView)view.findViewById(R.id.type);
        TextView detail=(TextView)view.findViewById(R.id.detail);
        ImageView image=(ImageView)view.findViewById(R.id.image) ;
        name.setText(models.get(position).getName());
        type.setText(models.get(position).getType());
        detail.setText(models.get(position).getDetail());
        int imageID = context.getResources().getIdentifier(models.get(position).getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);
        view.setTag(models.get(position).getId());
        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = modelfilter.size();
                    filterResults.values = modelfilter;

                } else {
                    List<ListviewModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString();
                    for (ListviewModel itemsModel : modelfilter) {
                        if (itemsModel.getName().contains(searchStr) || itemsModel.getType().contains(searchStr)) {
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                models = (List<ListviewModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
