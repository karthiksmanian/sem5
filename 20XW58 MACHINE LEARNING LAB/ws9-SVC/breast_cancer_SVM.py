#!/usr/bin/env python
# coding: utf-8

# In[91]:


import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

get_ipython().run_line_magic('matplotlib', 'inline')


from sklearn.datasets import load_breast_cancer
from sklearn.preprocessing import StandardScaler
cancer=load_breast_cancer()


# In[ ]:





# In[92]:



df_cancer=pd.DataFrame(np.c_[cancer['data'],cancer['target']],columns=np.append(cancer['feature_names'],['target']))
df_cancer.head()


# In[93]:


### plotting:

sns.pairplot(df_cancer,hue='target',vars=['mean radius','mean texture','mean perimeter','mean area','mean smoothness'])


# In[94]:


### orange benign and blue malignant


# In[95]:


plt.figure(figsize=(20,15))
sns.heatmap(df_cancer.corr(),annot=True)


# In[96]:


### Modelling:

X=df_cancer.drop(['target'],axis=1)
X.head()


# In[97]:


y=df_cancer['target']
y.head()


# In[98]:


from sklearn.model_selection import train_test_split


# In[99]:


X_train,X_test,y_train,y_test=train_test_split(X,y,test_size=0.2,random_state=20)


# In[100]:


X_train.shape


# In[101]:


X_train.head(5)


# In[102]:


#### support vector classification:

from sklearn.svm import SVC
svc_model=SVC()


# In[103]:


######

svc_model.fit(X_train,y_train)


# In[104]:


#### prediction

y_predict=svc_model.predict(X_test)


# In[105]:


y_predict


# In[106]:


#### accuracy:

## create confusion matrix


# In[107]:


from sklearn.metrics import classification_report,confusion_matrix

conf_mat=np.array(confusion_matrix(y_test,y_predict,labels=[1,0]))
confusion=pd.DataFrame(conf_mat,index=['is_cancer','is_healthy'],columns=['predicted_cancer','predicted_healthy'])
confusion


# In[ ]:





# In[108]:


### visualize our confusion matrix

sns.heatmap(confusion,annot=True)


# In[109]:


#### classification report

print(classification_report(y_test,y_predict))


# In[ ]:





# In[110]:


c1=confusion['predicted_cancer']
c2=confusion['predicted_healthy']


# In[ ]:





# In[111]:


c1


# In[ ]:





# In[112]:


c2


# In[113]:


TP=confusion.iloc[0,0]
FN=confusion.iloc[0,1]
FP=confusion.iloc[1,0]
TN=confusion.iloc[1,1]


# In[114]:


print(TP,FN,FP,TN)


# In[115]:


acc=(TP+FP)/(TP+FP+FN+FP)
precision_malignant=(TP)/(TP+FP)
precision_benign=(TN)/(TN+FN)
recall_malignant=(TP)/(TP+FN)
recall_benign=(FP)/(FP+TN)


# In[116]:


print("accuracy:",acc)

print("precision_malignant:",precision_malignant)
print("precision_benign:",precision_benign)
print("recall_malignant:",recall_malignant)
print("recall_malignant:",recall_benign)


# In[ ]:





# In[117]:


#### normalize data


# In[118]:


X_test_min=X_test.min()
X_test_range=(X_test-X_test_min).max()
X_test_scaled=(X_test-X_test_min)/(X_test_range)


# In[120]:


X_test_scaled


# In[121]:


X_train


# In[122]:


from sklearn.preprocessing import MinMaxScaler


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




