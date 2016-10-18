package org.springframework.samples.mvc.javapoc.existingcases;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Cases {
//		private String firstname;
//		private String lastname;
//		private String email;
//		private String phone;
		
		private String refno;
		private String firstname;
		private String lastname;
		private String circumstance;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate regDate;
		
		

		public Cases() {
		}

		public Cases(String refno, String firstname, String lastname, String circumstance, LocalDate regDate) {
			super();
			this.refno = refno;
			this.firstname = firstname;
			this.lastname = lastname;
			this.circumstance = circumstance;
			this.regDate = regDate;
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
					+ circumstance + ", regDate=" + regDate + "]";
		}

		public void setRegDate(LocalDate regDate) {
			this.regDate = regDate;
		}





		
		
		
//		public Cases(String firstname, String lastname, String email, String phone) {
//			this.firstname = firstname;
//			this.lastname = lastname;
//			this.email = email;
//			this.phone = phone;
//		}
//
//		public String getFirstname() {
//			return firstname;
//		}
//
//		public void setFirstname(String firstname) {
//			this.firstname = firstname;
//		}
//
//		public String getLastname() {
//			return lastname;
//		}
//
//		public void setLastname(String lastname) {
//			this.lastname = lastname;
//		}
//
//		public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}
//
//		public String getPhone() {
//			return phone;
//		}
//
//		public void setPhone(String phone) {
//			this.phone = phone;
//		}
		
		
	}
