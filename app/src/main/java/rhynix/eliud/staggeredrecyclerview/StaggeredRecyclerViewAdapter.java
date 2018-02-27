package rhynix.eliud.staggeredrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by eliud on 2/27/18.
 */

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "StaggeredRecyclerAdpt";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context mContext;

    public StaggeredRecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images ) {
        mNames = imageNames;
        mImageUrls = images;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Called is called");

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext).load(mImageUrls.get(position)).apply(requestOptions).into(holder.image);

        holder.name.setText(mNames.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: You clicked on this item");
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext,InfoActivity.class);
                intent.putExtra("image_url",mImageUrls.get(position));
                intent.putExtra("image_name",mNames.get(position));
                mContext.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.image_name);
        }
    }
}
