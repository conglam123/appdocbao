package com.example.dattrinh.a24h.xml;

import android.util.Log;
import com.example.dattrinh.a24h.Item;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;

public class XML_Handler_Search extends DefaultHandler {
    private ArrayList<Item> arrItems = new ArrayList<>();
    private Item item;

    public static final String ITEM = "item";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String LINK = "link";
    public static final String PUB_DATE = "pubDate";
    private StringBuilder builder;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        builder = new StringBuilder();
        if (qName.equals(ITEM)) {
            item = new Item();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        builder.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (item == null) {
            return;
        }
        switch (qName) {
            case ITEM:
                arrItems.add(item);
                break;
            case TITLE:
                item.setTitle(builder.toString());
                break;
            case DESCRIPTION:
                builder.length();
                String s1 = "<img src=";
                String s = builder.toString();
                Log.e("des 1", s);
                s = s.substring(s.indexOf(s1) + s1.length() + 3);
                Log.e("des 2", s);
                String img = "ht" + s.substring(0, s.indexOf("target=") - 2);
                Log.e("img", img);
                String s2 = "target=\"_blank\">";
                s = s.substring(s.indexOf(s2) + s2.length());
                String desc = s.substring(0, s.indexOf("<font color=\"#6f6f6f\">"));
                desc = desc.replace("</a>", "");
                desc = desc.replace("&nbsp;", "");
                Log.e("des 3", desc);
                item.setImg(img);
                item.setDescription(desc);
                break;
            case LINK:
                String link = builder.substring(builder.indexOf("url=") + 1);
                Log.e("link", link);
                item.setLink(link);
                break;
            case PUB_DATE:
                item.setPubdate(builder.toString());
                break;
        }
    }

    public ArrayList<Item> getArrItems() {
        return arrItems;
    }
}
