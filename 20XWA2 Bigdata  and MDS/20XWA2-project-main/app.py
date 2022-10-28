from matplotlib import image
import streamlit as st
import pickle
import numpy as np
import pandas as pd
from praw.models import MoreComments
import praw
import matplotlib.pyplot as plt

a=[]
b=[]
c=[]

st.title("REDDIT")
st.write("API fetch . . .")

pickle_in = open("reddit.pkl", "rb")

reddit = pickle.load(pickle_in)

subreddit_title = st.text_input("subreddit : r/")
inp = st.text_input("Enter your preference such as hot, new, controversial, top")
try:
    subreddit = reddit.subreddit(subreddit_title)
    if(inp=="hot"):    
        hot = subreddit.hot(limit=10)
        for i in hot:
            st.write(i.title)
            st.write(i.url)
            st.write(f"Upvote Ratio: {i.upvote_ratio}")
            st.write(f"Score:  {i.score}")
            st.write(f"Number of comments : {i.num_comments}")
            a.append(i.score)
            b.append(i.upvote_ratio)
            c.append(i.num_comments)
        
    elif(inp=="new"):
        new = subreddit.new(limit=10)
        for i in new:
            st.write(i.title)
            st.write(i.url)
            st.write(f"Upvote Ratio: {i.upvote_ratio}")
            st.write(f"Score:  {i.score}")
            st.write(f"Number of comments : {i.num_comments}")
            a.append(i.score)
            b.append(i.upvote_ratio)
            c.append(i.num_comments)
            
    elif(inp=="controversial"):
        cont= subreddit.controversial(limit=10)
        for i in cont:
            st.write(i.title)
            st.write(i.url)
            st.write(f"Upvote Ratio: {i.upvote_ratio}")
            st.write(f"Score:  {i.score}")
            st.write(f"Number of comments : {i.num_comments}")
            a.append(i.score)
            b.append(i.upvote_ratio)
            c.append(i.num_comments)
    else:
        top= subreddit.top(limit=10)
        for i in top:
            st.write(i.title)
            st.write(i.url)
            st.write(f"Upvote Ratio: {i.upvote_ratio}")
            st.write(f"Score:  {i.score}")
            st.write(f"Number of comments : {i.num_comments}")
            a.append(i.score)
            b.append(i.upvote_ratio)
            c.append(i.num_comments)
            
    st.write("Number of Upvotes")       
    df = pd.DataFrame(a)
    st.bar_chart(df)
    st.write("Upvote ratio")
    df1 = pd.DataFrame(b)
    st.bar_chart(df1)
    st.write("Number of Comments ")
    df2 = pd.DataFrame(c)
    st.bar_chart(df2)
    
    
    
  
except ValueError:
    st.write("Enter the subreddit name to fetch content")
    
