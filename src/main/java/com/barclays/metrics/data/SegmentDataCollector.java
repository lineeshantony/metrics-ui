package com.barclays.metrics.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.metrics.model.SegmentVO;

import app.reference.ReferenceDataService;
import app.reference.pojo.Geography;
import app.reference.pojo.Project;
import app.reference.pojo.Repo;
import app.reference.pojo.TransactionCycle;

@Component
public class SegmentDataCollector {

	private Map<String, List<SegmentVO>> segmentMap;
	
	@Autowired
	ReferenceDataService referenceDataService;
	
	public Map<String, List<SegmentVO>> getOrCreateSegmentMap() {
		if (segmentMap != null && !segmentMap.isEmpty()) {
			return segmentMap;
		}

		segmentMap = new HashMap<>();
		List<TransactionCycle> transactionCycles = referenceDataService.getTransactionCyclesByOrganization("org");
		List<SegmentVO> transactionCycleSegments = getTransactionCyclesAsSegmentList(transactionCycles);
		segmentMap.put("org", transactionCycleSegments);
		for (SegmentVO tcSegment : transactionCycleSegments) {
			List<Geography> geographies = referenceDataService
					.getGeographyByTransactionCycle(tcSegment.getSegmentKey());
			List<SegmentVO> geographySegments = getGeographiesAsSegmentList(geographies);
			segmentMap.put(tcSegment.getSegmentKey(), geographySegments);
			for (SegmentVO geographySegment : geographySegments) {
				List<Project> projects = referenceDataService.getProjectsByGeography(tcSegment.getSegmentKey(),
						geographySegment.getSegmentKey());
				List<SegmentVO> projectSegments = getProjectsAsSegmentList(projects);
				segmentMap.put(geographySegment.getSegmentKey(), projectSegments);
				for (SegmentVO projectSegment : projectSegments) {
					List<Repo> repos = referenceDataService.getReposByProject(tcSegment.getSegmentKey(),
							geographySegment.getSegmentKey(), projectSegment.getSegmentKey());
					List<SegmentVO> repoSegments = getReposAsSegmentList(repos);
					segmentMap.put(projectSegment.getSegmentKey(), repoSegments);
				}
			}

		}
		return segmentMap;
	}
	
	private List<SegmentVO> getTransactionCyclesAsSegmentList(List<TransactionCycle> transactionCycles) {
		List<SegmentVO> segmentVOs = new ArrayList<>();
		for (TransactionCycle transactionCycle : transactionCycles) {
			SegmentVO segmentVO = new SegmentVO(transactionCycle.getId(), transactionCycle.getTransactionCycleName());
			segmentVOs.add(segmentVO);
		}
		return segmentVOs;
	}

	private List<SegmentVO> getGeographiesAsSegmentList(List<Geography> geographies) {
		List<SegmentVO> segmentVOs = new ArrayList<>();
		for (Geography geography : geographies) {
			SegmentVO segmentVO = new SegmentVO(geography.getId(), geography.getGeographyName());
			segmentVOs.add(segmentVO);
		}
		return segmentVOs;
	}

	private List<SegmentVO> getProjectsAsSegmentList(List<Project> projects) {
		List<SegmentVO> segmentVOs = new ArrayList<>();
		for (Project project : projects) {
			SegmentVO segmentVO = new SegmentVO(project.getId(), project.getProjectName());
			segmentVOs.add(segmentVO);
		}
		return segmentVOs;
	}

	private List<SegmentVO> getReposAsSegmentList(List<Repo> repos) {
		List<SegmentVO> segmentVOs = new ArrayList<>();
		for (Repo repo : repos) {
			SegmentVO segmentVO = new SegmentVO(repo.getId(), repo.getName());
			segmentVOs.add(segmentVO);
		}
		return segmentVOs;
	}
}
