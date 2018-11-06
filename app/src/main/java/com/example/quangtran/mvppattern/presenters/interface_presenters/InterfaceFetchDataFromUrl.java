package com.example.quangtran.mvppattern.presenters.interface_presenters;

import java.io.IOException;

public interface InterfaceFetchDataFromUrl {
    String getJSONStringFromURL(String urlString) throws IOException;
}
