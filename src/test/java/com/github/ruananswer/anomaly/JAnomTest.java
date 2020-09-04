/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ruananswer.anomaly;

import com.github.ruananswer.testUtility.TestCommon;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.testng.annotations.Test;

/**
 *
 * @author baonnt
 */
public class JAnomTest {

	@Test
	public void test() throws IOException {
		File folder = new File("src/test/resources/data");
		System.out.println("folder=" + Arrays.toString(folder.list()));
		String[] list = folder.list();
		for (String fileName : list) {
//			String filePath = "data/1_Authen_Com_V3_Viettel_Failed";
			String[] lines = TestCommon.getResourceAsString("data/" + fileName).split("\n");
			long[] timestamps = new long[lines.length - 1];
			double[] values = new double[lines.length - 1];
			for (int i = 1; i < lines.length; i++) {
				String[] splits = lines[i].split(",");
				long timestamp = Long.parseLong(splits[0]);
				double value = Double.parseDouble(splits[1]);
				timestamps[i - 1] = timestamp;
				values[i - 1] = value;
			}
			DetectAnoms.Config config = new DetectAnoms.Config();
			config.setNumObsPerPeriod(1440);
			DetectAnoms detectAnoms = new DetectAnoms(config);
			values[values.length - 1] = 0;
			boolean result = detectAnoms.jAnomalyDetection(timestamps, values, 30, 3);

			System.out.println(fileName + ". Result = " + result);
		}

	}
}
