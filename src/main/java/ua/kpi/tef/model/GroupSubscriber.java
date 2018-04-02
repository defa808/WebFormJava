package main.java.ua.kpi.tef.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Gavriliak on 14.02.2018.
 */
public enum GroupSubscriber {
    USER, ADMIN;

    public static ArrayList<GroupSubscriber> getCollection() {
        ArrayList<GroupSubscriber> items = new ArrayList<GroupSubscriber>();
        for (GroupSubscriber a : GroupSubscriber.values())
            items.add(a);
        return items;
    }
}
