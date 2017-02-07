package com.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Twitter {
	//
	public int order = 0;
	//List<Integer> folowee;
	HashMap<Integer, List<Integer>> folowee;
	//
	HashMap<Integer, HashMap<Integer, Integer>> tweets;

    /** Initialize your data structure here. */
    public Twitter() {
    	//
    	tweets = new HashMap<>();
    	folowee = new HashMap<>();
    	//
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	//
    	HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
    	if (tweets.containsKey(userId))
    	{
    		temp = tweets.get(userId);
    	
    	}
    	
    	temp.put(order, tweetId);
		//
		tweets.put(userId, temp);
    	//
		//
		follow(userId, userId);
		order++;	
    	//
    }
        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    		List <Integer> rTwitts = new ArrayList<>();
    		//
    		Map<Integer,Integer> desortedMap = new TreeMap<Integer, Integer>(
    				new Comparator<Integer>() {

						@Override
						public int compare(Integer o1, Integer o2) {
							// TODO Auto-generated method stub
							return o2.compareTo(o1);
						}
					});
    		//
    		List<Integer> foloweeLocal = folowee.get(userId);
    		//
    		if (foloweeLocal==null)
    		{
    			return rTwitts;
    		}
    		for (Map.Entry<Integer, HashMap<Integer, Integer>> entry: tweets.entrySet())
        		{
        			if (foloweeLocal.contains(entry.getKey()))
        			{
        				desortedMap.putAll(tweets.get(entry.getKey()));
        			}
        		}
        		//
    		for (Map.Entry<Integer, Integer> entry : desortedMap.entrySet())
    		{
    			rTwitts.add(entry.getValue());
    		}
        		//
    		rTwitts.remove(rTwitts.size()-1);
        		return rTwitts;
    		}
         /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	//
    	if (folowee.containsKey(followerId))
    	{
    		List<Integer> list = folowee.get(followerId);
    		if (!list.contains(followeeId))
    		{
    			list.add(followeeId);
    			folowee.put(followerId, list);
    		}
  	
    	}
    	else
    	{
    		List<Integer> addList = new ArrayList<>();
    		addList.add(followeeId);
    		folowee.put(followerId, addList);
    	}
    }
        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	//
    	List<Integer> list = folowee.get(followerId);
    	if(followerId==followeeId) return;
    	if (list!=null)
    	{
		if (list.contains(followeeId))
				list.remove((Integer)followeeId);
		//
		folowee.put(followerId, list);
    	}
        
    }
}