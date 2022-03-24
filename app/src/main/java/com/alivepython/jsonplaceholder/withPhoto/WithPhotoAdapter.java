package com.alivepython.jsonplaceholder.withPhoto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.jsonplaceholder.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

public class WithPhotoAdapter extends RecyclerView.Adapter<WithPhotoAdapter.viewHolder>{
    private List<WithPhotoModelClass> list;
    private Context context;

    public WithPhotoAdapter(List<WithPhotoModelClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.with_photo_recycle_item, parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        WithPhotoModelClass withPhotoModelClass= list.get(position);

        holder.albumId.setText(withPhotoModelClass.getAlbumId()+"");
        holder.id.setText(withPhotoModelClass.getId()+"");
        holder.title.setText(withPhotoModelClass.getTitle());



        Picasso.get()
                .load(withPhotoModelClass.getThumbnailUrl()+"")
                .into(holder.thumbUrl);

        Picasso.get()
                .load(withPhotoModelClass.getUrl()+"")
                .into(holder.mainImageUrl);

    }

    @Override
    public int getItemCount() {
        if (list.size() == 0){
            return 0;
        }
        else {
            return list.size();
        }
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView thumbUrl,mainImageUrl;
        TextView albumId, id,title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            albumId= itemView.findViewById(R.id.with_image_albam_id);
            id= itemView.findViewById(R.id.with_image_id);
            title= itemView.findViewById(R.id.with_image_title);
            thumbUrl= itemView.findViewById(R.id.with_image_thump_url);
            mainImageUrl= itemView.findViewById(R.id.with_image_main_image_url);


        }
    }


//    private class DownloadImageFromInternet extends AsyncTask<String,Void, Bitmap>{
//
//        ImageView imageView;
//
//        public DownloadImageFromInternet(ImageView imageView) {
//            this.imageView = imageView;
//        }
//
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//            String imageUrl= strings[0];
//            Bitmap bimage= null;
//            try{
//                InputStream in= new java.net.URL(imageUrl).openStream();
//                bimage= BitmapFactory.decodeStream(in);
//            }catch (Exception e){
//                Log.e("Error message", e.getMessage() );
//                e.printStackTrace();
//            }
//            return bimage;
//        }
//
//        protected void onPostExecute(Bitmap result){
//            imageView.setImageBitmap(result);
//        }
//    }
}
