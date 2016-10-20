package org.springframework.samples.mvc.javapoc.existingcases;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Cases {
		private String refno;
		private String firstname;
		private String lastname;
		private String circumstance;
		private String callCenter;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate regDate;

		public Cases() {
		}

		public Cases(String refno, String firstname, String lastname, String circumstance, LocalDate regDate,String callCenter) {
			super();
			this.refno = refno;
			this.firstname = firstname;
			this.lastname = lastname;
			this.circumstance = circumstance;
			this.regDate = regDate;
			this.callCenter=callCenter;
		}
		public String getRefno() {
			return refno;
		}
		public void setRefno(String refno) {
			this.refno = refno;
		}
		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getCircumstance() {
			return circumstance;
		}

		public void setCircumstance(String circumstance) {
			this.circumstance = circumstance;
		}

		public LocalDate getRegDate() {
			return regDate;
		}

		@Override
		public String toString() {
			return "Cases [refno=" + refno + ", firstname=" + firstname + ", lastname=" + lastname + ", circumstance="
					+ circumstance + ", regDate=" + regDate + ",callCenter=" + callCenter +"]";
		}

		public void setRegDate(LocalDate regDate) {
			this.regDate = regDate;
		}

		public String getCallCenter() {
			return callCenter;
		}

		public void setCallCenter(String callCenter) {
			this.callCenter = callCenter;
		}
		
	}
