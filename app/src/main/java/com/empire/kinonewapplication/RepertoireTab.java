package com.empire.kinonewapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.empire.kinonewapplication.Controller.AppController;
import com.empire.kinonewapplication.adapters.KinoAdapter;
import com.empire.kinonewapplication.model.Post;
import com.empire.kinonewapplication.model.Wrap;
import com.google.gson.Gson;

/**
 * Created by Ivanco on 04.05.2015.
 */
public class RepertoireTab extends ListFragment {
    private static final String TAG = RepertoireTab.class.getSimpleName();
    private static final String URL = "http://example.com/?json=get_category_posts&slug=Repertoire&status=publish";

    ListView listView;
    KinoAdapter adapter;

    private Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repertoire_layout, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) mActivity.findViewById(android.R.id.list);
        listView = getListView();
        adapter = new KinoAdapter(mActivity, R.layout.list_item_view);
        listView.setAdapter(adapter);


        StringRequest movieReq = new StringRequest(URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response.toString());
                        Wrap wrap = new Gson().fromJson(response, Wrap.class);
                        for (Post post : wrap.getPosts()) {
                            adapter.add(post);
                        }
                        adapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(movieReq);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }
}
