package com.example.newsreader.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsreader.R;
import com.example.newsreader.model.NewsObj;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.File;
import java.util.List;

public class NewsAdapter extends BaseAdapter {

    private Activity activity;
    private List<NewsObj> listData;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;

    public NewsAdapter(Activity activity, List<NewsObj> listData) {
        this.activity = activity;
        this.listData = listData;

        File cacheDir = new File(activity.getCacheDir(), "imgcachedir");
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }

        imageLoader = ImageLoader.getInstance(); // Get singleton instance
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(activity).threadPoolSize(5)
                .threadPriority(Thread.MIN_PRIORITY + 3)
                .denyCacheImageMultipleSizesInMemory()
                // memoryCache(new UsingFreqLimitedMemoryCache(2000000) // You
                // can pass your own memory cache implementation
                .memoryCacheSize(1048576 * 10)
                // 1MB=1048576 *declare 20 or more size if images are more than
                // 200
                .discCache(new UnlimitedDiskCache(cacheDir))
                // You can pass your own disc cache implementation
                // .defaultDisplayImageOptions(DisplayImageOptions.createSimple()
                .build();
        imageLoader.init(config);

        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .resetViewBeforeLoading(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(300)).build();
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = activity.getLayoutInflater().inflate(R.layout.news_item, parent, false);
        ObjectHolder objectHolder = new ObjectHolder();
        objectHolder.tvTitleNews = (TextView) convertView.findViewById(R.id.tv_title_news);
        objectHolder.ivThumbNews = (ImageView) convertView.findViewById(R.id.iv_thumb_news);

        NewsObj newsObj = listData.get(position);
        objectHolder.tvTitleNews.setText(newsObj.getTitleNews());

        imageLoader.displayImage(newsObj.getThumbNews(), objectHolder.ivThumbNews, options, new SimpleImageLoadingListener());
        return convertView;
    }

    class ObjectHolder {
        TextView tvTitleNews;
        ImageView ivThumbNews;
    }
}
