package com.hd.util;

import java.text.SimpleDateFormat;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	public static String toJson(Object bean) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

		try {
			String json = mapper.writeValueAsString(bean);
			return json;
		} catch (Exception arg3) {
			arg3.printStackTrace();
			return null;
		}
	}

	public static Object deSerialise(String json, Class clazz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Object ret = mapper.readValue(json, clazz);
		return ret;
	}
}