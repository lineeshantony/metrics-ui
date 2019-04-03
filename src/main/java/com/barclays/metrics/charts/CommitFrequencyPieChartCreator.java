package com.barclays.metrics.charts;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommitFrequencyPieChartCreator {

	public JSONObject getPieData(String projectName) throws JSONException {
		boolean apiCall = false;
		if (!apiCall) {
			return getDataFromStaticinfo(projectName);
		}
		return null;
	}

	private JSONObject getDataFromStaticinfo(String projectName) throws JSONException {
		if ("Cards".equals(projectName)) {
			return getCardsCommitFrequencyData();
		} else if ("Fraud".equals(projectName)) {
			return getFraudCommitFrequencyData();
		} else if ("Cards USA".equals(projectName)) {
			return getCardsUSAPieData();
		} else if ("Cards UK".equals(projectName)) {
			return getCardsUKPieData();
		} else if ("Cards Germany".equals(projectName)) {
			return getCardsGermanyPieData();
		} else if ("Fraud USA".equals(projectName)) {
			return getFraudUSAPieData();
		} else if ("Fraud UK".equals(projectName)) {
			return getFraudUKPieData();
		} else if ("Fraud Germany".equals(projectName)) {
			return getFraudGermanyPieData();
		} else if ("CardNG".equals(projectName)) {
			return getCardNGPieData();
		} else if ("BAPI".equals(projectName)) {
			return getBapiPieData();
		} else if ("All".equals(projectName)) {
			return getAllCommitFrequencyData();
		}
		return new JSONObject();
	}

	private JSONObject getAllCommitFrequencyData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("Cards", 11071));
		data.add(new PieceOfPie("Fraud", 10562));
		return getSeriesJson(data);
	}

	private JSONObject getCardsCommitFrequencyData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("Cards USA", 9111));
		data.add(new PieceOfPie("Cards UK", 956));
		data.add(new PieceOfPie("Cards Germany", 1145));
		return getSeriesJson(data);
	}

	private JSONObject getFraudCommitFrequencyData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("Fraud USA", 2411));
		data.add(new PieceOfPie("Fraud UK", 6956));
		data.add(new PieceOfPie("Fraud Germany", 1045));
		return getSeriesJson(data);
	}

	private JSONObject getCardsUSAPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("CardNG", 6489));
		data.add(new PieceOfPie("BAPI", 1003));
		data.add(new PieceOfPie("CL", 723));
		data.add(new PieceOfPie("BNP", 1211));
		return getSeriesJson(data);
	}

	private JSONObject getCardsUKPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("GLP", 489));
		data.add(new PieceOfPie("DIB", 60));
		data.add(new PieceOfPie("PKL", 223));
		data.add(new PieceOfPie("NIS", 111));
		return getSeriesJson(data);
	}

	private JSONObject getCardsGermanyPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("MNB", 189));
		data.add(new PieceOfPie("Jarvis", 103));
		data.add(new PieceOfPie("Eagle Eye", 588));
		data.add(new PieceOfPie("Cody", 311));
		return getSeriesJson(data);
	}

	private JSONObject getFraudUSAPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("IGI", 89));
		data.add(new PieceOfPie("Cobalt", 1203));
		data.add(new PieceOfPie("Platform", 228));
		data.add(new PieceOfPie("NGBeta", 1111));
		return getSeriesJson(data);
	}

	private JSONObject getFraudUKPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("Googler", 1709));
		data.add(new PieceOfPie("SQLInjectionDetector", 1603));
		data.add(new PieceOfPie("Social Safegaurds", 522));
		data.add(new PieceOfPie("Hack Intimation", 1111));
		return getSeriesJson(data);
	}

	private JSONObject getFraudGermanyPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("BookReader", 708));
		data.add(new PieceOfPie("NewProject", 60));
		data.add(new PieceOfPie("Test Data", 523));
		data.add(new PieceOfPie("Loans Validator", 111));
		return getSeriesJson(data);
	}

	private JSONObject getCardNGPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("Reference Apps", 1089));
		data.add(new PieceOfPie("API Gateway", 1003));
		data.add(new PieceOfPie("Consul", 1522));
		data.add(new PieceOfPie("Vault Controller", 1011));
		return getSeriesJson(data);
	}

	private JSONObject getBapiPieData() throws JSONException {
		List<PieceOfPie> data = new ArrayList<>();
		data.add(new PieceOfPie("Card Control", 108));
		data.add(new PieceOfPie("Coherance Cache", 160));
		data.add(new PieceOfPie("Tsys Proxy", 522));
		data.add(new PieceOfPie("ActiveMQ Upgrade", 111));
		return getSeriesJson(data);
	}

	private JSONObject getSeriesJson(List<PieceOfPie> data) throws JSONException {
		JSONObject seriesJson = new JSONObject();
		JSONArray dataArray = new JSONArray();
		for (PieceOfPie pieceOfPie : data) {
			JSONObject dataJson = new JSONObject();
			dataJson.put("name", pieceOfPie.getName());
			dataJson.put("y", pieceOfPie.getValue());
			dataArray.put(dataJson);
		}

		seriesJson.put("data", dataArray);
		return seriesJson;
	}

}
