package com.net.controller;
public class person{
	String keyword;
	String wxinfo;
	public person(){}
	public person(String s1,String s2)
	{
		keyword=s1;
		wxinfo=s2;
	}
	public String getKeyword(){
		return this.keyword;
	}
	public void setKeyword(String keyword){
		this.keyword=keyword;
	}
	public String getWxinfo(){
		return this.wxinfo;
	}
	public void setWxinfo(String wxinfo){
		this.wxinfo=wxinfo;
	}
}
