package com.hisham.blackjack;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CheckScoresActivity extends Activity {

	ArrayList<ScoreModel> items = new ArrayList<ScoreModel>();
	ListView lvScores;
	ScoreListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_scores);
		lvScores = (ListView)findViewById(R.id.listScores);

		adapter = new ScoreListAdapter(getApplicationContext(), R.layout.row, items);
		lvScores.setAdapter(adapter);
		
		if(isOnline() == false){
			Toast.makeText(CheckScoresActivity.this, "No Internet connection, Please try again later.", Toast.LENGTH_LONG).show();
			return;
		}
		
		
		// if bundle is present upload the score else just fetch the score

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			//	send score
			new ScoresTask(getApplicationContext()).execute("insert", bundle.getString("extra_name"),bundle.getString("extra_score"));
		}
		// load data
		new ScoresTask(getApplicationContext()).execute("get");
		
		// fetch the score and show
		
		// no Internet connection quit
		
		
		
	}

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

					TextView tvName = (TextView) v
							.findViewById(R.id.tvScoreName);
					TextView tvScoreRank = (TextView) v.findViewById(R.id.tvScoreRank);
					TextView tvScoreScore = (TextView) v.findViewById(R.id.tvScoreScore);
					TextView tvDate = (TextView) v.findViewById(R.id.tvScoreDate);

					if (tvName != null) {
						tvName.setText(score.getName());
					}
					if (tvScoreRank != null) {
						tvScoreRank.setText("Rank: " + (position+1));
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
		
		
		// Async task that calls web methods on server
		class ScoresTask extends AsyncTask<String, Integer, String> {
			private Context context;
			ProgressDialog dialog;

			public ScoresTask(Context cxt) {
				context = cxt;
				dialog = new ProgressDialog(CheckScoresActivity.this);
			}

			@Override
			protected void onPreExecute() {
					dialog.setMessage("Loading scores, Please wait");
					dialog.show();
	
			}

			@Override
			protected String doInBackground(String... urls) {
				String results;
				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					
					
					// checking which method is passed
					if(urls[0].equals("insert")){
						nameValuePairs.add(new BasicNameValuePair("name", urls[1]));
						nameValuePairs.add(new BasicNameValuePair("score", urls[2]));
					}else if(urls[0].equals("get")){
					}else {
						// invalid method is supplied
						return "Your passed an invalid method.";
					}
					
					

					nameValuePairs.add(new BasicNameValuePair("method",urls[0]));

					// TODO goes here
					URI u = new URI("http://microblogging.wingnity.com/BlackJack/scoresbj.php");
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httppost = new HttpPost(u);
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httppost);

					// StatusLine stat = response.getStatusLine();
					int status = response.getStatusLine().getStatusCode();

					if (status == 200) {
						HttpEntity entity = response.getEntity();
						String data = EntityUtils.toString(entity);

						System.out.println("result is  " + data);
						Log.e("hisham", data);

						JSONObject jsono = new JSONObject(data);

						// If response from server for get method
						if (jsono.getInt("status") == 1 && urls[0].equals("get")) {

							JSONArray jarray = jsono.getJSONArray("data"); 
							
							for (int i = 0; i < jarray.length(); i++) {
								
								JSONObject realobject = jarray.getJSONObject(i);
								
								ScoreModel model = new ScoreModel();
								
								model.setName(realobject.getString("name"));
								model.setScore(realobject.getInt("score"));
								model.setDate(realobject.getString("created"));
								
								items.add(model);
							}

							return "success";
						}
					}
				} catch (JSONException e1) {
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "";
			}

			protected void onPostExecute(String r) {
				if(r.equals("success")){
					adapter.notifyDataSetChanged();
					dialog.dismiss();
				} else {
					dialog.dismiss();
				}
			}
		}

		
		public boolean isOnline() {
			ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo netInfo = cm.getActiveNetworkInfo();
			if (netInfo != null && netInfo.isConnectedOrConnecting()) {
				return true;
			} else
				return false;
		}

}
