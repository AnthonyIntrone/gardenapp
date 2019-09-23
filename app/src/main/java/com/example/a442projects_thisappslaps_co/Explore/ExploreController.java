package com.example.a442projects_thisappslaps_co.Explore;
import com.example.a442projects_thisappslaps_co.R;

import java.util.ArrayList;
import java.util.List;


public class ExploreController {
    List<Integer> createDummyList() {
        List<Integer> dummyList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            if (i % 5 == 0) {
                dummyList.add(R.color.colorPrimaryDark);
            }
            else if (i % 2 == 0) {
                dummyList.add(R.color.design_default_color_primary);
            }
            else {
                dummyList.add(R.color.colorAccent);
            }
        }

        return dummyList;
    }
}