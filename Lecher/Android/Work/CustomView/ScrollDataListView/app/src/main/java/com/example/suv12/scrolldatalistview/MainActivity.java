package com.example.suv12.scrolldatalistview;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 6.
    private ListView listView     = null;
    private List<ModelItem> lists = null;
    private AdapterItem adapter   = null;

    private int[] images = { R.drawable.sample_0
                           , R.drawable.sample_1
                           , R.drawable.sample_2
                           , R.drawable.sample_3
                           , R.drawable.sample_4
                           , R.drawable.sample_5
                           , R.drawable.sample_6
                           , R.drawable.sample_7 };

    // 12-1
    private boolean modeGetData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 7.
        lists = makeData( 0,20 );

        // 8.
        adapter = new AdapterItem( MainActivity.this, R.layout.layout_item, lists );

        // 9.
        listView = findViewById( R.id.listView );
        listView.setAdapter( adapter );

        // 10.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // AlertDialog 로 출력하기
                ModelItem item = lists.get( position );
                AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this );
                builder.setMessage( item.toString() );
                builder.setIcon( R.mipmap.ic_launcher );
                builder.setPositiveButton( "확인", null );
                builder.show();
            }
        });

        // 11. scroll 리스너 설정
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                // 11-1. 바닥이다 스크롤 내렸을때 끝도달
                if( totalItemCount == firstVisibleItem + visibleItemCount ){
                    // 12. 데이터 추가
                    if( modeGetData == false ){
                        modeGetData = true;

                        // 1번 2번 까지만 이곳에 작성하고 나서 실행해 본 후 13번 부터 추가 작성했음
                        // HTTPGetData() 메서드로 옮겨서 프로그래스 다이얼로그로 작업함
                        // 1. 네트워크를 통해 데이터 요청
                        // List<ModelItem> items = null;
                        // items = makeData(lists.size(), 20);

                        // 2. 통신 완료 후 받은 데이터 작업
                        // lists.addAll(items);
                        // adapter.notifyDataSetChanged();
                        // modeGetData = false;

                        // 13. HTTPGetData() 만들기
                                                        // 13-5
                        new HTTPGetData().execute( lists.size(), 20 );
                    }
                }
            }
        });
    }

    // 7-1
    private List<ModelItem> makeData( int start, int count) {
        List<ModelItem> newItems = new ArrayList<>();

        Random r = new Random();
        for ( int i = start; i < start + count; i++ ){
            ModelItem item = new ModelItem();
                                                          // 7-2.
            item.setIconItem  ( getResources().getDrawable( images[ i % images.length ],null ) );
            item.setDataItem01( "name " + i );
            item.setDataItem02( 20 + r.nextInt( 3000 ) + "" );
            item.setDataItem03( getRandString() );
            newItems.add(item);
        }
        return newItems;
    }

    // 7-3 무작위 문자열 만들기
    private String getRandString() {
        String str = "";

        for ( int i = 0; i <= (int) ( Math.random() * 10000 ); i++ ){

            // 대문자 A ~ Z 사이의 문자 중 임의의 한 문자를 얻도록
            // (char)(Math.random() * 26 + 65);

            // 소문자 a ~ z 사이의 문자 중 임의의 한 문자를 얻도록
            // (char)(Math.random() * 26 + 97);
            str += String.valueOf( (char) ( Math.random() * 26 + 65 ) );

        }
            return str;
    }

    // 13-1
    private class HTTPGetData extends AsyncTask< Integer, Integer, List<ModelItem > > {

        private ProgressDialog pdlg = null;

        // 13-2
        // 요청 전.
        // 네트워크로 데이터 요청하기 직전에 실행되는 메서드
        // 사용자에게 요청을 알림 표시 (프로그래스 다이얼로그 표시...)
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pdlg = new ProgressDialog( MainActivity.this );
            pdlg.setMessage( "데이터를 가져오는 중..." );
            pdlg.show();
        }

        // 13-3
        // 요청 중.
        @Override
        protected List<ModelItem> doInBackground(Integer... integers) {
            List<ModelItem> items = null;

            try {
                // 2초간 기다리기... sleep 주기
                Thread.sleep( 2000 );

                // 1. 네트워크를 통해 데이터 요청
                items = makeData( integers[0],integers[1] );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return items;
        }

        // 13-4
        // 요청 후.
        // 네트워크로 데이터 요청이 완료되었을 때 실행되는 메서드
        // 사용자 요청 알림을 제거 (프로그래스 다이얼로그 제거...)
        @Override
        protected void onPostExecute(List<ModelItem> modelItems) {
            super.onPostExecute(modelItems);

            // 프로그래스 다이얼로그 제거...
            if( pdlg != null ){
                pdlg.dismiss(); // dismiss() : 프로그래스 돌아가는거 없어지게 하는 용도
                pdlg = null;
            }

            // 2. 통신 완료 후 받은 데이터 작업
            lists.addAll( modelItems );
            adapter.notifyDataSetChanged();
            modeGetData = false;
        }
    }
}
