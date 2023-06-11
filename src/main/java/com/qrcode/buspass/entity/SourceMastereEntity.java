package com.qrcode.buspass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "source_master", schema ="public")
	public class SourceMastereEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "source_id")
		private Integer sourceId;
		
		@Column(name = "source_name")
		private String sourceName;
		public Integer getSourceId() {
			return sourceId;
		}
		public void setSourceId(Integer sourceId) {
			this.sourceId = sourceId;
		}
		public String getSourceName() {
			return sourceName;
		}
		public void setSourceName(String sourceName) {
			this.sourceName = sourceName;
		}
}
