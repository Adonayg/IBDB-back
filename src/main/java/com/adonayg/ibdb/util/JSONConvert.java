package com.adonayg.ibdb.util;
import com.google.gson.Gson;

public class JSONConvert {

	private Gson gson;

	public JSONConvert() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}

}
