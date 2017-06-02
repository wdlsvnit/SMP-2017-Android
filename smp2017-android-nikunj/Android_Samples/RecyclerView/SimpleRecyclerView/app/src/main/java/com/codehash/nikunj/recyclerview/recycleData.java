package com.codehash.nikunj.recyclerview;

import java.util.ArrayList;

/**
 * Created by nikunj on 2/6/17.
 */

public class recycleData  {
    public String recyclestring1;
    public String recyclestring2;
    public recycleData(String recyclestring1,String recyclestring2)
    {
        this.recyclestring1=recyclestring1;
        this.recyclestring2=recyclestring2;
    }
    public String getRecyclerString1()
    {
        return  recyclestring1;
    }
    public String getRecyclerString2()
    {
        return  recyclestring2;
    }
    public static int id=67;

    public static ArrayList<recycleData> createList(int total)
    {
        ArrayList<recycleData> ar = new ArrayList<recycleData>();
        for(int i=1;i<=total;i++)
        {
            ar.add(new recycleData("HackingTeam","U16CO0"+String.valueOf(id++)));
        }
        return ar;
    }
}
