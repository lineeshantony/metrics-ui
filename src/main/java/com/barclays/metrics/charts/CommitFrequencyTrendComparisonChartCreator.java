package com.barclays.metrics.charts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CommitFrequencyTrendComparisonChartCreator {

	public JSONObject getData(String projectName) throws JSONException {
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
		List<PieceOfTrend> data = new ArrayList<>();
		int[] cardsArray = { 9150, 11390, 11480, 11240, 11450, 11390, 11508, 11370, 11200, 11350, 11240, 11120 };
		data.add(new PieceOfTrend("Cards", getIntegerListFrom(cardsArray)));
		int[] fraudArray = { 9105, 10319, 10348, 10524, 10945, 10139, 11108, 10701, 10001, 11310, 10140, 10112 };
		data.add(new PieceOfTrend("Fraud", getIntegerListFrom(fraudArray)));
		return getSeriesJson(data);
	}

	private JSONObject getCardsCommitFrequencyData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] cardsUSAArray = { 503, 3903, 4803, 2403, 4503, 3903, 5038, 3730, 2003, 3503, 2403, 1203 };
		data.add(new PieceOfTrend("Cards USA", getIntegerListFrom(cardsUSAArray)));
		int[] cardsUKArray = { 150, 1390, 1480, 1240, 1450, 1390, 1508, 1370, 1200, 1350, 1240, 1120 };
		data.add(new PieceOfTrend("Cards UK", getIntegerListFrom(cardsUKArray)));
		int[] cardsGermanyArray = { 510, 3190, 4180, 2140, 4150, 3190, 5108, 3170, 1200, 3150, 2140, 1120 };
		data.add(new PieceOfTrend("Cards Germany", getIntegerListFrom(cardsGermanyArray)));
		return getSeriesJson(data);
	}

	private JSONObject getFraudCommitFrequencyData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] fraudUSAArray = { 501, 1390, 1480, 1240, 1450, 1390, 1508, 1370, 1200, 1350, 1240, 1120 };
		data.add(new PieceOfTrend("Fraud USA", getIntegerListFrom(fraudUSAArray)));
		int[] fraudUKArray = { 150, 1090, 1080, 1040, 1050, 1090, 1008, 1070, 1200, 1050, 1240, 920 };
		data.add(new PieceOfTrend("Fraud UK", getIntegerListFrom(fraudUKArray)));
		int[] fraudGermanyArray = { 650, 1190, 1180, 1140, 1150, 1190, 1108, 1170, 1100, 1150, 1140, 820 };
		data.add(new PieceOfTrend("Fraud Germany", getIntegerListFrom(fraudGermanyArray)));
		return getSeriesJson(data);
	}

	private JSONObject getCardsUSAPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] cardNGArray = { 505, 3905, 4805, 2405, 4505, 3905, 5085, 3705, 2005, 3505, 2455, 1205 };
		data.add(new PieceOfTrend("CardNG", getIntegerListFrom(cardNGArray)));
		int[] bapiArray = { 550, 3590, 4580, 2540, 4150, 3190, 5108, 3170, 2100, 3150, 2140, 1120 };
		data.add(new PieceOfTrend("BAPI", getIntegerListFrom(bapiArray)));
		int[] clArray = { 650, 1390, 1480, 1240, 1450, 1390, 1508, 1370, 1200, 1350, 1240, 920 };
		data.add(new PieceOfTrend("CL", getIntegerListFrom(clArray)));
		int[] bnpArray = { 250, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 1120 };
		data.add(new PieceOfTrend("BNP", getIntegerListFrom(bnpArray)));
		return getSeriesJson(data);
	}

	private JSONObject getCardsUKPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] glpArray = { 150, 1190, 1180, 1140, 1150, 1190, 1508, 1370, 1600, 1250, 1940, 1120 };
		data.add(new PieceOfTrend("GLP", getIntegerListFrom(glpArray)));
		int[] dibArray = { 90, 1290, 1480, 1240, 1450, 1390, 1508, 1070, 1200, 1150, 1240, 1220 };
		data.add(new PieceOfTrend("DIB", getIntegerListFrom(dibArray)));
		int[] pklArray = { 504, 3901, 4801, 2240, 950, 990, 808, 1370, 900, 350, 2140, 2120 };
		data.add(new PieceOfTrend("PKL", getIntegerListFrom(pklArray)));
		int[] nisArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("NIS", getIntegerListFrom(nisArray)));
		return getSeriesJson(data);
	}

	private JSONObject getCardsGermanyPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] mnbArray = { 250, 2390, 1480, 2240, 2450, 2390, 2508, 2370, 2200, 2350, 2240, 920 };
		data.add(new PieceOfTrend("MNB", getIntegerListFrom(mnbArray)));
		int[] jarvisArray = { 350, 1390, 2480, 2140, 4150, 1390, 3508, 4370, 1200, 1350, 1240, 1120 };
		data.add(new PieceOfTrend("Jarvis", getIntegerListFrom(jarvisArray)));
		int[] eagleEyeArray = { 650, 3490, 4801, 2440, 4450, 390, 508, 3370, 2300, 3350, 2410, 1520 };
		data.add(new PieceOfTrend("Eagle Eye", getIntegerListFrom(eagleEyeArray)));
		int[] codyArray = { 350, 3190, 4180, 2140, 4510, 3910, 5108, 3710, 2010, 3510, 2410, 1210 };
		data.add(new PieceOfTrend("Cody", getIntegerListFrom(codyArray)));
		return getSeriesJson(data);
	}

	private JSONObject getFraudUSAPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] igiArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("IGI", getIntegerListFrom(igiArray)));
		int[] cobaltArray = { 350, 3190, 4180, 2140, 4510, 3910, 5108, 3710, 2010, 3510, 2410, 1210 };
		data.add(new PieceOfTrend("Cobalt", getIntegerListFrom(cobaltArray)));
		int[] platformArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("Platform", getIntegerListFrom(platformArray)));
		int[] ngBetaArray = { 250, 2390, 1480, 2240, 2450, 2390, 2508, 2370, 2200, 2350, 2240, 920 };
		data.add(new PieceOfTrend("NGBeta", getIntegerListFrom(ngBetaArray)));
		return getSeriesJson(data);
	}

	private JSONObject getFraudUKPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] googlerArray = { 250, 2390, 1480, 2240, 2450, 2390, 2508, 2370, 2200, 2350, 2240, 920 };
		data.add(new PieceOfTrend("Googler", getIntegerListFrom(googlerArray)));
		int[] sqlInjectionDetectorArray = { 504, 3901, 4801, 2240, 950, 990, 808, 1370, 900, 350, 2140, 2120 };
		data.add(new PieceOfTrend("SQLInjectionDetector", getIntegerListFrom(sqlInjectionDetectorArray)));
		int[] socialSafegaurdsArray = { 350, 3190, 4180, 2140, 4510, 3910, 5108, 3710, 2010, 3510, 2410, 1210 };
		data.add(new PieceOfTrend("Social Safegaurds", getIntegerListFrom(socialSafegaurdsArray)));
		int[] hackIntimationArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("Hack Intimation", getIntegerListFrom(hackIntimationArray)));
		return getSeriesJson(data);
	}

	private JSONObject getFraudGermanyPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] bookReaderArray = { 250, 2390, 1480, 2240, 2450, 2390, 2508, 2370, 2200, 2350, 2240, 920 };
		data.add(new PieceOfTrend("BookReader", getIntegerListFrom(bookReaderArray)));
		int[] newProjectArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("NewProject", getIntegerListFrom(newProjectArray)));
		int[] testDataArray = { 650, 3490, 4801, 2440, 4450, 390, 508, 3370, 2300, 3350, 2410, 1520 };
		data.add(new PieceOfTrend("Test Data", getIntegerListFrom(testDataArray)));
		int[] loansValidatorArray = { 504, 3901, 4801, 2240, 950, 990, 808, 1370, 900, 350, 2140, 2120 };
		data.add(new PieceOfTrend("Loans Validator", getIntegerListFrom(loansValidatorArray)));
		return getSeriesJson(data);
	}

	private JSONObject getCardNGPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] referenceAppsArray = { 650, 3490, 4801, 2440, 4450, 390, 508, 3370, 2300, 3350, 2410, 1520 };
		data.add(new PieceOfTrend("Reference Apps", getIntegerListFrom(referenceAppsArray)));
		int[] apiGatewayArray = { 150, 1190, 1180, 1140, 1150, 1190, 1508, 1370, 1600, 1250, 1940, 1120 };
		data.add(new PieceOfTrend("API Gateway", getIntegerListFrom(apiGatewayArray)));
		int[] consulArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("Consul", getIntegerListFrom(consulArray)));
		int[] vaultControllerArray = { 350, 3190, 4180, 2140, 4510, 3910, 5108, 3710, 2010, 3510, 2410, 1210 };
		data.add(new PieceOfTrend("Vault Controller", getIntegerListFrom(vaultControllerArray)));
		return getSeriesJson(data);
	}

	private JSONObject getBapiPieData() throws JSONException {
		List<PieceOfTrend> data = new ArrayList<>();
		int[] cardControlArray = { 350, 3190, 4180, 2140, 4510, 3910, 5108, 3710, 2010, 3510, 2410, 1210 };
		data.add(new PieceOfTrend("Card Control", getIntegerListFrom(cardControlArray)));
		int[] coheranceCacheArray = { 504, 3901, 4801, 2240, 950, 990, 808, 1370, 900, 350, 2140, 2120 };
		data.add(new PieceOfTrend("Coherance Cache", getIntegerListFrom(coheranceCacheArray)));
		int[] tsysProxyArray = { 250, 2390, 1480, 2240, 2450, 2390, 2508, 2370, 2200, 2350, 2240, 920 };
		data.add(new PieceOfTrend("Tsys Proxy", getIntegerListFrom(tsysProxyArray)));
		int[] activeMQUpgradeArray = { 50, 390, 480, 240, 450, 390, 508, 370, 200, 350, 240, 120 };
		data.add(new PieceOfTrend("ActiveMQ Upgrade", getIntegerListFrom(activeMQUpgradeArray)));
		return getSeriesJson(data);
	}

	private JSONObject getSeriesJson(List<PieceOfTrend> data) throws JSONException {
		JSONObject seriesJson = new JSONObject();
		JSONArray dataArray = new JSONArray();
		for (PieceOfTrend pieceOfTrend : data) {
			JSONObject dataJson = new JSONObject();
			dataJson.put("name", pieceOfTrend.getName());
			dataJson.put("data", getDataArray(pieceOfTrend));
			dataArray.put(dataJson);
		}

		seriesJson.put("dataArray", dataArray);
		seriesJson.put("categories", getXAxisJsonArray());
		return seriesJson;
	}

	private JSONArray getXAxisJsonArray() {
		String[] monthsArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		return new JSONArray(Arrays.asList(monthsArray));
	}

	private JSONArray getDataArray(PieceOfTrend pieceOfTrend) {
		return new JSONArray(pieceOfTrend.getTrendValues());
	}

	private List<Integer> getIntegerListFrom(int[] array) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : array) {
			intList.add(i);
		}
		return intList;
	}
}
