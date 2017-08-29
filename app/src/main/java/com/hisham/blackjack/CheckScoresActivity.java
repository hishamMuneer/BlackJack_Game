package com.hisham.blackjack;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckScoresActivity extends Activity {

    ArrayList<ScoreModel> items = new ArrayList<ScoreModel>();
    ListView lvScores;
    ScoreListAdapter adapter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_scores);
        lvScores = (ListView) findViewById(R.id.listScores);

        adapter = new ScoreListAdapter(getApplicationContext(), R.layout.row, items);
        lvScores.setAdapter(adapter);

        if (Globals.isOnline(this) == false) {
            Toast.makeText(CheckScoresActivity.this, "No Internet connection, Please try again later.", Toast.LENGTH_LONG).show();
            return;
        }


        // if bundle is present upload the score else just fetch the score

//		Bundle bundle = getIntent().getExtras();
//		if (bundle != null) {
        //	send score
//			new ScoresTask(getApplicationContext()).execute("insert", bundle.getString("extra_name"),bundle.getString("extra_score"));
//		}
        // load data
//		new ScoresTask(getApplicationContext()).execute("get");


        dialog = new ProgressDialog(CheckScoresActivity.this);
        dialog.setMessage("Getting the best scores. Please wait...");
        dialog.setCancelable(false);
        dialog.show();

        // todo parse stuff

//        ParseQuery<ParseObject> query = ParseQuery.getQuery("HighScores");
////		query.whereEqualTo("playerEmail", "dstemkoski@example.com");
//        query.addDescendingOrder("Score");
////        query.setLimit(50);
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> list, com.parse.ParseException e) {
//                dialog.setCancelable(true);
//                dialog.dismiss();
//                if (e == null) {
//                    // clearing items
//                    items.clear();
//                    // parsing parse list
//                    for (ParseObject object : list) {
//                        // as user can press share my score any number of times, we will get duplicate entries, so skipping
//                        // the item if name and score are duplicated.
//                        boolean duplicateEntry = false;
//                        long startTime = System.currentTimeMillis();
//                        for(int i=0; i<items.size(); i++){
//                            if(items.get(i).getName().equals(object.getString("Name")) && items.get(i).getScore() == object.getInt("Score")){
//                                duplicateEntry = true;
//                                break;
//                            }
//                        }
//                        long endTime = System.currentTimeMillis();
//                        Log.e("time","total time taken: " + (endTime - startTime));
//                        // only add if its a unique entry - PROBLEM is parse query don't give you unique values.
//                        if(!duplicateEntry)
//                            items.add(new ScoreModel(object.getString("Name"), object.getInt("Score"), object.getCreatedAt()));
//                    }
//                    adapter.notifyDataSetChanged();
//                    Log.d("score", "The getFirst request failed.");
//                } else {
//                    Log.d("score", "Retrieved the object.");
//                }
//            }
//        });


        // fetch the score and show

        // no Internet connection quit


    }

    // Async task that calls web methods on server
//		class ScoresTask extends AsyncTask<String, Integer, String> {
//			private Context context;
//			ProgressDialog dialog;
//
//			public ScoresTask(Context cxt) {
//				context = cxt;
//				dialog = new ProgressDialog(CheckScoresActivity.this);
//			}
//
//			@Override
//			protected void onPreExecute() {
//					dialog.setMessage("Loading scores, Please wait");
//					dialog.show();
//
//			}
//
//			@Override
//			protected String doInBackground(String... urls) {
//				String results;
//				try {
//					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//
//
//					// checking which method is passed
//					if(urls[0].equals("insert")){
//						nameValuePairs.add(new BasicNameValuePair("name", urls[1]));
//						nameValuePairs.add(new BasicNameValuePair("score", urls[2]));
//					}else if(urls[0].equals("get")){
//					}else {
//						// invalid method is supplied
//						return "Your passed an invalid method.";
//					}
//
//
//
//					nameValuePairs.add(new BasicNameValuePair("method",urls[0]));
//
//					// TODO goes here
//					URI u = new URI("http://microblogging.wingnity.com/BlackJack/scoresbj.php");
//					HttpClient httpclient = new DefaultHttpClient();
//					HttpPost httppost = new HttpPost(u);
//					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//					HttpResponse response = httpclient.execute(httppost);
//
//					// StatusLine stat = response.getStatusLine();
//					int status = response.getStatusLine().getStatusCode();
//
//					if (status == 200) {
//						HttpEntity entity = response.getEntity();
//						String data = EntityUtils.toString(entity);
//
//						System.out.println("result is  " + data);
//						Log.e("hisham", data);
//
//						JSONObject jsono = new JSONObject(data);
//
//						// If response from server for get method
//						if (jsono.getInt("status") == 1 && urls[0].equals("get")) {
//
//							JSONArray jarray = jsono.getJSONArray("data");
//
//							for (int i = 0; i < jarray.length(); i++) {
//
//								JSONObject realobject = jarray.getJSONObject(i);
//
//								ScoreModel model = new ScoreModel();
//
//								model.setName(realobject.getString("name"));
//								model.setScore(realobject.getInt("score"));
//								model.setDate(realobject.getString("created"));
//
//								items.add(model);
//							}
//
//							return "success";
//						}
//					}
//				} catch (JSONException e1) {
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				} catch (URISyntaxException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				return "";
//			}
//
//			protected void onPostExecute(String r) {
//				if(r.equals("success")){
//					adapter.notifyDataSetChanged();
//					dialog.dismiss();
//				} else {
//					dialog.dismiss();
//				}
//			}
//		}

    // Custom Adapter
    public class ScoreListAdapter extends ArrayAdapter<ScoreModel> {

        private ArrayList<ScoreModel> tempItems;

        public ScoreListAdapter(Context context, int resource,
                                ArrayList<ScoreModel> items) {
            super(context, resource, items);
            tempItems = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            Log.i("adapter", "getting a view");
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);
            }

            ScoreModel score = tempItems.get(position);
            if (score != null) {

                ImageView imageRankIcon = (ImageView)v.findViewById(R.id.imageViewRank);
                TextView tvName = (TextView) v.findViewById(R.id.tvScoreName);
                TextView tvScoreRank = (TextView) v.findViewById(R.id.tvScoreRank);
                TextView tvScoreScore = (TextView) v.findViewById(R.id.tvScoreScore);
                TextView tvDate = (TextView) v.findViewById(R.id.tvScoreDate);

                if (tvName != null) {
                    tvName.setText(score.getName());
                }
                if (tvScoreRank != null) {
                    int rank = position + 1;
                    tvScoreRank.setText("Rank: " + rank);
                    switch (rank){
                        case 1:
                            imageRankIcon.setImageResource(R.drawable.rank1);
                            tvName.setTextSize(28);
                            imageRankIcon.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            imageRankIcon.setImageResource(R.drawable.rank2);
                            tvName.setTextSize(24);
                            imageRankIcon.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            imageRankIcon.setImageResource(R.drawable.rank3);
                            tvName.setTextSize(22);
                            imageRankIcon.setVisibility(View.VISIBLE);
                            break;
                        default:
                            tvName.setTextSize(20);
                            imageRankIcon.setVisibility(View.GONE);
                            break;

                    }
                }
                if (tvScoreScore != null) {
                    tvScoreScore.setText(score.getScore() + "");
                }
                if (tvDate != null) {
                    DateConversion cdts = new DateConversion();
                    tvDate.setText(cdts.getDate(score.getDate()));
                }
            }

            return v;

        }
    }

}
