package com.example.mmm;

public class News {
    private String Title;
    private String AUTHOR;
    private int Hinh;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return AUTHOR;
    }



    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public News(String title, String tacgia, int hinh){
     Title = title;
     AUTHOR = tacgia;
     Hinh =hinh;



 }
}
