package com.lkmy.illegal.car.util.character4pinyin;

import java.util.Comparator;

/**
 * 作者:李凯
 * 创建时间:2015/12/3 0:52
 * 描述:
 */
public class PinyinComparator implements Comparator<SortModel> {

    public int compare(SortModel o1, SortModel o2) {
        if (o1.getSortLetters().equals("@")
                || o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")
                || o2.getSortLetters().equals("@")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }

}
