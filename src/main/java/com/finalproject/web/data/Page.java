package com.finalproject.web.data;

public class Page {
    private String url;
    private boolean redirect;

    public Page(String url, boolean redirect) {
        this.url = url;
        this.redirect = redirect;
    }

    public Page(String url) {
        this.url = url;
    }

    private Page() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
}
