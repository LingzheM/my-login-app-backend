package com.example.myapp.dto;

import java.util.List;

public class ExperienceInfoDTO {
	/**
	 * experienceHistory: Array<{
        startTime: string;
        endTime: string;
        projectName: string;
        japaneseTarget: boolean;
        workingPlace: string;
        member: number;
        industry: string;
        codeEnviorment: string;
        serverEnviorment: string;
        programLanguage: string;
        databases: string;
        ide: string;
        responsibility: string;
        youken: boolean;
        chousa: boolean;
        kihon: boolean;
        shousai: boolean;
        coding: boolean;
        tantai: boolean;
        ketsugou: boolean;
        sougou: boolean;
        kousei: boolean;
        hoshu: boolean;
        remark: string;
    }>
	 */
	
	private List<ExperienceHistory> experienceHistory;
	
	
	public List<ExperienceHistory> getExperienceHistory() {
		return experienceHistory;
	}


	public void setExperienceHistory(List<ExperienceHistory> experienceHistory) {
		this.experienceHistory = experienceHistory;
	}


	public static class ExperienceHistory {
		private String startTime;
		private String endTime;
		private String projectName;
		private boolean japaneseTarget;
		private String workingPlace;
		private int member;
		private String industry;
		private String codeEnviorment;
		private String serverEnviorment;
		private String programLanguage;
		private String databases;
		private String ide;
		private String responsibility;
		private boolean youken;
		private boolean chousa;
		private boolean kihon;
		private boolean shousai;
		private boolean coding;
		private boolean tantai;
		private boolean ketsugou;
		private boolean sougou;
		private boolean kousei;
		private boolean hoshu;
		private String remark;
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public boolean getJapaneseTarget() {
			return japaneseTarget;
		}
		public void setJapaneseTarget(boolean japaneseTarget) {
			this.japaneseTarget = japaneseTarget;
		}
		public String getWorkingPlace() {
			return workingPlace;
		}
		public void setWorkingPlace(String workingPlace) {
			this.workingPlace = workingPlace;
		}
		public int getMember() {
			return member;
		}
		public void setMember(int member) {
			this.member = member;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public String getCodeEnviorment() {
			return codeEnviorment;
		}
		public void setCodeEnviorment(String codeEnviorment) {
			this.codeEnviorment = codeEnviorment;
		}
		public String getServerEnviorment() {
			return serverEnviorment;
		}
		public void setServerEnviorment(String serverEnviorment) {
			this.serverEnviorment = serverEnviorment;
		}
		public String getProgramLanguage() {
			return programLanguage;
		}
		public void setProgramLanguage(String programLanguage) {
			this.programLanguage = programLanguage;
		}
		public String getDatabases() {
			return databases;
		}
		public void setDatabases(String databases) {
			this.databases = databases;
		}
		public String getIde() {
			return ide;
		}
		public void setIde(String ide) {
			this.ide = ide;
		}
		public String getResponsibility() {
			return responsibility;
		}
		public void setResponsibility(String responsibility) {
			this.responsibility = responsibility;
		}
		public boolean isYouken() {
			return youken;
		}
		public void setYouken(boolean youken) {
			this.youken = youken;
		}
		public boolean isChousa() {
			return chousa;
		}
		public void setChousa(boolean chousa) {
			this.chousa = chousa;
		}
		public boolean isKihon() {
			return kihon;
		}
		public void setKihon(boolean kihon) {
			this.kihon = kihon;
		}
		public boolean isShousai() {
			return shousai;
		}
		public void setShousai(boolean shousai) {
			this.shousai = shousai;
		}
		public boolean isCoding() {
			return coding;
		}
		public void setCoding(boolean coding) {
			this.coding = coding;
		}
		public boolean isTantai() {
			return tantai;
		}
		public void setTantai(boolean tantai) {
			this.tantai = tantai;
		}
		public boolean isKetsugou() {
			return ketsugou;
		}
		public void setKetsugou(boolean ketsugou) {
			this.ketsugou = ketsugou;
		}
		public boolean isSougou() {
			return sougou;
		}
		public void setSougou(boolean sougou) {
			this.sougou = sougou;
		}
		public boolean isKousei() {
			return kousei;
		}
		public void setKousei(boolean kousei) {
			this.kousei = kousei;
		}
		public boolean isHoshu() {
			return hoshu;
		}
		public void setHoshu(boolean hoshu) {
			this.hoshu = hoshu;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		
	}

}
