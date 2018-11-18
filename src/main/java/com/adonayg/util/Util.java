package com.adonayg.util;

import javax.enterprise.inject.Model;

import com.google.gson.Gson;


public class Util {

	private Gson gson;

	public Util() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}

}