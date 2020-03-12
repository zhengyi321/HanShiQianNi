package com.zhyan.hanshiqianni.findfragment.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhyan.hanshiqianni.R;
import com.zhyan.hanshiqianni.productdetail.ProductDetailActivity;
import com.zhyan.hanshiqianni.utils.ImageLoaderUtils;
import com.zhyan.hanshiqianni.widget.waterfall.WaterFallAdapter;

import java.util.ArrayList;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.BaseViewHolder> {
    //    private ArrayList<Integer> dataList = new ArrayList<>();
    private ArrayList<String> dataList = new ArrayList<>();

    //    ArrayList<String> list 中String改成int 就是本地图片
    public void replaceAll(ArrayList<String> list) {
        dataList.clear();
        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    /**
     * 插入数据使用notifyItemInserted，如果要使用插入动画，必须使用notifyItemInserted
     * 才会有效果。即便不需要使用插入动画，也建议使用notifyItemInserted方式添加数据，
     * 不然容易出现闪动和间距错乱的问题
     * */
    public void addData(int position,ArrayList<String> list) {
        dataList.addAll(position,list);
        notifyItemInserted(position);
    }

    //移除数据使用notifyItemRemoved
    public void removeData(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public FindAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FindAdapter.OneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_find, parent, false));
    }

    @Override
    public void onBindViewHolder(FindAdapter.BaseViewHolder holder, int position) {
        holder.setData(dataList.get(position),position);
    }


    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        void setData(Object data,int position) {

        }
    }

    public class OneViewHolder extends FindAdapter.BaseViewHolder {
//        private ImageView ivImage;
        public View v;
        LinearLayout llyItemFind;
//        LinearLayout llyItemWaterFall;
        public OneViewHolder(View view) {
            super(view);
            v = view;
            llyItemFind = (LinearLayout) view.findViewById(R.id.lly_item_find);
//            ivImage = (ImageView) view.findViewById(R.id.iv_item_water_fall);
//            llyItemWaterFall = (LinearLayout) view.findViewById(R.id.lly_item_water_fall);

        }


        @Override
        void setData(Object data,int position) {
            if (data != null) {
                llyItemFind.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v != null) {
                            Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
//                intent.putExtra("url",url);
                            v.getContext().startActivity(intent);
                        }
                    }
                });
//                本地图片
//                int id = (int) data;
//                ivImage.setImageResource(id);
//                String imageURL = (String) data;
//                ImageLoader.getInstance().displayImage(imageURL,ivImage, ImageLoaderUtils.options);
                //需要Item高度不同才能出现瀑布流的效果，此处简单粗暴地设置一下高度
//                llyItemWaterFall.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(v != null) {
//                            Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
////                intent.putExtra("url",url);
//                            v.getContext().startActivity(intent);
//                        }
//                    }
//                });
              /*  if (position % 2 == 0) {
                    ivImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
                } else {
                    ivImage.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
                }*/
            }
        }
    }


}
