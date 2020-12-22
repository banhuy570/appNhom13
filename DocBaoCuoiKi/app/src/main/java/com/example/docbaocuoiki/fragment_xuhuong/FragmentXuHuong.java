package com.example.docbaocuoiki.fragment_xuhuong;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.docbaocuoiki.DetailLink;
import com.example.docbaocuoiki.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class FragmentXuHuong extends Fragment {
    ListView listView;
    List<String> arrList = new ArrayList<>();
    List<String> arrLink = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    Intent intent;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.activity_fragment_xu_huong, container, false);
        listView = root.findViewById(R.id.lvXuHuong);

        AsyncTask<String,Void,String> content =
                new DongBoDuLieu().execute("https://vnexpress.net/rss/tin-xem-nhieu.rss");//hoi doinbackground
        arrayAdapter = new ArrayAdapter( FragmentXuHuong.this.getActivity(), android.R.layout.simple_list_item_1 ,arrList);
        listView.setAdapter(arrayAdapter);

        intent = new Intent(FragmentXuHuong.this.getActivity(), DetailLink.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String link = arrLink.get(position);
                intent.putExtra("linkURL",link);
                startActivity(intent);
            }

        });
        return root;
    }
    public class DongBoDuLieu extends AsyncTask<String,Void,String>{
        //dua du lieu len dien thoai
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLParser xmlParser = new XMLParser();
            try {
                Document document = xmlParser.getDocument(s);
                NodeList nodeList = document.getElementsByTagName("item");
                String title="";
                for(int i=0;i<nodeList.getLength();i++)
                {
                    Element element = (Element)nodeList.item(i);
                    title=xmlParser.getValue(element,"title")+"\n";
                    arrList.add(title);
                    arrLink.add(xmlParser.getValue(element,"link"));
                }
                arrayAdapter.notifyDataSetChanged();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //ham doc du lieu tu server
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);//lay duong link
                //tao luong doc
                InputStreamReader reader=
                        new InputStreamReader(url.openConnection().getInputStream());
                //tao bo dem
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line="";
                while ((line = bufferedReader.readLine())!=null)
                {
                    content.append(line);//them du lieu vao content
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }
    }




}