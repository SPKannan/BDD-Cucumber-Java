package runtimeData;

import java.util.HashMap;

public class ScenarioContext {
	
	 public enum runtime_testdata_key{
		 PRODUCT_NAME,
		 PRODUCT_PRICE,
		 PRODUCT_QTY,
		 PRODUCT_COLOR,
		 DRESS_CATEGORY_NAME
	}
	
	public static HashMap<String, Object> data;// = new HashMap<String, String>();

	public ScenarioContext() {
		data = new HashMap<String, Object>();
	}

	  public void setContext(runtime_testdata_key runtime_testdata_key, Object value) {
		  data.put(runtime_testdata_key.toString(), value);
	    }

	    public Object getContext(runtime_testdata_key runtime_testdata_key){
	        return data.get(runtime_testdata_key.toString());
	    }

	    public Boolean isContains(runtime_testdata_key runtime_testdata_key){
	        return data.containsKey(runtime_testdata_key.toString());
	    }

}
