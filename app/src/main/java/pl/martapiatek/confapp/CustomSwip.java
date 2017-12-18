package pl.martapiatek.confapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomSwip extends PagerAdapter {

    private int imageResources[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwip(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.activity_custom_swip, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.swip_image_view);
        TextView textView = (TextView) itemView.findViewById(R.id.imageCount);
        imageView.setImageResource(imageResources[position]);
        textView.setText("Image Counter " +position);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //   super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }
}

