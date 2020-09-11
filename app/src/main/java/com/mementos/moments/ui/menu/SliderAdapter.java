package com.mementos.moments.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mementos.moments.PromoActivity;
import com.mementos.moments.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
//        viewHolder.textViewDescription.setText("This is slider item " + position);

        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load("https://live.staticflickr.com/65535/49256836337_258f8074be_b.jpg")
                        .into(viewHolder.imageViewBackground);
                break;
//            case 1:
//                Glide.with(viewHolder.itemView)
//                        .load("https://live.staticflickr.com/65535/48830854386_7206ff896c_k.jpg")
//                        .into(viewHolder.imageViewBackground);
//                break;
//            case 2:
//                Glide.with(viewHolder.itemView)
//                        .load("https://live.staticflickr.com/65535/48830476603_12693c33b4_k.jpg")
//                        .into(viewHolder.imageViewBackground);
//                break;
//            default:
//                Glide.with(viewHolder.itemView)
//                        .load("https://live.staticflickr.com/65535/49256007938_b72bb186d9_b.jpg")
//                        .into(viewHolder.imageViewBackground);
//                break;

        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, PromoActivity.class));
            }
        });

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 1;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
//            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
