package com.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BloombergScraper {

	
	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect("https://www.bloomberg.com/quote/SPX:IND").timeout(6000).get();
		
		System.out.println(doc.select("div.ticker"));
		Elements element = doc.select("div.price-container");
		for(Element e:element.select("div.price"))
		{
			System.out.println(e.childNode(0));
		}
		
		for(Element ell: doc.select("div.data-table"))
		{
			System.out.println(ell.select("div.cell__label"));
			System.out.println(ell.select("div.cell__value"));
		}
	}
}
