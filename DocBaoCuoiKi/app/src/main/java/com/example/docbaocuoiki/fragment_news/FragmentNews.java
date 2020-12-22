package com.example.docbaocuoiki.fragment_news;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.docbaocuoiki.DetailReadNew;
import com.example.docbaocuoiki.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FragmentNews extends Fragment {
    ListView listView;
    AdapterReadNew adapterReadNew;
    ArrayList<ReadNew> arrayList;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        listView =root.findViewById(R.id.listView);
        arrayList = new ArrayList<ReadNew>();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadData().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
            }
        });
        adapterReadNew = new AdapterReadNew(FragmentNews.this.getActivity(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapterReadNew);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FragmentNews.this.getActivity(), DetailReadNew.class);
                intent.putExtra("link",arrayList.get(position).link);
                startActivity(intent);
            }
        });

        return root;
    }


    class ReadData extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeListDescription = document.getElementsByTagName("description");
            String image = "";
            String title = "";
            String link = "";
            for (int i = 0; i<nodeList.getLength(); i++ ){
                String cData = nodeListDescription.item(i + 1).getTextContent();
                Pattern pattern = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = pattern.matcher(cData);
                if (matcher.find()){
                    image = matcher.group(1);
//                    Log.d("image", image +"......."+ i);
                }
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element,"title");
                link = parser.getValue(element,"link");
                arrayList.add(new ReadNew(title,link,image));

//                Log.d("link",link);
//                Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();
            }
            adapterReadNew = new AdapterReadNew(FragmentNews.this.getActivity(),android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(adapterReadNew);
            super.onPostExecute(s);
//            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
        }
    }
    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}

