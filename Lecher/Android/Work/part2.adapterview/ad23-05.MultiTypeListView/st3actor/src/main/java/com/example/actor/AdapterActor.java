package com.example.actor;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.actor.model.ModelActor;
import com.example.actor.view.ViewActor;
import com.example.actor.view.ViewMovie;

import java.util.List;

public class AdapterActor extends ArrayAdapter {

    // ViewType 선언.
    public static final int VIEW_TYPE_ACTOR = 0;
    public static final int VIEW_TYPE_TITLE = 1;
    public static final int VIEW_TYPE_MOVIE = 2;
    public static final int VIEW_TYPE_DRAMA = 3;
    public static final int VIEW_TYPE_COMMENT = 4;

    // Adapter 데이터 설정
    private ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;

        // 앱 실행중 데이터 변경시 화면 새로고침.
        notifyDataSetChanged();
    }

    private final Context context;

    public AdapterActor(@NonNull Context context) {
        super(context, -1);

        this.context = context;
    }

    @Override
    public int getCount() {
        // title 이 추가되면서 갯수 변경되는 문제가 발생.
        // 따라서, title 갯수를 빼주어야 된다.
        int count = 0;

        // actor 갯수 계산
        if (actor == null)
            return 0;
        else
            count = count + 1;

        // movie 갯수 계산
        if (actor.getMovies().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getMovies().size());
        }

        // drama 갯수 계산
        if (actor.getDramas().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getDramas().size());
        }

        // comment 갯수 계산
        if (actor.getComments().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getComments().size());
        }

        return count;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }


    @Override
    public int getItemViewType(int position) {
        int VIEW_TYPE = -1;

        if (position == 0)
            return VIEW_TYPE_ACTOR;

        position = position - 1; // actor 때문에 -1

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // movie의 title  때문에 -1

            if (position < actor.getMovies().size()) {
                return VIEW_TYPE_MOVIE;
            }

            position = position - actor.getMovies().size();
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // drama의 title  때문에 -1

            if (position < actor.getDramas().size()) {
                return VIEW_TYPE_DRAMA;
            }

            position = position - actor.getDramas().size();
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // comment의 title  때문에 -1

            if (position < actor.getComments().size()) {
                return VIEW_TYPE_COMMENT;
            }

            position = position - actor.getComments().size();
        }

        return VIEW_TYPE;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        if (position == 0) {
            return actor;
        }
        position = position - 1;  // position == 0

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return "Movie ...";  // movie의 타이틀값을 리턴.
            }
            position = position - 1; // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0

            if (position < actor.getMovies().size()) {
                return actor.getMovies().get(position);
            }
            position = position - actor.getMovies().size();  // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return "Drama ...";  // drama의 타이틀값을 리턴.
            }
            position = position - 1; // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0

            if (position < actor.getDramas().size()) {
                return actor.getDramas().get(position);
            }
            position = position - actor.getDramas().size();  // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return "Comment ...";  // comment의 타이틀값을 리턴.
            }
            position = position - 1; // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0

            if (position < actor.getComments().size()) {
                return actor.getComments().get(position);
            }
            position = position - actor.getComments().size();  // position 값을 0으로 기준으로 계산할수 있도록 재조정. position == 0
        }

        return null;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (position == 0) {
            ViewActor view;
            if (convertView != null && convertView instanceof ViewActor) {
                view = (ViewActor) convertView;
            } else {
                // inflation
                view = new ViewActor(parent.getContext());
            }

            // 데이터 입력 & 화면 새로고침
            view.setActor(actor);
            return view;
        }

        //position 의 0점 조정.
        position = position - 1; // -1 : actor

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                TextView view = null;
                if (convertView != null && convertView instanceof TextView) {
                    view = (ViewMovie) convertView;
                }
                else {
                    view = (TextView) inflater.infalte( android.R.layout.simple_list_item_1,parent,false);
            }
            // 데이터 설정 및 새로고침
                view.setText("Movies...");
                return  view;

            }

            //position 의 0점 조정.
            position = position -1; //-1:movie의 title로우를 제거하기 위한 것.
            if (position < actor.getMovies().size()final ){
                ViewMovie view = null;
                if(convertView !)
            }
        }
    }
}

