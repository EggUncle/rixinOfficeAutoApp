package rixin.app.officeauto.fragment;

/**
 * Created by 胡钰 on 2016/8/3.
 *
 * home页面
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import java.util.ArrayList;
import java.util.List;

import rixin.app.officeauto.R;
import rixin.app.officeauto.activity.MainActivity;
import rixin.app.officeauto.adapter.HomeRecycleAdapter;
import rixin.app.officeauto.myclass.CircleImageView;
import rixin.app.officeauto.myclass.LocalImageHolderView;
import rixin.app.officeauto.myclass.News;
import rixin.app.officeauto.myclass.ResideMenu;
import rixin.app.officeauto.myclass.XCRecyclerView;


public class HomeFragment extends Fragment {

    private View parentView;
    private View headView;
    private Context context;
    private ResideMenu resideMenu;
    private ConvenientBanner convenientBanner;
    private XCRecyclerView rcvHome;
    private HomeRecycleAdapter homeRecycleAdapter;
    private List<News> listNews;

    private ImageButton imgHomeLeftBar;

    //设置图片数据用于测试显示效果
    private String[] testImages = {

    };
    private ArrayList<Integer> localImages = new ArrayList<Integer>();

    public HomeFragment() {

    }

    public HomeFragment(Context context) {
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.frag_home, container, false);
        headView = inflater.inflate(R.layout.frag_home_head, null);
        initVars();
        setUpViews();
        initView();
        return parentView;
    }

    private void setUpViews() {
        MainActivity parentActivity = (MainActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();



        // add gesture operation's ignored views
//        FrameLayout ignored_view = (FrameLayout) parentView.findViewById(R.id.ignored_view);
//        resideMenu.addIgnoredView(ignored_view);
    }

    //设置一些用于测试显示效果的模拟数据
    private void initVars() {

        listNews = new ArrayList<>();
        News news = new News();
        news.setStrNewTitle("周四晚南区礼堂,不见不散");
        news.setStrNewDate("一小时前");
        news.setStrNewAuthor("发布消息者名称");
        news.setStrNewContent("内容内容内容内容内容内容内容内容内容内容内容" +
                "内容内容内容内容内内容内容内容内内容内容内容内内容内容" +
                "内容内内容内容内容内内容内容内容内内容内容内容内内容内容内容内内容内容内容内");
        news.setStrNewForm("日新网");
        for (int i = 0; i < 3; i++) {
            listNews.add(news);
        }

        for (int position = 0; position < 5; position++) {
            localImages.add(R.drawable.tools_activity);
        }


    }

    private void initView() {

        homeRecycleAdapter = new HomeRecycleAdapter(context, listNews);
        rcvHome = (XCRecyclerView) parentView.findViewById(R.id.rcv_home);
        rcvHome.addHeaderView(headView);
        rcvHome.setAdapter(homeRecycleAdapter);
        convenientBanner = (ConvenientBanner) headView.findViewById(R.id.home_convenientBanner);
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.home_banner_slider, R.drawable.home_banner_slider_highlighted})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响

        MainActivity parentActivity = (MainActivity) getActivity();
        resideMenu = parentActivity.getResideMenu();
        resideMenu.addIgnoredView(convenientBanner);

        imgHomeLeftBar = (ImageButton) headView.findViewById(R.id.img_home_left_bar);
        imgHomeLeftBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
    }

}
