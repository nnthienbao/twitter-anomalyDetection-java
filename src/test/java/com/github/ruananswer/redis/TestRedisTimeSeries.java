/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ruananswer.redis;

import com.github.ruananswer.testUtility.TestCommon;
import com.redislabs.redistimeseries.RedisTimeSeries;
import java.io.IOException;
import org.testng.annotations.Test;

/**
 *
 * @author baonnt
 */
public class TestRedisTimeSeries {

//	@Test
	public void addSeries() throws IOException {
		String filePath = "src/test/resources/redis_ts_data/send_success_30day.txt";
		String data = TestCommon.getResourceAsString(filePath);
		String[] lines = data.split("\n");
		long[] timestamps = new long[lines.length - 1];
		double[] values = new double[lines.length - 1];
		RedisTimeSeries rts = new RedisTimeSeries("localhost", 6379);
		
		for (int i = 1; i < lines.length; i++) {
			String[] splits = lines[i].split(",");
			timestamps[i - 1] = Long.parseLong(splits[0]);
			values[i - 1] = Double.parseDouble(splits[1]);
		}
		
		String key = "send_success_30day";
		for (int j = 1; j < 3000; j++) {
			String newKey = key + "_" + j;
			addSingleSeries(newKey, timestamps, values, rts);
		}
	}

	public void addSingleSeries(String key, long[] timestamps, double[] values, RedisTimeSeries rts) {
		for (int i = 0; i < timestamps.length; i++) {
			rts.add(key, timestamps[i], values[i]);
		}
	}
}
