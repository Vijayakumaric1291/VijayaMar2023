package com.qa.amazon.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Amazon Sign In";
	public static final String HOMEPAGE_PAGE_TITLE = "";
	public static final int HOMEPAGE_HEADER_COUNT = 31;
	public static final String SEARCHRESULTSPAGE_ITEMS_COUNT = "576";
	
	public static List<String> expHomePageHeaderList() {
		List<String> ExpHeaderList = new ArrayList<>();
		ExpHeaderList.add("Fresh");
		ExpHeaderList.add("Amazon miniTV");
		ExpHeaderList.add("Gift Cards");
		ExpHeaderList.add("Buy Again");
		ExpHeaderList.add("Baby");
		ExpHeaderList.add("Browsing History");
		
		return ExpHeaderList;
	}
}
