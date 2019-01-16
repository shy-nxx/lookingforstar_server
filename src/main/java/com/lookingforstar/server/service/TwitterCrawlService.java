package com.lookingforstar.server.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lookingforstar.server.model.TwitterItem;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;



@Service
public class TwitterCrawlService {

	
	public List<TwitterItem> TwitterCrawling(String choice, String language) throws IOException {
		String url = "";
		
		if (choice.equals("redvelvet")) {
			url = "https://twitter.com/RVsmtown?lang=ko";
		} else if (choice.equals("exo")) {
			url = "https://twitter.com/weareoneEXO?lang=ko";
		} else if (choice.equals("bts")) {
			url = "https://twitter.com/BTS_twt?lang=ko";
		} else {
			url = "https://twitter.com/jypetwice?lang=ko";
		}
		
		List<TwitterItem> TwitList = new ArrayList<TwitterItem>();
		TwitterItem item;
		
		try{
			Connection con = Jsoup.connect(url);
			Document doc = con.get();
			
			Elements c = doc.select("div.content");
			if(c != null){
				for(Element el : c){
					Elements t = el.select("p.TweetTextSize.js-tweet-text.tweet-text");
					if(t.size() > 0) {

						String r_content = "";
						String content = t.first().text();
						String date = el.select("div.stream-item-header")
								.select("small.time")
								.select("a")
								.attr("title");
						String image = el.select("div.AdaptiveMedia-container")
								.select("img[src~=(?i)\\.(png|jpe?g|gif)]")
								.attr("src");

						if (content.contains("pic")) {
							if (!image.equals("")) {
								r_content = content.substring(0, content.indexOf("pic"));
								item = new TwitterItem(r_content, image);
								TwitList.add(item);
							}
						}
					}
				}
			}
		} catch(Exception ex){
			System.out.println("Connection error...");
		}		
		
		return TwitList;
	}
		
	
}


