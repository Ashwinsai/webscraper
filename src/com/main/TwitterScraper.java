package com.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TwitterScraper {


	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://twitter.com/search?q=supreet&src=typd").timeout(6000).get();
		
		
		Elements el = doc.select("div#timeline");
		
			for(Element els:el.select("ol#stream-items-id"))
			{
				Elements item = els.select("li.js-stream-item");
				
				for(Element tweets:item)
				{
					Elements tweet_container = els.select("div.js-tweet-text-container");
					
					for(Element tweet:tweet_container.select("p.js-tweet-text"))
					{
						System.out.println(tweet.html()	);
						System.out.println("chiscnn");
					}
					   
				}
			}
				
			System.out.println();
		
		
	}
	

}
