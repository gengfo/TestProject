/*******************************************************************************
 * Copyright (c) 1998, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * 		dclarke - initial JPA Employee example using XML (bug 217884)
 * 	    ssmith  - mapped using annotations and simplified
******************************************************************************/
package gridcache.xml.model;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
	private static final long serialVersionUID = -4452413730199817745L;

	private int id;
	private String areaCode;
	private String number;
	private String type;
	private Employee owner;
	private long version;

	public PhoneNumber() {
	}

	public PhoneNumber(String type, String areaCode, String number) {
		this();
		setType(type);
		setAreaCode(areaCode);
		setNumber(number);
	}

	public long getVersion() {
		return version;
	}

	public String getAreaCode() { 
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getId() {
		return this.id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String pNumber) {
		this.number = pNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Employee getOwner() {
		return this.owner;
	}

	public void setOwner(Employee employee) {
		this.owner = employee;
		if (employee == null) {
			this.id = 0;
		} else {
			this.id = employee.getId();
		}
	}
	
	@Override
	public String toString() {
		return new StringBuffer()
			.append(super.toString())
			.append("(")
			.append(getId())
			.append(": ")
			.append(getType())
			.append(": ")
			.append(getAreaCode())
			.append("-")
			.append(getNumber())
			.append(")")
			.toString();
	}
}
