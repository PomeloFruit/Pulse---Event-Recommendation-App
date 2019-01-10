package ca.mypulse.superlegit.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ca.mypulse.superlegit.ExtraPages.EventPage2;
import ca.mypulse.superlegit.ExtraPages.MainActivity;
import ca.mypulse.superlegit.R;
import ca.mypulse.superlegit.ExtraPages.TestActivity;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int [] images = {R.drawable.placeholder, R.drawable.legoat, R.drawable.placeholder};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem (ViewGroup container, final int position){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.custom_layout, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setAlpha(0.80f);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                if(position == 0){
                    Intent intent1 = new Intent(view.getContext(), EventPage2.class);
                    context.startActivity(intent1);
                } else if (position == 1){
                    Intent intent2 = new Intent(view.getContext(), MainActivity.class);
                    context.startActivity(intent2);
                } else{
                    Intent intent3 = new Intent(view.getContext(), TestActivity.class);
                    context.startActivity(intent3);
                }

            }
        });

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }
}
