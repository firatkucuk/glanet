package org.gaplan.glanet;

import java.util.ArrayList;

public class Blogs {
    public ArrayList<BlogItem> getAll() {
        return FetcherServlet.getAllItems();
    }
}
