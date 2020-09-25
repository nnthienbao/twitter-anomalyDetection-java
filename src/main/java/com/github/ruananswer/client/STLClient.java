/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ruananswer.client;

import com.github.ruananswer.anomaly.DetectAnoms;

/**
 *
 * @author nhantt4
 */
public class STLClient {

	public DetectAnoms.JNOMSResult detectAnom(int numObsPerPeriod, long[] timestamps, double[] series, int window, int mul, boolean hibrid) {
		DetectAnoms.Config config = new DetectAnoms.Config();
		config.setNumObsPerPeriod(numObsPerPeriod);
		DetectAnoms detectAnoms = new DetectAnoms(config);
		return detectAnoms.jAnomalyDetection(timestamps, series, window, mul, hibrid);
	}
}
