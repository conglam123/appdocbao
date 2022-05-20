package com.example.dattrinh.a24h.drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.dattrinh.a24h.R;
import java.util.ArrayList;

public class Item_dr_adapter extends RecyclerView.Adapter<Item_dr_adapter.ItemHolder> {
    private ArrayList<Item_drawer> arr_drawer;
    private OnClickItemListner onClickItemListner;
    private Context context;

    public void setOnClickItemListener(OnClickItemListner onClickItemListener) {
        this.onClickItemListner = onClickItemListener;
    }

    public Item_dr_adapter(Context context) {
        this.context = context;
        initData();
    }

    private void initData() {
        arr_drawer = new ArrayList<>();
        arr_drawer.add(new Item_drawer("Trang chủ", "https://tuoitre.vn/rss/tin-moi-nhat.rss"));
        arr_drawer.add(new Item_drawer("Thể thao", "https://tuoitre.vn/rss/the-thao.rss"));
        arr_drawer.add(new Item_drawer("Thời sự", "https://tuoitre.vn/rss/thoi-su.rss"));
        arr_drawer.add(new Item_drawer("Nhịp sống trẻ", "https://tuoitre.vn/rss/nhip-song-tre.rss"));
        arr_drawer.add(new Item_drawer("Du lịch", "https://tuoitre.vn/rss/du-lich.rss"));
        arr_drawer.add(new Item_drawer("Xe", "https://tuoitre.vn/rss/xe.rss"));
        arr_drawer.add(new Item_drawer("Sức khỏe", "https://tuoitre.vn/rss/suc-khoe.rss"));
        arr_drawer.add(new Item_drawer("Giải trí", "https://tuoitre.vn/rss/giai-tri.rss"));
        arr_drawer.add(new Item_drawer("Giáo dục", "https://tuoitre.vn/rss/giao-duc.rss"));
        arr_drawer.add(new Item_drawer("Văn hóa", "https://tuoitre.vn/rss/van-hoa.rss"));
        arr_drawer.add(new Item_drawer("Kinh doanh", "https://tuoitre.vn/rss/kinh-doanh.rss"));
        arr_drawer.add(new Item_drawer("Công nghệ", "https://tuoitre.vn/rss/nhip-song-so.rss"));

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_drawer, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.txt_drawer.setText(arr_drawer.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return arr_drawer.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_drawer;

        private TextView txt_drawer;

        public ItemHolder(View itemView) {
            super(itemView);
            txt_drawer = itemView.findViewById(R.id.txt_name_drawer);
            ll_drawer = itemView.findViewById(R.id.ll_drawer);
            ll_drawer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItemListner.OnClick(arr_drawer.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnClickItemListner {
        void OnClick(Item_drawer item_drawer);
    }
}
